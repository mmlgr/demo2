package com.example.demo2;

import java.sql.SQLOutput;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.how2java.springboot.pojo.Category;

@Mapper
public interface CategoryMapper {

    List<Category> findAll();


}