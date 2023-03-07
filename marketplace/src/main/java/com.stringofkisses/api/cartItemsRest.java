package com.stringofkisses.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class cartItemsRest {
//    @Autowired
//    userService UserService;
//    @Autowired
//    cartItemsService CartItemsService;
//    @Autowired
//    userCartService UserCartService;
//
//    @RequestMapping(value = "/products/addToCart/{id}", method = { RequestMethod.GET})
//    public String postAdminCategory(@PathVariable(name="id") int id){
//        CartItemsService.addCartItem(id, UserCartService.getId(UserService.getLoginID()));
//        return "redirect:/products";
//    }
//
//}
