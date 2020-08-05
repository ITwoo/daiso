package com.daiso.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.ProductDao;
import com.daiso.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductDao productDao;
	@Override
	public int selectProductId(String name) {
		// TODO Auto-generated method stub
		return productDao.readId(name);
	}
	
	@Override
	public String selectProductSrc(int id) {
		return productDao.readSrc(id);
	}
	
	@Override
	public ProductVO selectProduct(int id) {
		return productDao.read(id);
	}
}
