package edu.kh.comm.member.model.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.comm.common.Util;
import edu.kh.comm.member.model.dao.MyPageDAO;
import edu.kh.comm.member.model.vo.Member;


@Service
public class MyPageServicempl implements MyPageService {
	
	@Autowired
	private MyPageDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private Logger logger = LoggerFactory.getLogger(MyPageServicempl.class);



	@Override
	public void session(Member vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	// 회원 정보 수정 서비스 구현
	@Override
	public int updateInfo(Map<String, Object> paramMap) {
		
		return dao.updateInfo(paramMap);
	}

	@Override
	public int ChangePw(Map<String, Object> paramMap) {
		
		// 1) DB에서 현재 회원의 비밀번호를 조회
		String encPw = dao.selectEncPw( (int)paramMap.get("memberNo"));
		
		// 2) 입력된 현재 비밀번호(평문)와
		// 	  조회된 비밀번호(암호화)를 비교(bcrypt.matches() 이용)
		
		// 3) 비교 결과가 일치하면
		//		새 비밀번호를 암호화해서 update 구문 수행
		
		if( bcrypt.matches( (String) paramMap.get("currentPw"), encPw)) {
			
			paramMap.put("newPw", bcrypt.encode( (String)paramMap.get("newPw") ));
			// Map에 이미 같은 key가 존재하면
			// value만 덮어씌움
			
			return dao.changePw(paramMap);
			
		}
		// 비교 결과가 일치하지 않으면 0반환
		// -> 현재 비밀번호가 일치하지 않습니다.
		
		return 0;		
	}

	
	// 회원 탈퇴 서비스 구현
	@Override
	public int secession(Member loginMember) {
		// 1) DB에서 암호화된 비밀번호를 조회하여 입력받은 비밀번호와 비교
		String encPw = dao.selectEncPw( loginMember.getMemberNo() );
		
		if( bcrypt.matches (loginMember.getMemberPw() , encPw)) {
			
			// 2) 비밀번호가 일치하면 회원번호를 이용해서 탈퇴 진행
			return dao.session(loginMember.getMemberNo());
		}
		
		// 3) 비밀번호가 일치하지 않으면 0 반환
		return 0;
	}

	@Override
	public int updateProfile(Map<String, Object> map) throws IOException {
		// webPath, folderPath, uploadImage, delete, memberNo
	
		// 자주쓰는 값 변수에 저장
		MultipartFile uploadImage = (MultipartFile) map.get("uploadImage");
		String delete = (String) map.get("delete"); // "0" (변경) / "1" (삭제)
		
		// 프로필 이미지 삭제여부를 확인해서
		// 삭제가 아닌 경우(== 새 이미지로 변경) -> 업로드된 파일명을 변경
		// 삭제가 된 경우 -> NULL 값을 준비 (DB update)
		
		String renameImage = null; //변경된 파일명 저장
		
		if( delete.equals("0") ) { // 이미지가 변경된 경우
		
			// 파일명 변경
			// uploadImage.getOriginalFilename() : 원본 파일명
			renameImage = Util.fileRename(uploadImage.getOriginalFilename());
			//
			
		} else {
		
			map.put("profileImage", null);
		}
		
		int result = dao.updateProfile(map);
		
		if(result > 0 && map.get("profileImage") != null) {
			uploadImage.transferTo( new File( map.get("folderPath") + renameImage ));
		}
		
		
		
		return result;
	}
	
	
	
	

}

