package pl.coderslab.project.product.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class DeleteProductController {

    private final  ProductService productService;


    public DeleteProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/product/delete")
    public String deleteProduct(@RequestParam Long id) {
      Product product =  productService.getProductById(id);
        product.setStatus(false);
        productService.saveProduct(product);
        return "redirect:/all";

    }


    @PostMapping("/admin/product/delete/all")
    public String deleteAllProducts() {
        List<Product> list =  productService.getAllByStatus(true);
        productService.saveAllProducts(list.stream().peek(product -> product.setStatus(false)).collect(Collectors.toList()));
        return "redirect:/all";

    }

}
