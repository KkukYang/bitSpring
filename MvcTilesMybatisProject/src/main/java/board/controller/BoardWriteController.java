package board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardServiceInter;
import spring.dto.ReBoardDto;
import upload.util.SpringFileWriter;

@Controller
public class BoardWriteController {

	@Autowired
	private BoardServiceInter service;

	@GetMapping("/board/writeform")
	public ModelAndView writeForm(@RequestParam(value = "num", defaultValue = "0") String num,
			@RequestParam(value = "regroup", defaultValue = "0") String regroup,
			@RequestParam(value = "restep", defaultValue = "0") String restep,
			@RequestParam(value = "relevel", defaultValue = "0") String relevel,
			@RequestParam(defaultValue = "1") String pageNum) {
		
		ModelAndView mview = new ModelAndView();
		
		mview.addObject("num", num);
		mview.addObject("regroup", regroup);
		mview.addObject("restep", restep);
		mview.addObject("relevel", relevel);
		mview.addObject("pageNum", pageNum);
		mview.setViewName("/sub/board/writeform");
		
		return mview;
	}

	@PostMapping("/board/write")
	public String write(HttpServletRequest request, @ModelAttribute ReBoardDto dto, @RequestParam String pageNum) {
		System.out.println("dto.pass:"+dto.getPass());

		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		String upload = "";
		SpringFileWriter writer = new SpringFileWriter();
		List<String> fileNames = new ArrayList<String>();

		for (MultipartFile file : dto.getFiles()) {
			if (file.getOriginalFilename().length() == 0) {
				upload = "no";
				break;
			}

			String changeFilename = writer.changeFilename(file.getOriginalFilename());
			fileNames.add(changeFilename);
			writer.writeFile(file, changeFilename, path);
		}

		String strListFileNames = fileNames.toString().replace(" ", "");
		
		if (strListFileNames != null && strListFileNames.length() > 2) {
			strListFileNames = strListFileNames.substring(1, strListFileNames.length() - 1);
		}
		
		System.out.println("strListFileNames:" + strListFileNames);
		System.out.println("photos:" + upload);
		
		if (!upload.equals("no")) {
			upload = strListFileNames;
		}

		dto.setUpload(upload);
		service.insertBoard(dto);

		return "redirect:list?pageNum=" + pageNum;
	}
}
