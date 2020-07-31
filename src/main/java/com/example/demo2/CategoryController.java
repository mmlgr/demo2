package com.example.demo2;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.how2java.springboot.pojo.Category;

@Controller

public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
        System.out.println("/listCategory");
        List<Category> cs=categoryMapper.findAll();
        for (Category c:cs ) {
            System.out.println(c);
        }
        m.addAttribute("ps", cs);
        return "list";
    }

}