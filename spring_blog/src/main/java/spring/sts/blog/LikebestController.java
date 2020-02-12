package spring.sts.blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.notice.BestDAO;
import spring.model.notice.BestDTO;
import spring.model.notice.LikebestDAO;
import spring.model.notice.LikebestDTO;
import spring.model.notice.NoticeDAO;
import spring.model.notice.NoticeDTO;
import spring.utility.blog.Utility;

@Controller
public class LikebestController {

	@Autowired
	private LikebestDAO ldao;
	
	@Autowired
	private BestDAO bdao;
	
	
//	@RequestMapping("/likebest/list")
//    public String list(){
//		
//		return "/likebest/list";
//	}
	
	@RequestMapping("/likebest/list")
	public String list(Model model){
		
		List<LikebestDTO> list = ldao.list();
		
		model.addAttribute("list", list);
		
		return "/likebest/list";
		
	}
	
	@RequestMapping("/best/list")
	public String llist(Model model){
			LikebestDTO dto = new LikebestDTO();
			BestDTO bdto=null;
			List<LikebestDTO> list = ldao.list(); //데이터가져옴
			List<BestDTO> llist = bdao.llist();
			String id_list="";
			for(int i=0; i<llist.size(); i++){

			id_list+=llist.get(i).getChartid();
			if(i!=(llist.size()-1))
				id_list+=",";
			else
				continue;
			//bdao.create(llist.get(i));
				

		}
			Map map=new HashMap();
			map.put("id_list", id_list);
			
			map.put("week", Integer.parseInt(llist.get(0).getWeek()));
			bdao.create(map);
			
			System.out.println(id_list);
			System.out.println(list.size());
			System.out.println(llist.size());
			model.addAttribute("llist", llist);
			
			
		return "/best/list";
	}
	
	
}
