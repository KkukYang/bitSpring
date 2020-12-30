package spring.controller.bit;

import java.io.File;
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

import spring.dao.MemberDao;
import spring.dto.MemberDto;
import upload.util.SpringFileWriter;

@Controller
public class MemberController {

	@Autowired
	MemberDao dao;

	@GetMapping("/member/addform")
	public String goMemberForm() {
		return "/member/memberform";
	}

	@GetMapping("/member/list")
	public ModelAndView memberList() {
		System.out.println("memberList() called#########");
		ModelAndView model = new ModelAndView();

		int totalCount = dao.getAllMember().size();

		List<MemberDto> list = dao.getAllMember();

		for (MemberDto dto : list) {
			if (dto.getPhotos().equals("no")) {
				dto.setMainphoto("no");
			} else {
				String[] photos = dto.getPhotos().split(",");
				dto.setMainphoto(photos[0]);
			}
		}

		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.setViewName("/member/memberlist");
		return model;
	}

	@PostMapping("/member/savemember")
	public String insert(@ModelAttribute MemberDto dto, HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);

		String photos = "";
		List<String> fileNames = new ArrayList<String>();
		SpringFileWriter writer = new SpringFileWriter();

		for (MultipartFile f : dto.getUpload()) {

			if (f.getOriginalFilename().length() == 0) {
				photos = "no";
				break;
			}

			String changeFilename = writer.changeFilename(f.getOriginalFilename());
			fileNames.add(changeFilename);
			writer.writeFile(f, changeFilename, path);
		}

		String strListFileNames = fileNames.toString().replace(" ", "");

		if (strListFileNames != null && strListFileNames.length() > 2) {
			strListFileNames = strListFileNames.substring(1, strListFileNames.length() - 1);
		}

		System.out.println("strListFileNames:" + strListFileNames);
		System.out.println("photos:" + photos);

		if (!photos.equals("no")) {
			photos = strListFileNames;
		}

		dto.setPhotos(photos);
		dao.insertMember(dto);

		return "redirect:list";

	}

//	@GetMapping("/error/imgUploadErr")
//	public String maxUploadExceeded() {
//		
//		System.out.println("maxUploadExceeded()###########");
//		return "redirect:list";
//	}

	@GetMapping("/member/detail")
	public ModelAndView detail(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();

		MemberDto dto = dao.getMember(num);
		mview.addObject("dto", dto);
		mview.setViewName("/member/memberdetail");
		return mview;

	}

	@GetMapping("/member/deleteform")
	public ModelAndView deleteFrom(@RequestParam String num) {

		ModelAndView mview = new ModelAndView();
//		MemberDto dto = dao.getMember(num);
//
//		mview.addObject("dto", dto);
		mview.addObject("num", num);
		mview.setViewName("/member/deleteform");

		return mview;
	}

	@PostMapping("/member/delete")
	public String delete(@RequestParam String pass, @RequestParam String num, HttpServletRequest request) {
		System.out.println("delete() ###########");
		System.out.println("pass:" + pass);
		System.out.println("num:" + num);
		if (dao.getPassIsCheck(num, pass) == 0) {
			System.out.println("wrong password");
			return "/member/passfail";
		}

		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		String photos = dao.getMember(num).getPhotos();
		System.out.println("path:"+path);
		System.out.println("photos:"+photos);
		
		if (!photos.equals("no")) {
			String[] files = photos.split(",");

			for (String s : files) {
				File file = new File(path + "/" + s);
				if (file.exists()) {
					file.delete();
				}
			}
		}

		dao.deleteMember(num);
		return "redirect:list";
	}

	@GetMapping("/member/updateform")
	public ModelAndView updateForm(@RequestParam String num) {

		ModelAndView mview = new ModelAndView();
//		MemberDto dto = dao.getMember(num);

//		mview.addObject("dto", dto);
		mview.addObject("num", num);
		mview.setViewName("/member/updateform");

		return mview;
	}

	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto, HttpServletRequest request) {

		ModelAndView mview = new ModelAndView();

		if (dao.getPassIsCheck(dto.getNum(), dto.getPass()) == 0) {
			System.out.println("wrong password");
//			mview.setViewName("/member/passfail");
//			return mview;
			return "/member/passfail";
		}

		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);

		String photos = "";
		List<String> fileNames = new ArrayList<String>();
		SpringFileWriter writer = new SpringFileWriter();

		for (MultipartFile f : dto.getUpload()) {

			if (f.getOriginalFilename().length() == 0) {
				photos = null;
				break;
			}

			String changeFilename = writer.changeFilename(f.getOriginalFilename());
			fileNames.add(changeFilename);
			writer.writeFile(f, changeFilename, path);
		}

		String strListFileNames = fileNames.toString().replace(" ", "");

		if (strListFileNames != null && strListFileNames.length() > 2) {
			strListFileNames = strListFileNames.substring(1, strListFileNames.length() - 1);
		}

		System.out.println("strListFileNames:" + strListFileNames);
		System.out.println("photos:" + photos);

		if (photos != null) {
			photos = strListFileNames;

			String deletePhotos = dao.getMember(dto.getNum()).getPhotos();
			if (!deletePhotos.equals("no")) {
				String[] deleteFile = deletePhotos.split(",");
				for (String s : deleteFile) {
					System.out.println("To delete img : " + path + "/" + s);

					File file = new File(path + "/" + s);
					if (file.exists()) {
						file.delete();
					}
				}
			}
		}

		dto.setPhotos(photos);
		dao.updateMember(dto);

//		mview.addObject("dto", dto);
//		mview.setViewName("/member/memberdetail?num=" + dto.getNum());

//		return mview;
		return "redirect:detail?num=" + dto.getNum();
	}
}
