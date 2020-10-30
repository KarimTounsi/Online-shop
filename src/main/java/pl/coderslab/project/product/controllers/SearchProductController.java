package pl.coderslab.project.product.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;


@Controller
@RequestMapping("/search")
@AllArgsConstructor
public class SearchProductController {

    private final   ProductService productService;
    private final  CategoryService categoryService;
    private final  CartService cartService;


//    @PostMapping
//    @ResponseBody
//    public String searchedProduct(@RequestParam  String search) {
//        return productService.findProductsByNameIsStartingWith(search).toString() ;
//    }

    @PostMapping
    public String viewProductsBySort(Model model , String search) {
        model.addAttribute("products", productService.getProductsByNameContaining(search));
        model.addAttribute("search", search);
        return "product/view-search-products";
    }



    @PostMapping
    @RequestMapping("/{search}")
    public String viewProductsBySort(Model model, @PathVariable String search , String type) {

       if (type.equals("increase")) {
            model.addAttribute("products", productService.getProductsByNameIsStartingWithOrderByPriceAsc(search));
        } else if (type.equals("decrease")){
            model.addAttribute("products", productService.getProductsByNameIsStartingWithOrderByPriceDesc(search));
        } else if (type.equals("A-Z")){
            model.addAttribute("products", productService.getProductsByNameIsStartingWithOrderByNameAsc(search));
        }else if (type.equals("Z-A")){
            model.addAttribute("products", productService.getProductsByNameIsStartingWithOrderByNameDesc(search));
        }

        return "product/view-search-products";
    }




    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }

}
