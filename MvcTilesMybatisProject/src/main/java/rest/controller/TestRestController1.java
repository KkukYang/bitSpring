package rest.controller;

import board.service.BoardServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.dto.MyCarDto;
import spring.dto.ReBoardDto;

import java.util.List;

@Controller
public class TestRestController1 {

    @Autowired
    private BoardServiceInter service;

    @GetMapping("/rest1")
    public @ResponseBody
    MyCarDto testRest1() {

        MyCarDto dto = new MyCarDto();
        dto.setNum("100");
        dto.setCarname("setCarname ResponseBody");
        dto.setCarcolor("setCarcolor ResponseBody");
        dto.setCarguip("setCarguip ResponseBody");

        return dto;
    }

    @GetMapping("/rest2")
    public ResponseEntity<MyCarDto> testRest2() {
        MyCarDto dto = new MyCarDto();
        dto.setNum("200");
        dto.setCarname("setCarname ResponseEntity");
        dto.setCarcolor("setCarcolor ResponseEntity");
        dto.setCarguip("setCarguip ResponseEntity");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<>(dto, headers, HttpStatus.OK);
    }

    @GetMapping("/rest3")
    public @ResponseBody
    List<ReBoardDto> testRest3() {
        return service.getList(0, 5);
    }
}
