package com.daiso.dao;

import java.util.Map;

import com.daiso.vo.ProductVO;

public interface ProductDao {
	int readId(String name);
	
	String readSrc(int id);
	
	ProductVO read(int id);
}
