package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.dto.ProductDto;
import spring.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MunjeRestController {

    @Autowired
    ProductService service;

    @GetMapping("/munje")
    public String munjeStart() {
        System.out.println("munjeStart() -> \"/munje\"");

        return "/sub/munje/food";
    }

    @PostMapping("/munje")
    public String munjeInsertAndUpdate(
            @ModelAttribute ProductDto dto,
            HttpServletRequest request
    ) {
        System.out.println("munjeInsertAndUpdate() -> \"/munje\"");

        return "redirect:munje";
    }

}
