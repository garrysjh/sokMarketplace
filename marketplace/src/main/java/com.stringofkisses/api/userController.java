package com.stringofkisses.api;

import com.stringofkisses.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {
    @Autowired
    private userService UserService;
    @Autowired
    private userCartService UserCartService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("LoginID",UserService.getLoginID());

        return "signup_form";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String register(@ModelAttribute("user") User user, Model model){
//        User existingUser = UserService.findUserByEmail(user.getEmail());
//
//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }
//
//        if(result.hasErrors()){
//            model.addAttribute("user", user);
//            return "/register";
//        }
        model.addAttribute("LoginID",UserService.getLoginID());
        if(UserService.checkExisting(user.getUsername())!=0){
            return "registerFail";
        }
        else {
            UserService.addUser(user);
            UserCartService.addUserCart(user.getId());
            return "register_success";
        }
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        List<User> users = UserService.findAll();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password")String password, Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        if(UserService.login(username, password) != 0){
        UserService.setLoginID(UserService.login(username, password));
        return "redirect:/";}
        else
            return "loginFail";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        UserService.setLoginID(0);
        model.addAttribute("LoginID",UserService.getLoginID());
        return "logoutSuccess";
    }



}

