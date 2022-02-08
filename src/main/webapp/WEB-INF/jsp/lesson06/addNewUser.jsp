<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/add_user"> <!-- action부분은 기능을 하는 부분이다. -->
			<div class="form-group">
				<label for="name">이름: </label>
				<input type="text" id="name" class="form-control" name="name" placeholder="이름을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일: </label>
				<input type="text" id="yyyymmdd" class="form-control" name="yyyymmdd" placeholder="예) yyyymmdd">
			</div>
			<div class="form-group">
				<label for="eamil">이메일 주소: </label>
				<input type="text" id="eamil" class="form-control" name="eamil" placeholder="이름을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개: </label>
				<textarea class="form-controll" id="introduce" name="introduce" rows="10" cols="20"></textarea>
			</div>
				<input type="submit" id="addBtn" class="btn btn-success" value="추가">
			
		</form>
	</div>
	
	<script>
	$(document).ready(function() {
		// 1. jquery의 submit 기능 이용하기
		/* $('form').on('submit', function(e) {
			// e.preventDefault(); // submit이 되는 것을 막는다.(넘어가는 것) 고유한 기능을 멈추게 할때 사용하는 함수, 항상 상단에 적어줘야한다.
			// alert("서브밋");
			
			// validation check
			let name = $('#name').val().trim();
			if (name.length < 1) {
				alert("이름을 입력해주세요");
				return false; // form 태그시 그냥 리턴하면 서버에 들어간다. 
			}
			
			let yyyymmdd = $('#yyyymmdd').val.trim();
			if (yyyymmdd.length < 1) {
				alert("생년월일을 입력해주세요");
				return false;
			}
			let eamil = $('#eamil').val.trim();
			if (eamil.length < 1) {
				alert("이메일을 입력해주세요");
				return false;
			}
			
			// 유효성 체크 통과 => 여기까지 도달하면 서브밋

		}); */
		
		// 2. jquery의 AJAX통신 이용하기
		// -- 버튼ㅇ의 타입을 submit -> button 변경
		$('#addBtn').on('click', function() { 
			//alert("추가 버튼 클릭");
			
			let name = $('#name').val().trim();
			if (name.length < 1) {
				alert("이름을 입력해주세요");
				return; // form 태그시 그냥 리턴하면 서버에 들어간다. 
			}
			
			let yyyymmdd = $('#yyyymmdd').val.trim();
			if (yyyymmdd.length < 1) {
				alert("생년월일을 입력해주세요");
				return;
			}
			
			// 모두 숫자인지 확인
			if (isNaN(yyyymmdd)) { // 숫자가 아닌 문자가 있을 때 true
				alert("숫자만 입력해 주세요")
				return;	
			}
			
			let eamil = $('#eamil').val.trim();
			if (eamil.length < 1) {
				alert("이메일을 입력해주세요");
				return;
			}
			
			let introduce = $('#introduce').val();
			consele.log(name);
			consele.log(yyyymmdd);
			consele.log(eamil);
			consele.log(introduce);
		});
		
		// AJAX 통신 : 폼태그와 상관없이 비동기로 요청(request)
		$.ajax({
			// request 
			type:'POST'
			, url:'/lesson06/add_user'//action
			, data: {'name':name,'yyyymmdd':yyyymmdd, 'email':eamil, 'introduce':introduce}//보내는 방법은 어려가지이다.
			// response
			, success: function(data) { // 많이 사용함
				alert(data);
				location.href="https://google.com";
				//location.reload(); // 새로고침 창
			}
			, complete: function(data){ // 완료라는 뜻 잘 사용 안함
				alert("완료");	
			}
			, error: function(data){ // 많이 씀
				alert("error:" + e);
			}
		});
		
	})
	</script>
</body>
</html>