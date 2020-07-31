package com.ssm.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.how2java.springboot.pojo.Customer;

@Mapper
public interface CustomerMapper2 {
    @Select(" select * from t_customer where id=#{id}")
    Customer getCustomerById(int id);
}