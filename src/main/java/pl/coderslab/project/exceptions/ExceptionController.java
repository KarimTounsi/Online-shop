package pl.coderslab.project.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionController {

    @ExceptionHandler(NotEnoughProductsInStockException.class)
    public String  NotEnoughProductsInStock (Exception e, Model model){

        model.addAttribute("errorMessage" , e.getMessage());
        return "exception";
    }



}
