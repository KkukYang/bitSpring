package react.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import react.board.data.ReactBoardDao;
import react.board.data.ReactBoardDto;

@RestController
@CrossOrigin
public class ReactBoardRestController {

	@Autowired
	ReactBoardDao dao;

	static MultipartFile g_uploadFile;
	static String photoname;
	static String g_uploadPath;

	@GetMapping("/board/list")
	public List<ReactBoardDto> getList() {
		System.out.println("getList()");
		return dao.getList();
	}

	@PostMapping(value = "/board/upload", consumes = { "multipart/form-data" })
	public Map<String, String> fileUpload(@RequestParam MultipartFile uploadFile, HttpServletRequest request) {
		String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println("path:" + uploadPath);

		g_uploadPath = uploadPath;
		g_uploadFile = uploadFile;
		System.out.println("g_uploadFile : " + g_uploadFile.getOriginalFilename());
		System.out.println("uploadFile : " + uploadFile.getOriginalFilename());

//		int pos = uploadFile.getOriginalFilename().lastIndexOf(".");
//		String ext = uploadFile.getOriginalFilename().substring(pos);
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
//		photoname = "react" + sdf.format(date) + ext;
//
//		// 이미지 업로드 폴더 photo 에 실제 업로드 하기.
//		try {
//			uploadFile.transferTo(new File(uploadPath + "/" + photoname));
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", photoname);

		return map;
	}

	@PostMapping("/board/insert")
	public void insertBoard(@RequestBody ReactBoardDto dto) {
		System.out.println("dto.getWriter() : " + dto.getWriter());
		System.out.println("dto.getTitle() : " + dto.getTitle());
		System.out.println("dto.getContent() : " + dto.getContent());


		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		System.out.println("g_uploadFile : " + g_uploadFile.getOriginalFilename());
		System.out.println("g_uploadPath : " + g_uploadPath);

		int pos = g_uploadFile.getOriginalFilename().lastIndexOf(".");
		String ext = g_uploadFile.getOriginalFilename().substring(pos);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		photoname = "react" + sdf.format(date) + ext;

		// 이미지 업로드 폴더 photo 에 실제 업로드 하기.
		try {
			g_uploadFile.transferTo(new File(g_uploadPath + "/" + photoname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////

		if (photoname == null) {
			dto.setPhotoname("no");
		} else {
			dto.setPhotoname(photoname);
		}

		System.out.println("dto.getPhotoname() : " + dto.getPhotoname());

		dao.insertBoard(dto);

		photoname = null;

	}

	@GetMapping("/board/select")
	public ReactBoardDto getData(@RequestParam String num, @RequestParam(defaultValue = "no") String key) {

		if (!key.equals("no")) {
			dao.updateReadCount(num);
		}

		return dao.getData(num);
	}

	@PostMapping("/board/update")
	public void updateBoard(@RequestBody ReactBoardDto dto) {
		dto.setPhotoname(photoname);
		dao.updateBoard(dto);
		this.photoname = null;
	}

	@DeleteMapping("/board/delete")
	public void deleteBoard(@RequestParam String num, HttpServletRequest request) {
		String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(uploadPath);

		String pname = dao.getData(num).getPhotoname();
		File file = new File(uploadPath + "/" + pname);

		if (file.exists()) {
			file.delete();
		}

		dao.deleteBoard(num);
	}

}
