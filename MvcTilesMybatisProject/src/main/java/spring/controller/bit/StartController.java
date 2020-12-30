package spring.controller.bit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.MyCarDao;
import spring.dto.MyCarDto;

@Controller
public class StartController {

	@Autowired
	MyCarDao dao;

	@GetMapping({ "/", "/home" })
	public String goMain() {
//		return "/sub/layout/main2";// 2번째 레이아웃
		return "/layout/main";// 1번째 레이아웃
	}

	@PostMapping("/mycar/read")
	public String mycarRead(@ModelAttribute MyCarDto dto) {
		dao.insertCar(dto);
		return "redirect:list";
	}

	@PostMapping("/mycar/update")
	public String mycarUpdate(@ModelAttribute MyCarDto dto) {
		dao.updateCar(dto);
		return "redirect:list";
	}

	@GetMapping("/mycar/delete")
	public String mycarDelete(@RequestParam String num) {
		dao.deleteCar(num);
		return "redirect:list";
	}
}
