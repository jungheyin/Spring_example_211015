<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain." />
	
	<h1>1. 길이 구하기</h1>
	${fn:length(str1)} <br>
	
	<h1>2. 특정 문자열이 있는지 확인</h1>
	No가 있는가? ${fn:contains(str1, "No")} <br>
	no가 있는가? ${fn:contains(str1, "no")} <br> <!-- 대소문자 구별한다. -->
	
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}" >  
		문장에 no라는 문자열이 존재합니다.(대소문자 구별하지 않음)
	</c:if>
	
	<h1>3. 특정 문자열로 시작하는지 확인</h1>
	No로 시작하는가? ${fn:startsWith(str1, "No")} <br>
	
	<h1>4. 특정 문자열로 끝나는지 확인</h1>
	n으로 끝나는가? ${fn:endsWith(str1, "n")} <br>
	.으로 끝나는가? ${fn:endsWith(str1, ".")} <br> <%--.은 단독적으로 사용시 에러가 많이 날수도 있음 자바에서 .으로 사용안하는것이 나음 --%>
	gain.으로 끝나는가? ${fn:endsWith(str1, "gain.")} <br>
	
	<h1>5. 문자열 치환</h1>
	<c:set var="str2"> I love chicken.</c:set>
	
	${str2} <br>
	${fn:replace(str2, 'chicken', 'bread')} <%--파라미터가 3개 들어간다. --%>
	
	<h1>6. 구분자로 잘라서 배열 만들기</h1>
	${fn:split(str1, '.')[0]} <br> <%--.은 jsp는 되지만 java 쪽에서는 안될수도있다. --%>
	${fn:split(str1, '.')[1]}
	
	<h1>7. 시작 인덱스부터 끝 인덱스까지 자르기</h1>
	<%-- I love chicken. --%>
	<%--love 추출 --%>
	${fn:substring(str2, 2, 6)}
	
	<h1>8. 모두 소문자로 변경하기</h1>
	${fn:toLowerCase(str2)}
	
	<h1>9. 모두 대문자로 변경하기</h1>
	${fn:toUpperCase(str2)}
	
	<h1>10. 앞뒤 여백 제거</h1>
	<c:set var="str3" value="                   hello                    " />
	<pre>${str3}</pre>
	<pre>${fn:trim(str3)}</pre>
</body>
</html>