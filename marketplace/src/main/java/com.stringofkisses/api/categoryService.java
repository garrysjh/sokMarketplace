package com.stringofkisses.api;

import com.stringofkisses.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {
    @Autowired
    private categoryRepository CategoryRepo;

    public List<Category> listAllCategory() {return CategoryRepo.findAll();}
    public void addCategory(Category category) {
        CategoryRepo.save(category);
    }

    public Category getFromId(int Id) {return CategoryRepo.getCategory(Id);}

    public void delete(Category category) {CategoryRepo.delete(category);}

}
