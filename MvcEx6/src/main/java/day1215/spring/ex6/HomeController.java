package day1215.spring.ex6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@GetMapping("/")
	public String form1() {
		return "stu/stuform";
	}

	@GetMapping("/sturead")
	public ModelAndView dataRead(
//			@RequestParam("food") String food
			@RequestParam String score /* name 과 읽을 변수명이 같을경우 name생략가능. */
			, @RequestParam String name /* name 과 읽을 변수명이 같을경우 name생략가능. */
			) {
		ModelAndView model = new ModelAndView();
//		System.out.println(food);
		
		model.addObject("score", score);
		model.addObject("name", name);
		model.setViewName("stu/stuscore");

		return model;
	}
}
