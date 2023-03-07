package com.stringofkisses.api;

import com.stringofkisses.models.CartItems;
import com.stringofkisses.models.Product;
import com.stringofkisses.models.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartItemsService {
    @Autowired
    cartItemsRepository CartItemsrepository;
    @Autowired
    productService ProductService;

    public static float TotalPriceInCart;

    public void addCartItem(int product_id, int cart_id) {
        if (CartItemsrepository.CheckIfExisting(cart_id, product_id) == 0){
            System.out.println("doesnt exist");
        CartItems cartItem = new CartItems();
        cartItem.setProduct_id(product_id);
        cartItem.setCart_id(cart_id);
        cartItem.setQuantity(1);
        CartItemsrepository.save(cartItem);}
        else {
            System.out.println("exists already");
            CartItemsrepository.incrementQuantity(cart_id, product_id);
        }
    }
    public List<CartItems> findAllFromCart(int cart_id){
        return CartItemsrepository.findAllFromCart(cart_id);
    }

    public void delete(CartItems cartItems) {CartItemsrepository.delete(cartItems);}

    public CartItems getFromId(int Id) {return CartItemsrepository.getCartItem(Id);}

    public int getProductIdFromCartItem(CartItems cartItems){
        return cartItems.getProduct_id();
    }
    public float getTotalPriceOfOneItem(int product_id, int cart_id) {
        return CartItemsrepository.getQuantity(product_id, cart_id)*ProductService.getPrice(product_id);
    }

}

