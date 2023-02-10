package edu.kh.jdbc.member.model.service;

import java.sql.Connection;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	public List<Member> selectAll() throws Exception{
		Connection conn = getConnection();
		
		List<Member> memberList = dao.sellectAll(conn);
		
		close(conn);
		
		return memberList;

	}
	
	public int updateMember (Member member) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn,member);
		
		if(result>0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
		
	}
	
	public int updatePw (String currentPw, String newPw1, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.update{w(conn,currentPw,newPw1,memberNo);
		
		if(result>0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
		
	}
		
	public int secession(String memberPw, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.secession{w(conn,memberPw,memberNo);
		
		if(result>0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;

	}
		
	}


}
