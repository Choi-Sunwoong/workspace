package edu.kh.comm.member.model.service;

import java.util.Map;

import edu.kh.comm.member.model.vo.Member;

public interface MyPageService {
	
	public void ChangePw(Member vo) throws Exception;
	
	public void session(Member vo) throws Exception;

	/**
	 * @param paramMap
	 * @return
	 */
	
	int updateInfo(Map<String, Object> paramMap);

	int ChangePw(Map<String, Object> paramMap);

	 int secession(Member loginMember);
	
	int updateProfile(Map<String, Object> map) throws IOException;
	
	 
}
