package spring.sts.blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.model.notice.LikebestDAO;
import spring.model.notice.LikebestDTO;
import spring.model.notice.NoticeDAO;
import spring.model.notice.NoticeDTO;
import spring.utility.blog.Utility;

@Controller
public class NoticeController {
	@Autowired
	private NoticeDAO ndao;
	@Autowired
	private LikebestDAO ldao;
	
	
	@RequestMapping("/admin/delete")
	public String delete(int noticeid, String col, String word, String nowPage, Model model, HttpServletRequest request){
		
		
//		Map map = new HashMap();
//		map.put("no", no);
//		map.put("passwd", passwd);
//		boolean pflag = dao.passCheck(map);
//		if(pflag){
//			if(dao.delete(no)){
//			model.addAttribute("col", col);
//			model.addAttribute("word", word);
//			model.addAttribute("nowPage", nowPage);
//			return "redirect:../notice/list";		
//			}else{
//				return "error";
//			}
//			
//			}else{
//			return "passwdError";
//		}
		
		Map map = new HashMap();
		map.put("noticeid", noticeid);                     
		boolean flag = ndao.ndelete(noticeid);
		String url = "";
		if(flag){
			try{
			ndao.ndelete(noticeid);
			model.addAttribute("col", col);
			model.addAttribute("word", word);
			model.addAttribute("nowPage", nowPage);
			url = "redirect:../notice/list";
			}catch(Exception e){
				   e.printStackTrace();
	               url = "error";
			}
		}
		return url;
	}
	
//	@RequestMapping(value="/admin/delete", method=RequestMethod.GET)
//	public String delete(int no, Model model){
//		
//		model.addAttribute("flag", ndao.ndelete(no));
//		
//		return "/notice/delete";
//	}
	
//	@RequestMapping(value="/bbs/reply", method=RequestMethod.POST)
//	public String reply(BbsDTO dto, Model model, String col, String word, String nowPage, HttpServletRequest request){
//		
//		String basePath = request.getRealPath("/bbs/storage");
//		int filesize = (int)dto.getFileMF().getSize();
//		String filename ="";
//		if(filesize>0){
//			filename = Utility.saveFile(dto.getFileMF(), basePath);
//		}
//		dto.setFilename(filename);
//		dto.setFilesize(filesize);
//		
//		Map map = new HashMap();
//		map.put("grpno", dto.getGrpno());
//		map.put("ansnum", dto.getAnsnum());
//		dao.upAnsnum(map);
//		boolean flag = dao.createReply(dto);
//		
//		if(flag){
//			model.addAttribute("col", col);
//			model.addAttribute("word", word);
//			model.addAttribute("nowPage", nowPage);
//			
//			
//			return "redirect:./list";
//		}else{
//			return "error";
//		}
//
//	}
//	
//	@RequestMapping(value="/bbs/reply", method=RequestMethod.GET)
//	public String reply(int bbsno, Model model){
//		
//		model.addAttribute("dto", dao.readReply(bbsno));
//		
//		return "/bbs/reply";
//	}
	
	
	
	@RequestMapping(value="/notice/update", method=RequestMethod.POST)
	public String update(NoticeDTO dto, String col, String nowPage, String word, Model model, HttpServletRequest request){
		
		
		Map map = new HashMap();
		map.put("noticeid", dto.getNoticeid());
		boolean flag = ndao.nupdate(dto);
		String url = "";
		if(flag){
			if(ndao.nupdate(dto)){
			model.addAttribute("col", col);
			model.addAttribute("word", word);
			model.addAttribute("nowPage", nowPage);
			return "redirect:../notice/list";		
			}else{
				return "error";
			}
			
			}else{
			return url;
		}
		
		
	}
	
	@RequestMapping(value="/admin/update", method= RequestMethod.GET)
	public String update(int noticeid, Model model){
		
		model.addAttribute("dto", ndao.nread(noticeid));
		
		
		return "/notice/updateForm";
	}
	
