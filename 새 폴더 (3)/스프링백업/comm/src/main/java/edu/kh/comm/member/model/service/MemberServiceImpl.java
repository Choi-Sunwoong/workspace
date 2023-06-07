package edu.kh.comm.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MemberDAO;
import edu.kh.comm.member.model.vo.Member;

@Service // 鍮꾩쫰�땲�뒪 濡쒖쭅(�뜲�씠�꽣 媛�怨�, DB �뿰寃�)�쓣 泥섎━�븯�뒗 �겢�옒�뒪�엫�쓣 紐낆떆 + bean �벑濡�
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	/* Connection�쓣 Service�뿉�꽌 �뼸�뼱�솕�뜕 �씠�쑀 
	 * 
	 * - Service�쓽 硫붿꽌�뱶 �븯�굹�뒗 �슂泥��쓣 泥섎━�븯�뒗 �뾽臾� �떒�쐞
	 * -> �빐�떦 �뾽臾닿� �걹�궃 �썑 �듃�옖�옲�뀡�쓣 �븳踰덉뿉 泥섎━�븯湲� �쐞�빐�꽌
	 *    �뼱姨붿닔�뾾�씠 Connection�쓣 Service�뿉�꽌 �뼸�뼱�삱 �닔 諛뽰뿉 �뾾�뿀�떎.
	 * */
	
	
	// �븫�샇�솕瑜� �쐞�븳 bcrypt 媛앹껜 �쓽議댁꽦 二쇱엯(DI)
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	
	// 濡쒓렇�씤 �꽌鍮꾩뒪 援ы쁽
	@Override
	public Member login(Member inputMember) {
		
		// �쟾�떖 諛쏆� 鍮꾨�踰덊샇瑜� �븫�샇�솕�븯�뿬
		// DB�뿉�꽌 議고쉶�븳 鍮꾨�踰덊샇�� 鍮꾧탳 (DB�뿉�꽌 鍮꾧탳 X)
		
		
		// sha 諛⑹떇 �븫�샇�솕
		// A �쉶�썝 / 鍮꾨�踰덊샇 1234 -> �븫�샇�솕 : abcd
		// B �쉶�썝 / 鍮꾨�踰덊샇 1234 -> �븫�샇�솕 : abcd(�븫�샇�솕 �떆 蹂�寃쎈맂 �궡�슜�씠 媛숈쓬)
		
		
		// Bcrypt �븫�샇�솕 : �븫�샇�솕 �븯湲곗쟾�뿉 salt 瑜� 異붽��븯�뿬 蹂��삎�맂 �긽�깭濡� �븫�샇�솕瑜� 吏꾪뻾
		// A �쉶�썝 / 鍮꾨�踰덊샇 1234 -> �븫�샇�솕 : abcd
		// B �쉶�썝 / 鍮꾨�踰덊샇 1234 -> �븫�샇�솕 : @bdg
		
		// * 留ㅻ쾲 �븫�샇�솕�릺�뒗 鍮꾨�踰덊샇媛� �떖�씪�졇�꽌  DB�뿉�꽌 吏곸젒 鍮꾧탳 遺덇��뒫
		// ���떊 Bcrypt �븫�샇�솕瑜� 吏��썝�븯�뒗 媛앹껜媛� 
		// �씠瑜� 鍮꾧탳�븯�뒗 湲곕뒫(硫붿꽌�뱶) 媛�吏�怨� �엳�뼱�꽌 �씠瑜� �솢�슜�븯硫� �맂�떎!
		
		// ** Bcrypt �븫�샇�솕瑜� �궗�슜�븯湲� �쐞�빐 �씠瑜� 吏��썝�븯�뒗 Spring-security 紐⑤뱢 異붽� **
		logger.debug(inputMember.getMemberPw() + " / " + bcrypt.encode(inputMember.getMemberPw()));
//		logger.debug(inputMember.getMemberPw() + " / " + bcrypt.encode(inputMember.getMemberPw()));
//		logger.debug(inputMember.getMemberPw() + " / " + bcrypt.encode(inputMember.getMemberPw()));
//		logger.debug(inputMember.getMemberPw() + " / " + bcrypt.encode(inputMember.getMemberPw()));
//		logger.debug(inputMember.getMemberPw() + " / " + bcrypt.encode(inputMember.getMemberPw()));
	
		
		Member loginMember = dao.login(inputMember);
		
		// loginMember == null : �씪移섑븯�뒗 �씠硫붿씪 �뾾�떎
		
		if(loginMember != null) { // �씪移섑븯�뒗 �씠硫붿씪�쓣 媛�吏� �쉶�썝 �젙蹂닿� �엳�쓣 寃쎌슦
			
			//				�엯�젰�맂 鍮꾨�踰덊샇(�룊臾�)		,	議고쉶�맂 鍮꾨�踰덊샇(�븫�샇�솕) 鍮꾧탳 => 媛숈�硫� true
			if( bcrypt.matches( inputMember.getMemberPw() , loginMember.getMemberPw())) { // 鍮꾨�踰덊샇媛� �씪移섑븷 寃쎌슦
				
				loginMember.setMemberPw(null); // 鍮꾧탳 �걹�궗�쑝硫� 鍮꾨�踰덊샇 吏��슦湲�
				
			} else { // 鍮꾨�踰덊샇媛� �씪移섑븯吏� �븡�쓣 寃쎌슦
				loginMember = null;
			
		}
		
		
		}
		
		return loginMember;
		
		// Connection�쓣 �뼸�뼱�삤嫄곕굹/諛섑솚�븯嫄곕굹
		// �듃�옖�옲�뀡 泥섎━瑜� �븯�뒗 援щЦ�쓣 �옉�꽦�븯吏� �븡�븘�룄
		// Spring�뿉�꽌 �젣�뼱瑜� �븯湲� �븣臾몄뿉 Service 援щЦ�씠 媛꾨떒�빐吏꾨떎.
	}

	// �씠硫붿씪 以묐났 寃��궗 �꽌鍮꾩뒪 援ы쁽
	@Override
	public int emailDupCheck(String memberEmail) {
		// TODO Auto-generated method stub
		return dao.emailDupCheck(memberEmail);
	}

	@Override
	public int nicknameDupCheck(String memberNickname) {
		// TODO Auto-generated method stub
		return dao.nicknameDupCheck(memberNickname);
	}

	@Override
	public int signUp(Member vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}




