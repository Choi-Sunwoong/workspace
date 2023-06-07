package edu.kh.comm.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MyPageDAO;
import edu.kh.comm.member.model.vo.Member;


@Service
public class MyPageServicempl implements MyPageService {
	
	@Autowired
	private MyPageDAO dao;
	
	private BCryptPasswordEncoder bcrypt;
	
	private Logger logger = LoggerFactory.getLogger(MyPageServicempl.class);

	@Override
	public void ChangePw(Member vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void session(Member vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