	@RequestMapping(value="/notice/update2", method=RequestMethod.POST)
	public String pupdate(NoticeDTO dto, String col, String nowPage, String word, Model model, HttpServletRequest request){
		
		
		Map map = new HashMap();
		map.put("noticeid", dto.getNoticeid());
		boolean flag = ndao.pupdate(dto);
		String url = "";
		if(flag){
			if(ndao.pupdate(dto)){
			model.addAttribute("col", col);
			model.addAttribute("word", word);
			model.addAttribute("nowPage", nowPage);
			return "redirect:../notice/paging";		
			}else{
				return "error";
			}
			
			}else{
			return url;
		}
		
		
	}
	
	
	
	@RequestMapping(value="/admin/update2", method= RequestMethod.GET)
	public String pupdate(int noticeid, Model model){
		
		model.addAttribute("dto", ndao.nread(noticeid));
		
		
		return "/notice/updateForm2";
	}
	
//	@RequestMapping(value="/infiniteScrollDown",method = RequestMethod.POST)
//	public @ResponseBody List<NoticeDTO> infiniteScrollDownPOST(@ResponseBody NoticeDTO noticeDTO){
//		
//		return
//	}
//	
	
	
	
	@RequestMapping("/notice/read")
	public String read(int nowPage, String col, String word, int noticeid, Model model, HttpServletRequest request){
//		ndao.upViewcnt(noticeid);
		
		NoticeDTO dto = ndao.nread(noticeid);
		dto.setContent(dto.getContent().replaceAll("\r\n","<br>"));
		
		model.addAttribute("dto", dto);
		
		return "/notice/read";
	}
	
	
	@RequestMapping(value="/admin/create", method= RequestMethod.POST)
	public String create(NoticeDTO dto, HttpServletRequest request){
		
		boolean flag = ndao.ncreate(dto);
		
		if(flag){
			return "redirect:../notice/list";
		}else{
			return "error";
		}
		
	}
	
	@RequestMapping(value="/admin/create", method= RequestMethod.GET)
	public String create(){
			
		return "/notice/create";
	}
	
	@RequestMapping("/notice/paging")
	public String plist(HttpServletRequest request){
		//--------------검색-----------------
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		if(col.equals("total")){
			word="";
		}
	
		//----------------------페이지간련----------------------
		int nowPage = 1
				; // 현재 보고 있는 페이지
		if(request.getParameter("nowPage")!=null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 15; //한페이지당 보여줄 레코드 갯수
		int morePage = nowPage + 1;
		
		//-------------DB에서 가져올 순번-------------------------
		int sno = ((nowPage-1)*recordPerPage) +1;
		int eno = nowPage * recordPerPage;
		
		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
//		map.put("morePage", morePage);
		map.put("nowPage", nowPage);
	List<NoticeDTO> plist = ndao.plist(map);
	int total = ndao.ntotal(col, word);
	String paging = Utility.paging5(total, nowPage, recordPerPage, col, word);
	
	request.setAttribute("col", col);
	request.setAttribute("word", word);
	request.setAttribute("nowPage", nowPage);
//	request.setAttribute("morePage", morePage);
	request.setAttribute("plist", plist);
	request.setAttribute("paging", paging);
	
	
		return "/notice/paging";
		
	}
	
	
	@RequestMapping("/notice/list")
	public String list(HttpServletRequest request){
		
		//--------------검색-----------------
				String col = Utility.checkNull(request.getParameter("col"));
				String word = Utility.checkNull(request.getParameter("word"));

				if(col.equals("total")){
					word="";
				}
			
				//----------------------페이지간련----------------------
				int nowPage = 1; // 현재 보고 있는 페이지
				if(request.getParameter("nowPage")!=null){
					nowPage = Integer.parseInt(request.getParameter("nowPage"));
				}
				int recordPerPage = 15; //한페이지당 보여줄 레코드 갯수
				//-------------DB에서 가져올 순번-------------------------
				int sno = ((nowPage-1)*recordPerPage) +1;
				int eno = nowPage * recordPerPage;
				
				Map map = new HashMap();
				map.put("col", col);
				map.put("word", word);
				map.put("sno", sno);
				map.put("eno", eno);
				map.put("nowPage", nowPage);
				
			List<NoticeDTO> list = ndao.nlist(map);
			int total = ndao.ntotal(col, word);
			String paging = Utility.paging4(total, nowPage, recordPerPage, col, word);
			

			request.setAttribute("col", col);
			request.setAttribute("word", word);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("paging", paging);
		
			request.setAttribute("list", list);
			
			
		return "/notice/list";
	}
	
	
}
