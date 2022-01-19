package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:8080/lesson03/ex01
	// http://localhost:8080/lesson03/ex01?id=7
	
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// 여기서 인자값을 받는 파라미터부분
			//@RequestParam("id") int id // 필수 파라미터이다!!
//			@RequestParam(value="id", required=true) int id  // int는 null 값을 저장할 수 없음
//			@RequestParam(value="id", required=false) Integer id// 비 필수 파라미터 값이 없으면 null이므로 Integer로 써준다.
			@RequestParam(value="id", defaultValue="1") int id //비필수 값이면서 default값을 넣는 방법!
			
			) {
		System.out.println("######### id" + id);
		return reviewBO.getReview(id);
	}
	
	// 400대 에러일경우 이쪽에서 본다.
	//필수 파라미터를 쓰면 400대 에러가 나고 비필수 파라미터를 보내면 BO의 타입이 다를 경우 500대 에러가 나온다.
	// int라고 작성하면 null이 들어갈수 없기때문에 int 와 Integer 구분해서 꼭 작성해야한다.
}
