package com.daiso.service;

import java.util.Map;

import com.daiso.vo.ProductVO;

public interface ProductService {
	int selectProductId(String name); 
	String selectProductSrc(int id);
	ProductVO selectProduct(int id);
}
