package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import com.stringofkisses.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class productController {
    @Autowired
    productService ProductService;
    @Autowired
    private userService UserService;
    @GetMapping("/admin/products")
    public String adminProducts(Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        model.addAttribute("products", ProductService.listAllProducts());
        return "adminProducts";
    }
    @GetMapping("/products")
    public String totalProducts(Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        model.addAttribute("FirstName",UserService.findFirstNamebyID());
        model.addAttribute("products", ProductService.listAllProducts());
        return "Products";
    }
    @GetMapping("/admin/products/add")
    public String getAdminCategoryAdd(Model model){
        model.addAttribute("product", new Product());
        return "addProduct";
    }
    @PostMapping("/admin/products/add")
    public String postAdminCategory(@ModelAttribute("product") Product product){
        ProductService.addProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping("/admin/products/delete/{id}")
    public String deleteAdminCategory(@PathVariable(name = "id") int id) {
        ProductService.delete(ProductService.getFromId(id));
        System.out.print("Delete id reached from controller for product");
        return "redirect:/admin/products";
    }

}
