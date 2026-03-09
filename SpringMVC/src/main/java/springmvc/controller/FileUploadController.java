package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
    @RequestMapping("/fileform")
    public String showUploadForm(){
        return "fileForm";
    }

    @RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("profile")CommonsMultipartFile file, Model m){
        System.out.println("file upload handler");
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());

        m.addAttribute("filename",file.getOriginalFilename());
        return "fileSuccess";
    }
}
