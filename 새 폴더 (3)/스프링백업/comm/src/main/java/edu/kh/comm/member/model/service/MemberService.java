package edu.kh.comm.member.model.service;

import edu.kh.comm.member.model.vo.Member;

/* Service Interface瑜� �궗�슜�븯�뒗 �씠�쑀
 * 
 * 1. �봽濡쒖젥�듃�뿉 洹쒖튃�꽦�쓣 遺��뿬�븯湲� �쐞�빐�꽌
 * 
 * 2. Spring AOP瑜� �쐞�빐�꽌 �븘�슂
 * 
 * 3. �겢�옒�뒪媛꾩쓽 寃고빀�룄瑜� �빟�솕 �떆�궎湲� �쐞�빐�꽌 -> �쑀吏�蹂댁닔�꽦 �뼢�긽
 * 
 * */
public interface MemberService {

	// 紐⑤뱺 硫붿꽌�뱶媛� 異붿긽 硫붿꽌�뱶 (臾듭떆�쟻�쑝濡� public abstract) 
	// 紐⑤뱺 �븘�뱶�뒗   �긽�닔        (臾듭떆�쟻�쑝濡� public static final)
	
	/** 濡쒓렇�씤 �꽌鍮꾩뒪
	 * @param inputMember
	 * @return loginMember
	 */
	public abstract Member login(Member inputMember);

	/** �씠硫붿씪 以묐났 寃��궗
	 * @param memberEmail
	 * @return
	 */
	
	
	public abstract int emailDupCheck(String memberEmail);

	
	/** �땳�꽕�엫 以묐났 寃��궗
	 * @param memberNickname
	 * @return
	 */
	
	public abstract int nicknameDupCheck(String memberNickname);

	public abstract int signUp(Member vo) throws Exception;


	
	
}
