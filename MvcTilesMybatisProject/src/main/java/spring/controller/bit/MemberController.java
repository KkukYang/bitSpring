package spring.controller.bit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
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
                System.out.println("before print list mainphoto : " + photos[0]);
            }
        }

        model.addObject("totalCount", totalCount);
        model.addObject("list", list);
        model.setViewName("/member/memberlist");
        return model;
    }

    @PostMapping("/member/savemember")
    public String insert(@ModelAttribute MemberDto dto, HttpServletRequest request) {
        //커트라인 미리구하기.
        int maxSize = 1024 * 1024 * 2;//2mb

        //총합 사이즈를 미리 예측.
        int sumSize = (int) dto.getUpload().stream().mapToLong(MultipartFile::getSize).sum();
        System.out.println("sumSize:" + sumSize);

        try {
            if (sumSize > maxSize) {
                throw new Exception("filesize,용량 너무 많아 ㅠㅠ...");
            }
//            //for문 안에서 처리하는것은 너무 비효율적.
//            for (MultipartFile f : dto.getUpload()) {
//                if (f.getSize() > maxSize) {
//                    throw new Exception("filesize,용량 너무 많아 ㅠㅠ...");
//                }
//
//                if (f.getSize() > maxSize) {
//                    break;
//                }
//            }

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

                String changeFilename = writer.changeFilename(f.getOriginalFilename()).replace(" ", "");
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

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", e.getMessage());
            String strCategory = e.getMessage().split(",")[0];
            if (strCategory != null && strCategory.equals("filesize")) {
                request.getSession().setAttribute("filesize", sumSize);
            }
            return "/error/errorpage";
        }


    }

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
        System.out.println("path:" + path);
        System.out.println("photos:" + photos);

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

        return "redirect:detail?num=" + dto.getNum();
    }

//    @ExceptionHandler({
//            SizeLimitExceededException.class,
//            RuntimeException.class,
//            MaxUploadSizeExceededException.class
//    })
//    public Object exceptionCatch(Exception e) {
//        System.out.println("exceptionCatch");
//        e.printStackTrace();
//        return "/error/errorpage";
//    }

//	@GetMapping("/error/imgUploadErr")
//	public String maxUploadExceeded() {
//
//		System.out.println("maxUploadExceeded()###########");
//		return "redirect:list";
//	}

}
