package pl.coderslab.project.product;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DeleteProductController {

    ProductService productService;


    public DeleteProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/product/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProductById(id);
        return "redirect:/all";

    }


    @PostMapping("/admin/product/delete/all")
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return "redirect:/all";

    }

}
