package day1215_web.ex1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String one(Model model) {

        //model -> save in request
        model.addAttribute("name", "asdf111");
        model.addAttribute("message", "asdf222!!!");

        // /WEB-INF/views/result1.jsp  -> forward
        return "result1";   //forward is fileName
    }

    @RequestMapping("/my") // if skip this format then operate GET method.
    public ModelAndView two() {
        ModelAndView model = new ModelAndView();
        model.addObject("emp", "samsung");
        model.addObject("sawonname", "yang");
        model.addObject("pay", "123456");
        //
        // set fileName to Forward.
        model.setViewName("result2");
        return model;
    }

    @GetMapping("/my/hello")    // Mapping my GET method (from spring version 5 or higher)
    public String three(Model model, HttpSession session) {
        model.addAttribute("msg", "three method.");
        session.setAttribute("login", "ok");
        return "result3";
    }
}
