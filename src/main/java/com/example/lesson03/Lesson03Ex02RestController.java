package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	// http://localhost/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();
		// id필드는 생략한다!! 자동으로 넘어가기 때문에
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("돼지");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요");
		
		int rowCount = reviewBO.addReview(review); // insert 된 row 수를 리턴 받는다.
		
		return "success row count:" + rowCount;
	}
}
