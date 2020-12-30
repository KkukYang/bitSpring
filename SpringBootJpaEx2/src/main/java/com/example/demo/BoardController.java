package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	MycarDao dao;

	@GetMapping({ "/", "/list" })
	public ModelAndView list() {
		System.out.println("list()");
		ModelAndView mview = new ModelAndView();
		mview.addObject("message", "messagemessage");

//		Map<String, String> map = new HashMap<String, String>();
//		map.put("asdf", "asdfasdf");
//		map.put("qwer", "qwerqwer");
//		
//		mview.addObject("map", map);

//		Iterable<MyCarDto> list = dao.getAllDatas();
//		int totalCount =((Collection<?>) list).size();
		List<MyCarDto> list = dao.getAllDatas();
		int totalCount = list.size();
		mview.addObject("list", list);
		mview.addObject("totalCount", totalCount);
		mview.setViewName("list");
		return mview;
	}

	@GetMapping("/carform")
	public String form() {
		return "writeform";
	}

	@GetMapping("/updateform")
	public ModelAndView gotoUpdateform(@RequestParam String num) {
		System.out.println("gotoUpdateform()");
		
		Long id = Long.parseLong(num);
		MyCarDto dto = dao.getData(id);
		ModelAndView mview =  new ModelAndView();

		mview.addObject("dto", dto);
		mview.setViewName("updateform");
		
		return mview;
	}

	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto) {
		System.out.println("update()");
		dao.updateCar(dto);
		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		System.out.println("delete()");

		Long id = Long.parseLong(num);
		dao.deleteCar(id);

		return "redirect:list";
	}

	@PostMapping("/read")
	public String read(@ModelAttribute MyCarDto dto) {
		System.out.println("read() -> insert");
		dao.insertCar(dto);
		return "redirect:list";
	}
}
