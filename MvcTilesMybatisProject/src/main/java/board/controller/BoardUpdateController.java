package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import board.service.BoardServiceInter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import spring.dto.ReBoardDto;
import upload.util.SpringFileWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardUpdateController {

    @Autowired
    private BoardServiceInter service;

    @GetMapping("/board/updatepassform")
    public ModelAndView passform(
            @RequestParam String num, @RequestParam String pageNum
    ) {
        ModelAndView mview = new ModelAndView();

        ReBoardDto dto = service.getData(num);

        mview.addObject("pageNum", pageNum);
        mview.addObject("dto", dto);

        mview.setViewName("/sub/board/updatepassform");
        return mview;
    }

    @PostMapping("/board/passcheck")
    public String passcheck(Model model, @RequestParam String num, @RequestParam String pass, @RequestParam String pageNum) {
        System.out.println("num:" + num);
        System.out.println("pass:" + pass);
        System.out.println("pageNum:" + pageNum);

        //비번체크.
        int n = service.getCheckPass(num, pass);
        ReBoardDto dto = null;

        if (n == 0) {
            //wrong password.
            return "/member/passfail";
        } else {
            dto = service.getData(num);
            model.addAttribute("dto", dto);
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("pageNum", pageNum);
        }

        return "/sub/board/updateform";
    }

    @PostMapping("/board/update")
    public String updateBoard(
            @ModelAttribute ReBoardDto dto,
            @RequestParam String pageNum,
            HttpServletRequest request
    ) {
        System.out.println("dto:" + dto);
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

        if (upload != null) {
            String deleteFiles = service.getData(dto.getNum()).getUpload();

            if (!deleteFiles.equals("no")) {
                String[] deleteFile = deleteFiles.split(",");
                for (String s : deleteFile) {
                    System.out.println("To delete img : " + path + "/" + s);

                    File file = new File(path + "/" + s);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }

            upload = strListFileNames;
        }

        dto.setUpload(upload);
        service.updateBoard(dto);

        return "redirect:content?num=" + dto.getNum() + "&pageNum=" + pageNum;


    }
}
