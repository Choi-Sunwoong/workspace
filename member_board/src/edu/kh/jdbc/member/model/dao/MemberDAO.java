package edu.kh.jdbc.member.model.dao;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MemberDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	// Map<String, String> 제한, XML 파일 읽고/쓰는데 특화
	
	
	// 기본생성자
	public MemberDAO() {
		
		try {
			prop = new Properties(); // Properties 객체 생성
			
			prop.loadFromXML(new FileInputStream("member-query.xml"));
			// main-query.xml 파일의 내용을 읽어와 Properties 객체에 저장
			
		} catch(Exception e) {
			e.printStackTrace();
		}
 		
	}
	
	

}
