package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.User;
import springmvc.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {
    @Autowired
    private UserService userService;

    @ModelAttribute
    public void commonDataForModel(Model m){
        m.addAttribute("Header", "Spring MVC");
    }

    @RequestMapping("/contact")
    public String showForm(Model m) {
        return "contact";
    }

//    @RequestMapping(path = "/processForm", method = RequestMethod.POST)
//    public String handleForm(@RequestParam(name = "email", required = false) String email,
//                             @RequestParam("username") String userName,
//                             @RequestParam("password") String password,
//                             Model model) {
//
//        User user = new User();
//        user.setEmail(email);
//        user.setUsername(userName);
//        user.setPassword(password);
//
//        System.out.println("User " + user);
//
//        // process

    /// /        model.addAttribute("email", email);
    /// /        model.addAttribute("username", userName);
    /// /        model.addAttribute("password", password);
//        model.addAttribute("user", user);
//
//        return "success";
//    }
    @RequestMapping(path = "/processForm", method = RequestMethod.POST)
    public String handleForm(@ModelAttribute User user, Model model) {
        System.out.println("User " + user);
        int id = this.userService.createUser(user);
        model.addAttribute("msg", "User created...." + id);
        return "success";
    }
}
