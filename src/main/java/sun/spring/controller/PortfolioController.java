package sun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub/portfolio")
public class PortfolioController {
	
	@RequestMapping("list")
	public String list() {
		return "/sub/portfolio/list";
	}
	
	@RequestMapping("bookhi")
	public String bookhi() {
		return "/sub/portfolio/bookhi";
	}
	
	@RequestMapping("chateng")
	public String chateng() {
		return "/sub/portfolio/chateng";
	}
	
	@RequestMapping("ebara")
	public String ebara() {
		return "/sub/portfolio/ebara";
	}
	
	@RequestMapping("everymonday")
	public String everymonday() {
		return "/sub/portfolio/everymonday";
	}
	
	@RequestMapping("mirun")
	public String mirun() {
		return "/sub/portfolio/mirun";
	}
	
	@RequestMapping("openend")
	public String openend() {
		return "/sub/portfolio/openend";
	}
	
	@RequestMapping("ourhome")
	public String ourhome() {
		return "/sub/portfolio/ourhome";
	}
	
	@RequestMapping("smartel")
	public String smartel() {
		return "/sub/portfolio/smartel";
	}
}
