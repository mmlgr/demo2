package com.example.demo2;

import java.util.List;

import com.how2java.springboot.pojo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.how2java.springboot.pojo.Category;
import java.util.Date;

import com.how2java.springboot.pojo.Product;


import java.util.ArrayList;


@Controller

public class LoginController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    private CustomerService customerService;

    @RequestMapping("/usemapper")
    public String usemapper(Model m){
        //CustomerService customerService=new CustomerService();
        //Customer customer = customerService.getCustbyid(8);
       // System.out.println(customer);
        return "list";
    }

    @RequestMapping("/getUsers")
    public String getUser(Model m){
        String sql = "select * from category_";
        List<Category> ps = new ArrayList<>();
        SqlRowSet sqlRowSet =jdbcTemplate.queryForRowSet(sql);
//只有一行结果可以用if，有多行可以用while循环
        while(sqlRowSet.next())
        {
           Category category=new Category();
           category.setId(sqlRowSet.getInt("id"));
           category.setName(sqlRowSet.getString("name"));
           ps.add(category);
            System.out.println(category);

        }
      m.addAttribute("ps", ps);
        return "list";
    }

    //将Service注入Web层
   // @Autowired
   // UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "h";
    }
    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }
    @RequestMapping("/test")
    public String test(Model m) {
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);

        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);

        return "test";
    }
    @RequestMapping("/testBoolean")
    public String testBoolean(Model m) {
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);
        boolean testBoolean =true;

        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);
        m.addAttribute("testBoolean", testBoolean);

        return "test";
    }
    @RequestMapping("/foreach")
    public String foreach(Model m) {
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);
        boolean testBoolean = true;

        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(currentProduct);
        ps.add(new Product(6,"product f", 200));
        ps.add(new Product(7,"product g", 200));

        m.addAttribute("ps", ps);

        return "foreach";
    }
    @RequestMapping("/foreach2")
    public String foreach2(Model m) {

        Product currentProduct =new Product(5,"product 5", 200);

        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product 2", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product 4", 200));
        ps.add(currentProduct);
        ps.add(new Product(6,"product 6", 200));
        ps.add(new Product(7,"product seven", 200));

        m.addAttribute("ps", ps);

        Date now = new Date();
        m.addAttribute("now", now);

        return "foreach2";
    }



}
