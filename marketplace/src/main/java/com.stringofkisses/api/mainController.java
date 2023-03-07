package com.stringofkisses.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
    @Autowired
    private userService UserService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        model.addAttribute("FirstName",UserService.findFirstNamebyID());
        return "index";
    }
}
