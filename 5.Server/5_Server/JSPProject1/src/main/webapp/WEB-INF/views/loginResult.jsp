<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 
	HTML 주석 : HTML 태그, CSS 등 HTML 요소만 주석 처리 가능
 -->
 
<%-- 
	JSP 주석 : HTML 요소 + JSP 전용 태그
	
	<% %>, <%= %>, <%@ %>,   ${EL},   <c:if>JSTL</c:if>
 --%>
 
 
<%--
	<%@ %> : 지시자(알려주거나 지시하는 속성을 기입)
	
	charset=UTF-8 : 현재 문서를 해석할 때 UTF-8 인코딩을 이용해서 해석 (해석 방법 안내)
	
	pageEncoding="UTF-8" : 현재 문서가 UTF-8 인코딩으로 작성되어 있음. (문서가 작성된 형식 안내)
	
	
	
	<% %> : 스크립틀릿(Scriptlet)
			JSP에서 자바 코드를 작성할 수 있는 영역
	-> JSTL 라이브러리를 이용해서 태그 형식 변경
	
	
	<%= %> : 표현식(Expression)
			자바코드의 값을 HTML 형식으로 출력 (자바의 값을 화면에 보이게 함)
			
	-> EL(Expression Language, 표현 언어)로 변경
 --%>
	

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 결과 페이지</title>
</head>
<body>
    <h1>로그인 결과</h1>
    
    <!-- jsp에서 자바코드의 값을 출력하는 방법 -->
    <%= request.getParameter("inputId") %>
    
    <br>
    
    <%= request.getParameter("inputPw") %>
    
    <br>
    
    <%= 2 * 5 + 10 %>
    
    <% 
    	// 자바 주석 기능
    	// 여기는 JSP -> Servlet으로 부터 전송받은 req, resp가 있음
    	// -> req, resp를 사용할 수 있다.
    	// -> 대신 이름이 request, response로 바뀜!
    	
    	// request.getAttribute("key") -> value(Object 타입)
    	
    	String res = (String)request.getAttribute("r");
    					// -> 다운캐스팅 필요
    %>
    
    				<!--  res 변수에 저장된 값이 출력됨 -->
    <h3 style='color:green;'> <%= res %> </h3>
    
    
	<button type='button' onclick='history.back()'>돌아가기</button>
   
</body>
</html>