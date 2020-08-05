package com.daiso.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.ReviewVO;
import com.mapper.mapper.ReviewMapper;

@Repository
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	ReviewMapper reviewMapper;
	@Override
	public void create(ReviewVO review) {
		// TODO Auto-generated method stub
		reviewMapper.InsertReview(review);
	}

	@Override
	public void read(Map map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReviewVO> readAll(int b_num) {
		// TODO Auto-generated method stub
		return reviewMapper.selectReview(b_num);
	}

	@Override
	public void update(ReviewVO review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int r_num) {
		// TODO Auto-generated method stub
		reviewMapper.deleteReview(r_num);
	}

	@Override
	public void deleteAll(int b_num) {
		// TODO Auto-generated method stub
		reviewMapper.deleteReviewAll(b_num);
	}

}
