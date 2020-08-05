package com.daiso.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiso.service.ReviewService;
import com.daiso.vo.ReviewVO;

@RestController
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/review")
	public Map create(@RequestBody Map<String, String> map, HttpServletRequest http) {
		logger.info(map.toString());
		ReviewVO review = new ReviewVO();
		review.setM_userid(http.getUserPrincipal().getName());
		logger.info("버그"+map.get("r_comment"));
		logger.info("버그"+map.get("b_num"));
		review.setR_comment(map.get("r_comment"));
		review.setB_num(Integer.parseInt(map.get("b_num")));
		reviewService.insertReview(review);
		return map;
	}
	
	@GetMapping("/review/{b_num}")
	public Map list(@PathVariable("b_num") int b_num) {
		List<ReviewVO> list = reviewService.selectReview(b_num);
		logger.info("디버"+list.get(0).getR_date());
		Map<String,Object> review = new HashMap<String, Object>();
		review.put("list",list);
		return review;
	}
	
	@DeleteMapping("/review/{r_num}")
	public Map delete(@PathVariable("r_num") int r_num) {
		logger.info("삭제");
		logger.info(String.valueOf(r_num));
		reviewService.deleteReview(r_num);
		Map<String,String> review = new HashMap<String, String>();
		review.put("code","success");
		return review;
	}
}
