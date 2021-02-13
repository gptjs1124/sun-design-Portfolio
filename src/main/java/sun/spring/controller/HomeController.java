package sun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		/* 잘 들어갔는지 테스트 */
		/* 잘 들어갔는지 테스트 */
		/* 잘 들어갔는지 테스트 */
		return "index";
	}
	
}
