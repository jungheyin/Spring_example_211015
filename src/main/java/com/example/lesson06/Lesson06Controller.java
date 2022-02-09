package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Controller {

	@Autowired
	private UserBO userBO;
	// 유저 추가화면
	@RequestMapping("/lesson06/add_user_view")
	public String addUserView() {
		return "lesson06/addNewUser";
	}
	
	// 유저 추가 기능
	@PostMapping("/lesson06/add_user")
	@ResponseBody // 기능을 수행하고 결과를 보여줄때나 결과를 제이슨을 줄때 사용한다.
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("eamil") String email,
			@RequestParam(value="introduce", required=false) String introduce) { // 경로가 아닌 string / request params..
		
		// insert db
		userBO.addUser(name, yyyymmdd, email, introduce);
		// return string
		return "성공";
	}
	
}
