package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	System.out.println("이름, 나이를 제출받아서 처리할 코드 수행1");
	
	// 요청 시 함께 전달된 input 태그의 값 (==
	
	String inputName = req.getParameter("inputName");
	String inputAge = req.getParameter("inputAge");
	
	System.out.println( inputName+ " / " + inputAge);
	
	
	// resp.getWriter() : 서버가 클라이언트에게 응답할 수 있는 스트림을 얻어옴
	// -> PrintWriter : 출력 전용 스트림
	
	// 문서 형식과 문자 인코딩 지정
	// -> html 문서이고 문자는 UTF-8 형식으로 인코딩 되어있다.
	// --> 브라우저에 해당 내용에 맞게 해석 
	resp.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = resp.getWriter();
			
	out.print(inputName + "님입니다.");
	}
}