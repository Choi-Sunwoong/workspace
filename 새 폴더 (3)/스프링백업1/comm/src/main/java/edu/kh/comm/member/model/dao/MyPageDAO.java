package edu.kh.comm.member.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.member.model.vo.Member;

@Repository
public class MyPageDAO {
	
	@Autowired // root-context.xml 에서 생성된 SqlSessionTemplate bean을 의존성 주입(DI)
	private SqlSessionTemplate sqlSession;
	

	
	public void session(Member vo) throws Exception {
		
		sql.delete("memberMapper.session", vo);
	}

	
	/** 회원 정보 수정 DAO
	 * @param paramMap
	 * @return result
	 */
	public int updateInfo(Map<String, Object> paramMap) {
		
		return sqlSession.update("myPageMapper.updateInfo", paramMap);
	}

	/** 현재 로그인한 회원의 암호화된 비밀번호 조회 DAO
	 * @param memberNo
	 * @return
	 */
	public String selectEncPw(int memberNo) {
		
		return sqlSession.selectOne("myPageMapper.selectEncPw",memberNo);
	}
	
	/** 비밀번호 변경 DAO
	 * @param paramMap
	 * @return result
	 */
	
	public int changePw(Map<String, Object> paramMap) {
		
		return sqlSession.update("myPageMapper.changePw", paramMap);
	}
	
	public int secession(int memberNo) {
		
		return sqlSession.update("myPageMapper.secession", memberNo);
	}
	
	public int updateProfile(Map<String, Object> map) {
		
		return sqlSession.update("myPageMapper.updateProfile", map);
	}
}
