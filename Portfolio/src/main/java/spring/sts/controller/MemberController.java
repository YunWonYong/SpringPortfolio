package spring.sts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.file.utility.Utility;
import spring.portfolio.model.MemberDAO;
import spring.portfolio.model.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value="/member/create",method = RequestMethod.GET)
	public ModelAndView create(){
			ModelAndView mv=new ModelAndView();
			mv.setViewName("/member/create");
		return mv;
	}
	@RequestMapping(value="/member/createProc",method=RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request,MemberDTO dto){
			String upDir = request.getRealPath("/storage/member");
			String fileName=null;
			if(dto.getFileMF().getSize()>0){
				fileName= Utility.saveFile(dto.getFileMF(),upDir);
			}else{
				fileName="Member.jpg";  
			}
			dto.setPhoto(fileName);
			ModelAndView mv=new ModelAndView();
			if(dao.crate(dto)){
				mv.setViewName("redirect:/");
			}
		return mv;
	}
	@RequestMapping(value="/member/idCheck",method=RequestMethod.GET)
	public ModelAndView idcheck(String id){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/member/id_Check");
		mv.addObject("id", id);
		return mv;
	}
	@RequestMapping(value="/member/idCheckProc",method=RequestMethod.POST)
	public ModelAndView idcheck(MemberDTO dto){
		ModelAndView mv=new ModelAndView();
		int cnt=dao.id_Check(dto.getId());
		mv.setViewName("/member/id_CheckProc");
		mv.addObject("cnt",cnt);
		mv.addObject("id",dto.getId());
		return mv;
	}
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/member/login"); 
		return mv;
	}
	@RequestMapping(value="/member/loginProc",method=RequestMethod.POST)
	public ModelAndView login(HttpSession session,String id,String passwd){
		ModelAndView mv=new ModelAndView();
		Map map=new HashMap();
		map.put("id",id);
		map.put("passwd", passwd);
		int login=dao.login(map);
		if(login>0){
			session.setAttribute("id", id);
			String grade=dao.getGrade(id);
			session.setAttribute("grade",grade);
			String photo=dao.getPhoto(id);
			session.setAttribute("photo", photo);
			mv.setViewName("redirect:/");
		}else{
			mv.setViewName("/error/member/login");
		}
		return mv;
	}
	@RequestMapping(value="/member/logout")
	public ModelAndView logout(HttpSession session){
		ModelAndView mv=new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	} 
	@RequestMapping(value="/member/update")
	public ModelAndView update(HttpSession session,String id){
		ModelAndView mv=new ModelAndView();
		if(id==null){
			id=session.getId(); 
		}
		mv.addObject("id",id); 
		mv.addObject("url","update");
		mv.setViewName("redirect:/member/passwdCheck");
		return mv;
	}
	@RequestMapping(value="/member/passwdCheck")
	public ModelAndView passwdCheck(HttpSession session,String url,String id){
		ModelAndView mv=new ModelAndView();
		if(id==null){
			id=session.getId();
		} 
		MemberDTO dto=(MemberDTO)dao.read(id);
		mv.addObject("url",url);
		mv.addObject("dto", dto);
		mv.setViewName("/member/passwdCheck");
		return mv; 
	} 
	@RequestMapping(value="/member/passwdCheckProc",method=RequestMethod.POST)
	public ModelAndView passwdCheck(String url,String id,MemberDTO dtos,HttpSession session){
		ModelAndView mv=new ModelAndView();
		Map map=new HashMap();
		map.put("id",id);
		map.put("passwd", dtos.getPasswd());
		int num=dao.passwdCheck(map);
		System.out.println(num);
		System.out.println(url);
		String view="/member/"+url;
		MemberDTO dto=(MemberDTO)dao.read(id);
		if(num==1){
				mv.setViewName(view);
				mv.addObject("dto",dto); 
		}else{
			mv.setViewName("/error/member/passwdCheck");
		}
		return mv;
	}
	@RequestMapping(value="/member/updateProc",method=RequestMethod.POST)
	public ModelAndView update(HttpSession session,MemberDTO dto,String id){
		ModelAndView mv=new ModelAndView();
		if(id==null){
			id=session.getId();
		}
		if(dao.update(dto)){
			mv.setViewName("redirect:./updateread");
			mv.addObject("id", id);
		}else{
			mv.setViewName("/error/member/updateError");
		}
		
		return mv;
	}
	@RequestMapping(value="/member/fileupdate",method=RequestMethod.GET)
	public ModelAndView fileupdate(HttpSession session,String id,String photo){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/member/fileupdate"); 
		if(id==null){
			id=session.getId();
		}
		if(photo==null){
			photo=(String)session.getAttribute("photo");
		}
		mv.addObject("id",id);
		mv.addObject("photo", photo);
		return mv;
	}
	@RequestMapping(value="/member/filupdateProc",method=RequestMethod.POST)
	public ModelAndView fileupdate(HttpSession session,MemberDTO dto,String id,String oldFile){
		ModelAndView mv=new ModelAndView();
		if(id==null){
			id=session.getId(); 
		}
		String filename=null;
		String upDir="/storage/member";
		if(dto.getFileMF().getSize()>0){
			filename=Utility.saveFile(dto.getFileMF(),upDir);
			Utility.deleteFile(upDir, oldFile);
		} 
		dto.setPhoto(filename); 
		Map map=new HashMap();
		map.put("id", id);
		map.put("photo", dto.getPhoto());
		if(dao.fileupdate(map)){
			mv.setViewName("redirect:./updateread");
			mv.addObject("id",id);
		}else{
			mv.setViewName("error/member/fileupdateError"); 
		}
		return mv;
	}
	@RequestMapping(value="/member/updateread")
	public ModelAndView updateread(HttpSession session,String id){
		ModelAndView mv=new ModelAndView();
		MemberDTO dto=(MemberDTO)dao.read(id);
		mv.addObject("dto", dto);
		mv.setViewName("/member/updateread");
		return mv;
	}
	@RequestMapping(value="/member/read")
	public ModelAndView read(HttpSession session,String id){
		ModelAndView mv=new ModelAndView();
		if(id==null){
			id= session.getId();
		}
		mv.addObject("id",id); 
		mv.addObject("url","read");
		mv.setViewName("redirect:/member/passwdCheck");
		return mv;
	}
	@RequestMapping(value="/member/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		String col=Utility.checkNull(request.getParameter("col"));
		String word=Utility.checkNull(request.getParameter("word"));
		if(col.equals("total")){
			word="";
		}
		int nowPage =1;
		int recordPerPage=5;
		if(request.getParameter("nowPage")!=null){
			nowPage=Integer.parseInt(request.getParameter("nowPage"));
		}
		int sno=((nowPage-1)*recordPerPage)+1;
		int eno=nowPage*recordPerPage;
		Map map=new HashMap();
		map.put("col",col);
		map.put("word",word);
		map.put("sno",sno);
		map.put("eno",eno);
		int total=dao.total(map);
		List<Object> list=dao.list(map);
		String paging=Utility.paging3(total, nowPage, recordPerPage, col, word);
		mv.setViewName("/member/list");
		mv.addObject("list", list);
		mv.addObject("paging",paging);
		return mv;
	}
}
