package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	public Review selectReview(@Param("id") int id); // get -> select
	
	public int insertReview(Review review); // add -> insert
	
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") double point, 
			@Param("review") String review);  // 여러 파라미터들을 row로 추가
	
	public void updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	public void deleteReviewById(@Param("id") int id);
}
