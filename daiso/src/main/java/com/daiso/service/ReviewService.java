package com.daiso.service;

import java.util.List;

import com.daiso.vo.ReviewVO;

public interface ReviewService {
	void  insertReview(ReviewVO review);
	List<ReviewVO> selectReview(int b_num); 
	void deleteReview(int r_num);
	void deleteReviewAll(int b_num);
}
