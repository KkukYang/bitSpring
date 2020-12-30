package day1217.spring.upload;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import upload.util.SpringFileWriter;

@Controller
public class SpringUploadController {

	@GetMapping("/")
	public String start() {
		return "start";
	}

	@GetMapping("/upload/one")
	public String form1() {
		return "uploadform1";
	}

	@GetMapping("/upload/multi")
	public String form2() {
		return "uploadform2";
	}

	@PostMapping("/upload/saveone")
	public ModelAndView upload1(@RequestParam MultipartFile photo, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();

		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println("path:" + path);

//		Calendar cal = Calendar.getInstance();
//		String fileName = String.format("photo_%04d%02d%02d_%02d%02d%02d_%s", cal.get(Calendar.YEAR),
//				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY),
//				cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), photo.getOriginalFilename());

		SpringFileWriter writer = new SpringFileWriter();
		String fileName = writer.changeFilename(photo.getOriginalFilename());
		writer.writeFile(photo, fileName, path);

		model.addObject("path", path);
		model.addObject("photo", fileName);
		model.setViewName("result1");
		return model;
	}

	@PostMapping("/upload/savemulti")
	public ModelAndView upload2(@RequestParam ArrayList<MultipartFile> photos, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();

		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(path);

		List<String> fileNames = new ArrayList<String>();
		SpringFileWriter writer = new SpringFileWriter();

		for (MultipartFile f : photos) {
			// 이미지명 변경.
			String changeFilename = writer.changeFilename(f.getOriginalFilename());
			fileNames.add(changeFilename);
			writer.writeFile(f, changeFilename, path);
		}

		model.addObject("list", fileNames);
		model.setViewName("result2");
		return model;
	}

}



