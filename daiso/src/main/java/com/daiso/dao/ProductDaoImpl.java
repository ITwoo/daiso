package com.daiso.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.ProductVO;
import com.mapper.mapper.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao{

	
	@Autowired
	ProductMapper productMapper;
	@Override
	public int readId(String name) {
		// TODO Auto-generated method stub
		return productMapper.readProductId(name);
	}
	
	@Override
	public String readSrc(int id) {
		return productMapper.readProductSrc(id);
	}
	
	@Override
	public ProductVO read(int id) {
		return productMapper.readProduct(id);
	}

}
