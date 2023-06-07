package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.vo.Member;

public interface MyPageService {
	
	public void ChangePw(Member vo) throws Exception;
	
	public void session(Member vo) throws Exception;
	
	
}
