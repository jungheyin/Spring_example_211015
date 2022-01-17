package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {

	// String 출력하기
	// http://localhost:8080/lesson01/ex01/1
	@ResponseBody // 리턴되는 값이 Response로 들어간는 의미!(보낸다) 리턴값에 대한 설정!
	@RequestMapping("/lesson01/ex01/1") // 주소를 매핑하는것 일치하는값을 찾는것!
	public String printString() {
		String text = "<h1>예제1번</h1> <br> 문자열을 response body로 보내는 예제";
		return text;
	}
	
	// Map 리턴하기 => JSON 리턴하기
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/lesson01/ex01/2")
	public @ResponseBody Map<String, Object> printMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);		// {"apple"=4...}
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 167);		
		
		// Map을 리턴하면 json으로 나타낸다.
		// 이유: Web starter(의 라이브러리:Jackson)이 포함되어 있기 때문이다.
		return map;
	}
}
