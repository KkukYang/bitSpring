package rest.controller;

import board.dao.AnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.dto.ReAnswerDto;
import upload.util.SpringFileWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerRestController {

    @Autowired
    private AnswerDao dao;

    //이미지명을 저장할 멤버변수.
    String photoName = "no";

    @PostMapping("/board/photo")
    public Map<String, String> savePhoto(
            @RequestParam MultipartFile upload,
            HttpServletRequest request
    ) {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
        System.out.println("path:" + path);

        SpringFileWriter sfw = new SpringFileWriter();
        photoName = sfw.changeFilename(upload.getOriginalFilename());
        System.out.println("photoName:" + photoName);
        sfw.writeFile(upload, photoName, path);

        Map<String, String> map = new HashMap<>();
        map.put("photo", photoName);

        return map;
    }

    @PostMapping("/board/photoupdate")
    public Map<String, String> savePhotoUpdate(
            @RequestParam MultipartFile upload,
            @RequestParam String idx,
            HttpServletRequest request
    ) {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
        String deleteFile = dao.getData(idx).getPhotoname();
        System.out.println("path:" + path);

        if (upload.getOriginalFilename().length() > 0) {
            System.out.println("deleteFile:" + deleteFile);
            System.out.println("upload.getOriginalFilename() :" + upload.getOriginalFilename());
            //기존거 지우고.
            if (!deleteFile.equals("no")) {
                String[] files = deleteFile.split(",");

                for (String s : files) {
                    File file = new File(path + "/" + s);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }

        //새로운거 올리기.
        SpringFileWriter sfw = new SpringFileWriter();
        photoName = sfw.changeFilename(upload.getOriginalFilename());
        System.out.println("photoName:" + photoName);
        sfw.writeFile(upload, photoName, path);

        Map<String, String> map = new HashMap<>();
        map.put("photo", photoName);

        return map;
    }

//    @PostMapping("/board/answersave")
//    public void insertAnswer(
//            @RequestParam String msg,
//            @RequestParam String num
//    ) {
//        System.out.println(this.getClass() + " : " + this);
//        ReAnswerDto dto = new ReAnswerDto();
//        dto.setNum(num);
//        dto.setMsg(msg);
//        dto.setPhotoname(photoName);
//        dao.insertAnswer(dto);
//
//        photoName = "no";
//    }

    @PostMapping("/board/answersave")
    public void insertAnswer(
            @ModelAttribute ReAnswerDto dto
    ) {
        System.out.println(this.getClass() + " : " + this);
        dto.setPhotoname(photoName);
        dao.insertAnswer(dto);

        photoName = "no";
    }

    @GetMapping("/board/answerlist")
    public List<ReAnswerDto> list(@RequestParam String num) {
        return dao.getAnswerList(num);
    }

    @PostMapping("/board/answerdelete")
    public void deleteAnswer(@RequestParam String idx, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
        String deleteFile = dao.getData(idx).getPhotoname();

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

        dao.deleteAnswer(idx);
    }

    @PostMapping("/board/answerupdate")
    public void updateAnswer(@ModelAttribute ReAnswerDto dto) {

        System.out.println("idx:" + dto.getIdx());

        if(!photoName.equals("no")){
            dto.setPhotoname(photoName);
        }
        dao.updateAnswer(dto);

        photoName = "no";
    }


    @GetMapping("/board/selectanswer")
    public ReAnswerDto selectData(@RequestParam String idx){
        return dao.getData(idx);
    }
}
