package com.mapper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.daiso.vo.ProductVO;

@Mapper
public interface ProductMapper {
    @Select("SELECT p_productid FROM product WHERE p_img=#{name}")
    int readProductId(String name);
    
    @Select("SELECT p_img FROM product WHERE p_productid=#{id}")
    String readProductSrc(int id);
    
    @Select("SELECT * FROM product WHERE p_productid=#{id}")
    ProductVO readProduct(int id);
}
