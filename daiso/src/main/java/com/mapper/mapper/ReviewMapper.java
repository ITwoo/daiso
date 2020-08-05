package com.mapper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daiso.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
	@Insert("insert into review values(#{reviewVO.r_num},#{reviewVO.r_comment},now(),#{reviewVO.b_num},#{reviewVO.m_userid})")
	void InsertReview(@Param("reviewVO")ReviewVO reviewVO);
	
	@Select("Select * from review where b_num = #{num}")
	List<ReviewVO> selectReview(int num);
	
	@Delete("delete from review where r_num = #{r_num} ")
	void deleteReview(int r_num);
	
	@Delete("delete from review where b_num = #{b_num} ")
	void deleteReviewAll(int b_num);
}
