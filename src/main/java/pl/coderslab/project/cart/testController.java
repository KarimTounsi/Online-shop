package pl.coderslab.project.cart;

import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.project.address.Address;
import pl.coderslab.project.order.OrderService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;

@Controller
@RequestMapping("/test")
@AllArgsConstructor
public class testController {


    CartService cartService;
    OrderService  orderService;


    @GetMapping
    @ResponseBody
    public String cart() throws MessagingException, IOException, TemplateException {


        cartService.sendMail( orderService.getOrderByID(15L));

        return "wysłane";
    }


}
