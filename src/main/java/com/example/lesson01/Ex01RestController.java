package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController 	// @Controller + @ResponseBody
public class Ex01RestController {	// Spring Bean (Bean을 객체로 생각하면 된다 빈은 Spring이 관리한다.)
	
	
	
	//http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	//http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "ddd");
		map.put("a3", "ddddd");
		map.put("af", "dd");
		
		return map;
	}
	//http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("정혜인");
		
		return data;	// 일반 bean 객체도 json으로 내려간다.
	}
	
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> pringEntity() { //spring에서 지원해 주는 class중 하나!
		Data data = new Data();
		data.setId(2);
		data.setName("신바다");
		
//		return new ResponseEntity<>(data, HttpStatus.OK); // import 해줘야한다 http의 상태규약 ok는200
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); 
		// 에러는 아니지만 나중에 잘못됐을경우 임의로 에러번호를 직접 지정해서 에러를 내리고 싶을때 사용하는 방법
		// 에러처리에 디테일하게 잡을때 좋다!!
	
	}
}
