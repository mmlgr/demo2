package com.ssm.mapper;


import java.util.ArrayList;
import java.util.List;
import com.how2java.springboot.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    public List<Customer> sqlif(Customer customer);
    public  Customer getCustbyid(Integer i);
    public  List<Customer> getCustbyid2(Integer i);
    public  List<Customer> selectchoose(Customer customer);
    public  List<Customer> mywhere(Customer customer);
    public  List<Customer> mytrim(Customer customer);
    public  int myset(Customer customer);
    public  List<Customer> myforeach(List<Integer> ids);
    public  List<Customer> myforeach2(List<String> usernames);
    public  List<Customer> mybind(Customer customer);
}