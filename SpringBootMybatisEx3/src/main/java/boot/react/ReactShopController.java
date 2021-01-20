package boot.react;

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

import boot.shop.data.MysqlShopMapper;
import boot.shop.data.ShopDto;

@CrossOrigin // 다른도메인과 통신을 위해.
@RestController
public class ReactShopController {

	@Autowired
	MysqlShopMapper mapper;

	MultipartFile multi;

	String uploadPath;
	String photoName;

	@GetMapping("/shop/list")
	public List<ShopDto> getList() {

		return mapper.getAllDatas();
	}

	@PostMapping(value = "/shop/upload", consumes = { "multipart/form-data" })
	public Map<String, String> fileUpload(@RequestParam MultipartFile uploadFile, HttpServletRequest request) {
		uploadPath = request.getSession().getServletContext().getRealPath("/photo");
		System.out.println("path:" + uploadPath);

		int pos = uploadFile.getOriginalFilename().lastIndexOf(".");
		String ext = uploadFile.getOriginalFilename().substring(pos);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		photoName = "react" + sdf.format(date) + ext;

		// MultipartFile 도 멤버변수에 저장.
		multi = uploadFile;

		// 이미지 업로드 폴더 photo 에 실제 업로드 하기.
		try {
			multi.transferTo(new File(uploadPath + "/" + photoName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", photoName);

		return map;
	}

	// insert
	@PostMapping("/shop/insert")
	public Map<String, String> insert(@RequestBody ShopDto dto) {
		// dto에 실제 업로드 할 이미지명 저장.
		dto.setPhotoname(photoName);
		System.out.println("uploadPath:" + uploadPath);
		System.out.println("photoName:" + photoName);
		System.out.println("multi:" + multi);

//		// 이미지 업로드 폴더 photo 에 실제 업로드 하기.
//		try {
//			multi.transferTo(new File(uploadPath + "/" + photoName));
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		mapper.insertShop(dto);

		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "insert success!!");

		return map;
	}

	@GetMapping("/shop/detail")
	public ShopDto getData(@RequestParam String num) {

		return mapper.getData(num);
	}

	@DeleteMapping("/shop/delete")
	public void delete(@RequestParam String num) {
		mapper.deleteShop(num);
	}

	@PostMapping("/shop/update")
	public void update(@RequestBody ShopDto dto) {
		System.out.println("dto : " + dto.toString());
		mapper.updateShop(dto);
	}

}
