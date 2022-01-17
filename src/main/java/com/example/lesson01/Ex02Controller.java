package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // @RestController가 아님에 주의, 뷰는 @ResponseBody가 없음!
public class Ex02Controller {
// view는 무조건 controller!!
// RestController는 api를 사용하는것이다. 데이터를 담을때!! 사용 
	// api는 response의 body에 담는것이므로 RestController를 사용하는것이다!!
	
	@RequestMapping("/lesson01/ex02/1") 
	// view는 무조건 String 이다!! 
	// response가 없을경우엔 스프링에서 경로라고 생각한다.
	public String view() {
		// RsponseBody가 아닌 상태로 String을 리턴하면
		// ReponseBOdy가 있으면 그자체가 리턴된다 생가하면된다.
		// ViewResolver에 의해 리턴된 String의 경로에 해당하는 view를 찾고 view 화명이 구성된다.
		
		// application.properties에서 prefix 와 suffix을 설정해줬으므로
		// /WEB-INF/jsp/_____.jsp 이므로   
		//  prifix             suffix
		return "lesson01/ex02";
		
	}
	
}
