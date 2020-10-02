package pl.coderslab.project.product;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import java.util.List;


@Controller
@RequestMapping("/search")
@AllArgsConstructor
public class SearchProductController {

    ProductService productService;
    CategoryService categoryService;
    CartService cartService;


//    @PostMapping
//    @ResponseBody
//    public String searchedProduct(@RequestParam  String search) {
//        return productService.findProductsByNameIsStartingWith(search).toString() ;
//    }

    @PostMapping
    public String viewProductsBySort(Model model , String search) {
        model.addAttribute("products", productService.findProductsByNameIsStartingWithName(search));
        model.addAttribute("search", search);
        return "view-search-products";
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

        return "view-search-products";
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
