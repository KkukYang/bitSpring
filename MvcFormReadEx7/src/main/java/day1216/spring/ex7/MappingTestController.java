package day1216.spring.ex7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MappingTestController {

	@GetMapping("/mapping")
	public String gomapping() {
		return "views/mappingtest";
	}

	// 여러개의 매핑주소가 같은 로직을 처리하고자 할 경우.
	@GetMapping({ "/board/list", "/guest/list", "/member/list" })
	public String list() {

		return "views/list";
	}

	
	@GetMapping("/shop/{path1}")
	public String changeUrl(Model model
//			, @PathVariable("path1") String path1
			, @PathVariable("path1") String p1) {

		if (p1.equals("cart")) {
			model.addAttribute("msg", "printed contents of cart.");
		} else if (p1.equals("list")) {
			model.addAttribute("msg", "printed contents of list.");
		} else if (p1.equals("save")) {
			model.addAttribute("msg", "printed contents of save.");
		}

		model.addAttribute("mypath", p1);

		return "views/list2";
	}

	//매핑주고사 겹칠경우 매핑주소가 확실하게 정의된 메서드가 우선 호출됨.
	@GetMapping("/shop/list")
	public String goList(Model model) {
		model.addAttribute("msg", "it is shop/list but will be processed independent logic.");
		model.addAttribute("mypath", "list");

		return "views/list2";
	}
}
