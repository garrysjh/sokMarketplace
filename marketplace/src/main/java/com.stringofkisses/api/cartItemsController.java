package com.stringofkisses.api;

import com.stringofkisses.models.CartItems;
import com.stringofkisses.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class cartItemsController {
    @Autowired
    productService ProductService;
    @Autowired
    userService UserService;
    @Autowired
    cartItemsService CartItemsService;
    @Autowired
    userCartService UserCartService;

    @RequestMapping(value = "/products/addToCart/{id}", method = { RequestMethod.GET})
    public String postAdminCategory(@PathVariable(name="id") int id){
        CartItemsService.addCartItem(id, UserCartService.getId(UserService.getLoginID()));
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String totalCart(Model model){
        model.addAttribute("LoginID",UserService.getLoginID());
        model.addAttribute("FirstName",UserService.findFirstNamebyID());
        model.addAttribute("CartItems", CartItemsService.findAllFromCart(UserCartService.getId(UserService.getLoginID())));
        model.addAttribute("ProductService", ProductService);
        float TotalPrice = 0;
        for(CartItems cartItems : CartItemsService.findAllFromCart(UserCartService.getId(UserService.getLoginID()))){
            TotalPrice += CartItemsService.getTotalPriceOfOneItem(CartItemsService.getProductIdFromCartItem(cartItems), UserCartService.getId(UserService.getLoginID()));
        }

        model.addAttribute("TotalPrice", TotalPrice);
        return "cart";
    }

    @RequestMapping("/cart/delete/{id}")
    public String deleteAdminCategory(@PathVariable(name = "id") int id) {
        CartItemsService.delete(CartItemsService.getFromId(id));
        return "redirect:/cart";
    }

}
