package edu.kh.jdbc.main.model.service;

import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.vo.Member;

import static edu.kh.jdbc.common.JDBCTemplate.*;

// Service : 데이터 가공, 트랜잭션 제어 처리
public class MainService {
	private MainDAO dao = new MainDAO();
	
	/**
	 * @param memberId
	 * @param memberPw
	 * @return
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		Member loginMember = dao.login(conn, memberId, memberPw);
		
		// 3. 커넥션 반환
		close(conn); 
		// 4. 조회 결과 반환
		return loginMember;
	}

	/** 아이디 중복 검사 서비스
	 * @param memberId
	 * @return
	 */
	public int idDupCheck(String memberId) throws Exception {
		// 1. 커넥션 생성
		Connection conn = getConnection();

		// 2. DAO 메서드 호출 후 결과 반환 받기
		int result = dao.idDupCheck(conn, memberId);
		
		// 3. 커넥션 반환
		close(conn);
		
		
		return result;
			
	}

	/**
	 * @param member
	 * @return
	 */
	public int signUp(Member member) throws Exception {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		int result = dao.signUp(conn, member);
		
		// 3. 트랜잭션 제어 처리
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		return result;
		
		
	}

}
