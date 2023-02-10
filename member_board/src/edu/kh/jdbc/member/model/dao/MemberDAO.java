package edu.kh.jdbc.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.vo.Member;

public class MemberDAO {
	
	// 필드
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	private Properties prop;
	// Map<String, String> 제한, XML 파일 읽고/쓰는데 특화
	
	
	// 기본생성자
	public MemberDAO() {
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-query.xml"));
		} catch(Exception e) {
			
		}
	}
	public List<Member> sellectAll(Connection conn) throws Exception {
		
		List<Member> memberList = new ArrayList();
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("selectAll");
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL(SELECT) 수행 후 결과(ResultSet) 반환받기
			rs = stmt.executeQuery(sql);
			
			// 반복문(while)을 이용해서 조회 결과의 각 행에 접근
			while(rs.next()) {
				// 컬럼 값을 얻어와 Member 객체 저장 후 List에 추가
				
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				
				Member member = new Member();
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				
				memberList.add(member);
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return memberList;
	}
		
	public int updateMember(Connection conn, Member member) throws Exception() {
		
		int result = 0;
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberGender());
			pstmt.setInt(3, member.getMemberNo());
			
			result = pstmt.executeUpdate();
		
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updatePw(Connection conn, String currentPw, String newPw1, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw1);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, currentPw);
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		
		return result;
	}	
	
	public int secession(Connection conn, String memberPw, int memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberPw);
			
			result = pstmt.executeUpdate();
			
 		} finally {
 			close(pstmt);
 		}
		return result;
 			
 		}
		
		return 0;

}
