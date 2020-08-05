package com.daiso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.ReviewDao;
import com.daiso.vo.ReviewVO;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;
	@Override
	public void insertReview(ReviewVO review) {
		// TODO Auto-generated method stub
		reviewDao.create(review);
	}
	@Override
	public List<ReviewVO> selectReview(int b_num) {
		// TODO Auto-generated method stub
		return reviewDao.readAll(b_num);
	}
	@Override
	public void deleteReview(int r_num) {
		// TODO Auto-generated method stub
		reviewDao.delete(r_num);
	}
	@Override
	public void deleteReviewAll(int b_num) {
		// TODO Auto-generated method stub
		reviewDao.deleteAll(b_num);
		
	}

	
}
