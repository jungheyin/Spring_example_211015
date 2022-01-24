package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

// view 화면으로 꾸며지므로 Controller이다!

@RequestMapping("/lesson04/ex01")
@Controller
public class UserController {
	
	
	@Autowired
	private UserBO userBO;
	
	// http://localhost:8080/lesson04/ex01/add_user_view
	// view를 보내는 GET방식
//	@RequestMapping("/add_user_view") // 어떤 메소드든 호출한다.
	@RequestMapping(path = "/add_user_view", method = RequestMethod.GET) // get방식만 호출할수 있음!!
	public String addUserView() { // (ResponseBody가 없으므로)controller의 String은 view의 경로를 리턴한다.
		return "lesson04/addUser"; // /WEB-INF/jsp/lesson04/addUser.jsp
	}
	
	// http://localhost:8080/lesson04/ex01/add_user
	// 주소치고 들어오면 405번 에러난다. 무조건 post방식으로만 들어와야한다.
	// 테스트를 할때 포스트맨 프로그램 사용해서 보기!!
	@PostMapping("/add_user") // post만 호출하는 방식!!
	public String addUser(
			// 쿼리 파라미터들을 받아온다 
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String eamil,
			@RequestParam(value = "introduce", required=false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, eamil, introduce);
		// 결과 view 화면
		return "lesson04/aferAddUser";
	}
	
	// http://localhost:8080/lesson04/ex01/get_last_user
	// 이주소를 치면 마지막 유저의 정보만 나온다. => get
	@GetMapping("/get_last_user")
	public String getLastuser(Model model) {
		// 마지막(가장 최근)에 추가된 사람 한명 정보 가져오기
		// select를 해서 가져온다.
		User lastUser = userBO.getLastUser();
		// model을 new를 하지 않아도 사용할수 잇음!!( bean이기 때문)
		model.addAttribute("result", lastUser); // 나중에 이름을 가지고 view에서 키 이름으로 사용할수 있음!!
		model.addAttribute("subject", "회원 정보"); // view에 데이터를 운반하는 메개체 
												// 결과 jsp view에 객체갑을 넘겨준다.
		return"lesson04/getLastUser"; // view의 경로 지정
	}
	
}
