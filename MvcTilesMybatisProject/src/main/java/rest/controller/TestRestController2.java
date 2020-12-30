package rest.controller;

import board.service.BoardServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.MyCarDto;
import spring.dto.ReBoardDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController = @ResponseBody + @Controller
@RestController
public class TestRestController2 {

    @Autowired
    private BoardServiceInter service;

    @GetMapping("/rest4")
    public MyCarDto testRest1() {

        MyCarDto dto = new MyCarDto();
        dto.setNum("300");
        dto.setCarname("setCarname RestController");
        dto.setCarcolor("setCarcolor RestController");
        dto.setCarguip("setCarguip RestController");

        return dto;
    }

    @GetMapping("/rest5")
    public List<ReBoardDto> testRest3() {
        return service.getList(0, 5);
    }

    @GetMapping("/rest6")
    public Map<String, String> rest6() {
//        return "happy"; // happy

        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "happy");
        return map; // {"msg":"happy"}
    }

    @GetMapping("/rest7")
    public List<String> rest7() {
        List<String> list = new ArrayList<>();
        list.add("asdf 11");
        list.add("asdf 12");
        list.add("asdf 13");
        list.add("asdf 14");

        return list;
    }
}
