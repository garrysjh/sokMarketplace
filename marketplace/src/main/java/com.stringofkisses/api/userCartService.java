package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import com.stringofkisses.models.User;
import com.stringofkisses.models.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userCartService {
    @Autowired
    private userCartRepository UserCartRepository;

    public void addUserCart(int user_id) {
        UserCart userCart = new UserCart();
        userCart.setPurchased(false);
        userCart.setUser_id(user_id);

        UserCartRepository.save(userCart);
    }

    public void cartOut(UserCart userCart){


    }
    public int getId(int id){
        return UserCartRepository.getCartIdFromUserId(id);
    }
}
