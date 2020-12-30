package day1215.spring.ex5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String form1() {
		return "formtag/myform1";
	}

	@GetMapping("/read")
	public ModelAndView dataRead(
//			@RequestParam("food") String food
			@RequestParam String food /* name 과 읽을 변수명이 같을경우 name생략가능. */
			) {
		ModelAndView model = new ModelAndView();
//		System.out.println(food);

		model.addObject("food", food);
		model.setViewName("formtag/myfood");

		return model;
	}

}
