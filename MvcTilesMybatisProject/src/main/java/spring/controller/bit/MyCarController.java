package spring.controller.bit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.MyCarDao;
import spring.dto.MyCarDto;

@Controller
public class MyCarController {

	@Autowired
	MyCarDao dao;

	@GetMapping("/mycar/list")
	public String goCarList(Model model) {

		int totalCount = dao.getTotalCount();

		List<MyCarDto> list = dao.getAllDatas();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);

		// return -> tiles return
		// /sub(layout2) / mycar(folderName) / list(fileName)
		return "/sub/mycar/list"; // 이렇게 주면 차정보 메뉴 클릭시 두번째 레이아웃이 적용됨.
	}

	@GetMapping("/mycar/carform")
	public String mycarForm() {

		return "/sub/mycar/writeform";
	}

	@GetMapping("/mycar/updateform")
	public ModelAndView mycarUpdateForm(@RequestParam String num) {
		ModelAndView model = new ModelAndView();
		MyCarDto dto = dao.getData(num);

		model.addObject("dto", dto);
		model.setViewName("/sub/mycar/updateform");
		return model;
	}

}
