package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NullPointerException.class)
    public String nPEExceptionHandler(Model m) {
        System.out.println("got Null Pointer Exception");
        m.addAttribute("msg", "Got Null Pointer Exception");
        return "exp";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // if you want to specify certain then
    // write that exception like NullPointerException.class
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class) // general exception handler
    public String exceptionHandler(Model m) {
        System.out.println("got Exception");
        m.addAttribute("msg", "Got exception");
        return "exp";
    }
}
