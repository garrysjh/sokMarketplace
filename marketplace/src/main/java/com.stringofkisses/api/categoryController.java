package com.stringofkisses.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.stringofkisses.models.Category;

@Controller
public class categoryController {
    @Autowired
    private categoryService CategoryService;
    @RequestMapping("/admin")
    public String adminHome() {
        System.out.print("adminHome reached from controller");
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String adminCategory(Model model){
        model.addAttribute("categories", CategoryService.listAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getAdminCategoryAdd(Model model){
        model.addAttribute("category", new Category());
        return "addCategory";
    }
    @PostMapping("/admin/categories/add")
    public String postAdminCategory(@ModelAttribute("category") Category category){
        CategoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @RequestMapping("/admin/categories/delete/{id}")
    public String deleteAdminCategory(@PathVariable(name = "id") int id) {
        CategoryService.delete(CategoryService.getFromId(id));
        System.out.print("Delete id reached from controller");
        return "redirect:/admin/categories";
    }
}
