package pl.coderslab.project.product.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class RestoreProductController {

    ProductService productService;


    public RestoreProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/product/restore")
    public String restoreProduct(@RequestParam Long id) {
      Product product =  productService.getProductById(id);
        product.setStatus(true);
        productService.saveProduct(product);
        return "redirect:/admin/product/all/deleted";

    }


    @PostMapping("/admin/product/restore/all")
    public String restoreAllProducts() {
        List<Product> list =  productService.getAllByStatus(false);
        productService.saveAllProducts(list.stream().peek(product -> product.setStatus(true)).collect(Collectors.toList()));
        return "redirect:/admin/product/all/deleted";

    }

}
