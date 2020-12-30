package day1216.spring.ex7;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import day1216.data.ShopDto;

@Controller
public class FormReadController {

	@GetMapping("/form1")
	public String form1() {
		return "formtag/myform1";
	}

	@GetMapping("/form2")
	public String form2() {
		return "formtag/myform2";
	}

	@GetMapping("/form3")
	public String form3() {
		return "formtag/myform3";
	}

//////////////////////////////////////////////////////////////////////////////	
	@PostMapping("/read1")
	public ModelAndView readForm1(@RequestParam String name, @RequestParam int java, @RequestParam int spring,
			@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		ModelAndView model = new ModelAndView();

		model.addObject("name", name);
		model.addObject("java", java);
		model.addObject("spring", spring);
		model.addObject("tot", java + spring);
		model.addObject("avg", (java + spring) / 2.0);
		model.addObject("currentPage", currentPage);

		// forward path.
		model.setViewName("result/formresult1");

		return model;
	}

//////////////////////////////////////////////////////////////////////////////
	// @PostMapping("/read2")
	@RequestMapping(value = "/read2", method = RequestMethod.POST)
	// @ModelAttribute : 같은 이름의 멤버를 읽어옴.
	// 이때 해당 dto는 request 에 저장됨(클래스타입으름으로(첫글자는 소문자) : shopDto
	// request 에 다른이름으로 저장하고 싶을경우 @ModelAttribute("dto")
	// 이렇게 주면 request 에 dto 이름으로 저장됨.
	public String formRead2(@ModelAttribute("dto") ShopDto dto) {
//	public String formRead2(@ModelAttribute ShopDto dto) {
		return "result/formresult2";
	}

//////////////////////////////////////////////////////////////////////////////	
	@PostMapping("/read3")
	//map 으로 읽을경우 폼의 name 이 key값으로, 입력값이 value 값으로 저장.
	public ModelAndView formRead3(@RequestParam Map<String, String> map) {
		ModelAndView model = new ModelAndView();

		model.addObject("name", map.get("name"));
		model.addObject("blood", map.get("blood"));
		model.addObject("age", map.get("age"));
		model.addObject("hp", map.get("hp"));
		model.addObject("addr", map.get("addr"));
		
		model.setViewName("result/formresult3");
		return model;
	}

//////////////////////////////////////////////////////////////////////////////	

}
