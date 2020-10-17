package pl.coderslab.project.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionController {

    @ExceptionHandler(NotEnoughProductsInStockException.class)
    public String  NotEnoughProductsInStock (Exception e, Model model){

        model.addAttribute("errorMessage" , e.getMessage());
        return "exception/not-enough-products-in-stock-exception";
    }

    @ExceptionHandler(WrongPasswordException.class)
    public String  WrongPasswordException (Exception e, Model model){
        model.addAttribute("errorMessage" , e.getMessage());
        return "exception/wrong-password-exception";
    }

    @ExceptionHandler(WrongSecondPasswordException.class)
    public String  WrongSecondPasswordException (Exception e, Model model){
        model.addAttribute("errorMessage" , e.getMessage());
        return "exception/wrong-second-password-exception";
    }

}
