package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import board.service.BoardServiceInter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class BoardDeleteController {

    @Autowired
    private BoardServiceInter service;

    @GetMapping("/board/deletepassform")
    public ModelAndView passform(
            @RequestParam String num,
            @RequestParam String pageNum
    ) {
        System.out.println("/board/deletepassform -> passform()");
        ModelAndView mview = new ModelAndView();
        mview.addObject("num", num);
        mview.addObject("pageNum", pageNum);

        mview.setViewName("/sub/board/deletepassform");
        return mview;
    }


    @PostMapping("/board/passcheckanddelete")
    public String deleteBoard(
            @RequestParam String num,
            @RequestParam String pageNum,
            @RequestParam String pass,
            HttpServletRequest request
    ) {
        System.out.println("/board/delete -> deleteBoard()");
        int n = service.getCheckPass(num, pass);
        if (n == 0) {
            return "/member/passfail";
        }

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
        String deleteFile = service.getData(num).getUpload();
        System.out.println("path:" + path);
        System.out.println("deleteFile:" + deleteFile);

        if (!deleteFile.equals("no")) {
            String[] files = deleteFile.split(",");

            for (String s : files) {
                File file = new File(path + "/" + s);
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        service.deleteBoard(num);

        return "redirect:list?pageNum=" + pageNum;
    }


}
