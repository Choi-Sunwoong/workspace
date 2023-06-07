package edu.kh.comm.member.model.dao;

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
	
	@Inject SqlSession sql;
	public void changePW(Member vo) throws Exception {
	
		sql.update("memberMapper.changePw", vo);
	}
	
	public void session(Member vo) throws Exception {
		
		sql.delete("memberMapper.session", vo);
	}

}
