package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		return  reviewDAO.selectReview(id);
	}
	
	public int addReview(Review review) { // int는 몇개의 행이 insert 되는지 알려준다.
		return reviewDAO.insertReview(review);
	}
	
	public int insertReviewAsField(int storeId, String menu, String userName, double point, String review) {
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	public void updateReviewById(int id, String review) {
		reviewDAO.updateReviewById(id, review);
	}
	
	public void deleteReviewById(int id) {
		reviewDAO.deleteReviewById(id);
	}
}
