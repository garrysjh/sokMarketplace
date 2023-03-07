package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import com.stringofkisses.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    private userRepository UserRepo;
    public static int LoginID = 0;


    public void addUser(User user) {
        user.setAdmin(false);
        UserRepo.save(user);
        }


    public List<User> findAll(){
        return UserRepo.findAll();
    }
    public int login(String username, String password){
        if(password.equals(UserRepo.findByUsername(username))){
            return UserRepo.findIdByUsername(username);
        }
        else {
            return 0;
        }
    }

    public int getLoginID(){
        return LoginID;
    }
    public String findFirstNamebyID(){
        return UserRepo.findFirstNameById(LoginID);
    }
    public void setLoginID(int id){
        this.LoginID = id;
    }

    public int checkExisting (String username) {
        return UserRepo.findUserIfExists(username);
    }


}
