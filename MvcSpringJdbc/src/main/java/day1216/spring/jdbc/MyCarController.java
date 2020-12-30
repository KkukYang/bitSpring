package day1216.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mycar.data.MyCarDao;
import mycar.data.MyCarDto;

@Controller
public class MyCarController {

	@Autowired
	MyCarDao dao;

	@RequestMapping({ "/", "/list" })
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();

		List<MyCarDto> list = dao.getAllDatas();
		System.out.println("list.size() : " + list.size());
		System.out.println("list : " + list);

		model.addObject("totalCount", list.size());
		model.addObject("list", list);
		model.setViewName("mycar/list");
		return model;
	}

	@GetMapping("/carform")
	public String goForm() {
		return "mycar/writeform";
	}

	@PostMapping("/read")
	public String dataRead(@ModelAttribute MyCarDto dto) {
		dao.insertCar(dto);
		return "redirect:list";
	}

	@GetMapping("/updateform")
	public ModelAndView updateForm(@RequestParam String num) {
		ModelAndView model = new ModelAndView();

		MyCarDto dto = dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("mycar/updateform");

		return model;
	}

	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto) {
		dao.updateCar(dto);
		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		dao.deleteCar(num);
		return "redirect:list";
	}

}
