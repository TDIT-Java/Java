package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("This is home url");
        model.addAttribute("title", "Spring MVC");
        model.addAttribute("message", "Hello Spring MVC");

        List<String> topics = new ArrayList<String>();
        topics.add("Spring spel");
        topics.add("Spring ORM");
        topics.add("Spring MVC");

        model.addAttribute("topics", topics);
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("This is about url");
        return "about";
    }

    @RequestMapping("/help")
    public ModelAndView help(){
        System.out.println("This is help url");
        ModelAndView model = new ModelAndView();
        model.addObject("name", "Pradeep");
        model.addObject("message", "Hello Pradeep");
        LocalDate today = LocalDate.now();
        model.addObject("today", today);

        model.setViewName("help");

        return model;
    }

}
