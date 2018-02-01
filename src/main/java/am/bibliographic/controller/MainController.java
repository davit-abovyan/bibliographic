package am.bibliographic.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {
    private Logger log = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    public ModelAndView index(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
