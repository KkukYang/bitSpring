package boot.shop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import boot.shop.data.MysqlShopMapper;
import boot.shop.data.ShopDto;

@Controller
public class ShopController {

	@Autowired
	MysqlShopMapper mapper;

	@GetMapping({ "/", "/list" })
	public ModelAndView list() {

		ModelAndView mview = new ModelAndView();
		int totalCount = mapper.getTotalCount();
		List<ShopDto> list = mapper.getAllDatas();

		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		mview.setViewName("shoplist");

		return mview;
	}

	@GetMapping("/form")
	public String form() {
		return "addform";
	}

	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		ShopDto dto = mapper.getData(num);

		mview.addObject("dto", dto);
		mview.setViewName("updateform");

		return mview;
	}

	@PostMapping("/update")
	public String update(@ModelAttribute ShopDto dto, HttpServletRequest request, @RequestParam MultipartFile photo) {
		
		System.out.println("dto.getSangpum:"+dto.getSangpum());
		System.out.println("dto.getPhotoname:"+dto.getPhotoname());
		System.out.println("dto.getPrice:"+dto.getPrice());
		System.out.println("dto.getNum:"+dto.getNum());
		
		if (photo.getOriginalFilename().length() > 0) {
			String path = request.getSession().getServletContext().getRealPath("/photo");
			System.out.println("path:" + path);
			int pos = photo.getOriginalFilename().lastIndexOf(".");
			String ext = photo.getOriginalFilename().substring(pos);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
			String fileName = "photo" + sdf.format(date) + ext;
			dto.setPhotoname(fileName);

			try {
				photo.transferTo(new File(path + "/" + fileName));

				String deleteFiles = mapper.getData(dto.getNum()).getPhotoname();

				if (deleteFiles != null) {
					String[] deleteFile = deleteFiles.split(",");
					for (String s : deleteFile) {
						System.out.println("To delete img : " + path + "/" + s);

						File file = new File(path + "/" + s);
						if (file.exists()) {
							file.delete();
						}
					}
				}

			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			dto.setPhotoname(null);
		}

		mapper.updateShop(dto);
		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam String num, HttpServletRequest request) {
		System.out.println("delete:" + num);
		String path = request.getSession().getServletContext().getRealPath("/photo");
		String deleteFiles = mapper.getData(num).getPhotoname();

		if (deleteFiles != null) {
			
			String[] deleteFile = deleteFiles.split(",");
			for (String s : deleteFile) {
				System.out.println("To delete img : " + path + "/" + s);

				File file = new File(path + "/" + s);
				if (file.exists()) {
					file.delete();
				}
			}
		}
		mapper.deleteShop(num);
		return "redirect:list";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto, @RequestParam MultipartFile photo, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/photo");
		System.out.println("path:" + path);

		int pos = photo.getOriginalFilename().lastIndexOf(".");
		String ext = photo.getOriginalFilename().substring(pos);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		String fileName = "photo" + sdf.format(date) + ext;
		dto.setPhotoname(fileName);

		try {
			photo.transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mapper.insertShop(dto);

		return "redirect:list";
	}
}
