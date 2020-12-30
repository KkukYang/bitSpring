package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardServiceInter;
import spring.dto.ReBoardDto;

@Controller
public class BoardContentController {
	@Autowired
	private BoardServiceInter service;
	
	@GetMapping("/board/content")
	public ModelAndView goContent(@RequestParam String num
			, @RequestParam String pageNum
			, @RequestParam(required = false) String key
			) {

		
		ModelAndView mview = new ModelAndView();
		
		if(key!= null) {
			service.updateReadCount(num);
		}
		
		ReBoardDto dto = service.getData(num);
		mview.addObject("dto",dto);
		mview.addObject("pageNum",pageNum);
		
		mview.setViewName("/sub/board/content");
		return mview;
	}
}
