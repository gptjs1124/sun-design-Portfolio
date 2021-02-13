package sun.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sun.spring.dto.ContactDTO;
import sun.spring.service.ContactService;

@Controller
@RequestMapping("/sub/contact")
public class ContactController {
	String link = "/sub/contact/";
	
	@Autowired
	private ContactService cservice;
	
	@RequestMapping("write")
	public String write() {
		return link+"write";
	}
	
	@RequestMapping("writeProc")
	public String writeProc(ContactDTO conDTO,Model model) throws Exception{
		conDTO.setTel(conDTO.getSelTel() +" - "+ conDTO.getPhone01() +" - "+ conDTO.getPhone02());
		System.out.println(conDTO.getTel());
		int result = cservice.conInsert(conDTO);
		model.addAttribute("result",result);
		return "index";
	}

	@RequestMapping("listProc")
	public String listProc(Model model, int cpage) throws Exception{
		
		// 한 페이지당 10개씩 게시물 보이기
		List<ContactDTO> count10 = cservice.count10(cpage);
//		model.addAttribute("allBoardCount", count10);
		
		return link+"list";
	}
	
	@RequestMapping("viewProc")
	public String viewProc(ContactDTO cdto, Model model) throws Exception{
		ContactDTO conview = cservice.conView(cdto);
		model.addAttribute("conview", conview);
		return link+"view";
	}
	
	@RequestMapping("conDelete")
	public String conDelete(ContactDTO cdto) throws Exception{
		int deleteSecces = cservice.conDelete(cdto);
		return "redirect:"+link+"listProc";
	}
	
	@RequestMapping("conModify")
	public String conModify(ContactDTO cdto, Model model) throws Exception{
		model.addAttribute("cdto", cdto);
		return link+"modify";
	}
	
	@RequestMapping("conModifyProc")
	public String conModifyProc(ContactDTO cdto) throws Exception{
		int deleteSecces = cservice.conModify(cdto);
		return "redirect:"+link+"listProc";
	}

}



























