package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@Controller
public class lesson06Ex02Controller {
	// 회원가입할때 아이디가 중복인지 확인
	// 중복확인시 화면이 그대로인데 조회하는 것 
	// AJAX의 대표적인 예이다.
	
	@Autowired
	private UserBO userBO;
	@RequestMapping("/add_name_view")
	public String addNameView() {
		return "lesson06/addName"; 
	}
	
	@RequestMapping("/is_duplication")
	public Map<String, Boolean> idDuplication( //레퍼 클레스만 들어갈 수 있으므로 대문자로 써줘야한다.
		@RequestParam("name") String name) {
		
		// 중복 확인 DB
		boolean existUser = userBO.existUserByName(name);
		// Map 구성 후 리턴
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", existUser);
		
		return result;
	}
}
