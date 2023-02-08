package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.main.model.service.MainService;
import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.vo.Member;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	
	// 로그인 회원 정보 저장용 변수
	private Member loginMember = null;

	public void memberMenu(Member loginMember) {
		
		// 전달 받은 로그인 회원 정보를 필드에 저장
		this.loginMember = loginMember;
		
		
	}
	
	public void loginMember() {
		
		int input = -1;
		
		do {
			
			try {
				
				System.out.println("\n****** 회원 기능 ******");
				System.out.println("1. 내 정보 조회");//1. 내 정보 조회
		  		System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");//2. 회원 목록 조회(아이디, 이름, 성별)
		  		System.out.println("3. 내 정보 수정(이름, 성별)");//3. 내 정보 수정(이름, 성별)
		  		System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)");//4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)
		  		System.out.println("5. 회원탈퇴");// 5. 회원 탈퇴
		  		System.out.println("6. 회원메뉴로 되돌아가기");
		  		
		  		System.out.print("\n메뉴 선택 : ");
				
				input = sc.nextInt();
				sc.nextLine(); // 입력버퍼 개행문자 제거
				System.out.println();
				
				switch(input) {
				
				case 1: selectMyInfo(); break;
				case 2: selectAll(); break;
				case 3:	updateMember(); break;
				case 4:	updatePw(); break;
				case 5:	secession(); break;
				case 6:	
				case 0: 
					System.out.println("프로그램 종료"); 
					break;// 프로그램종료
				
				default : 
					System.out.println("메뉴에 작성된 번호만 입력해주세용");
				}
				
				System.out.println();
				
			
		} catch (InputMismatchException e)	{
			System.out.println("\n <<입력 형식이 올바르지 않습니다.>>");
			sc.nextLine();
		}	
			
	} while (input != 0);
		
	
	}

	



	/**
	 * 내 정보 조회 
	 */
	private void selectMyInfo(){
		System.out.println("[내 정보 조회]");
		
		// SERVICE의 회원정보 조회 기능 호출 반환
		// 정보를 조회할 회원의 아이디를 확인할 방법
		//1. session
		String sessionLoginId = (String)MemberService.getAttribute("loginId");//반환시 object 형식이라 String으로 형변환
		System.out.println("로그인아이디_세션 : " + sessionLoginId);
		String requestLoginId = MemberService.getParameter("loginId");
		System.out.println("로그인아이디_리퀘스트 : " + requestLoginId);
		
		//
		Member mInfo = msvc.memberInfo(sessionLoginId); // memberInfo메서드로 받아오는 회원 정보는 여러 정보이므로 memberDto타입 객체로 담음
		System.out.println(mInfo);
		//회원정보 출력 페이지 포워딩
		request.setAttribute("memberInfo", mInfo);//첫번째 매개변수 : 이름 , 두번째 매개변수 : 이름에 저장해줄 값
		
		dispatcher = request.getRequestDispatcher("MemberInfo.jsp");// redirect는 응답과 동시에 데이터가 사라지니까, 데이터가 사라지지 않는 dispatcher를 사용
		dispatcher.forward(request, response);
		break;
	}
	로그인시 session에 Attribute를 set 했으므로, 회원정보 확인 버튼을 클릭하면 
	session의 loginId값을 get해 출력하여 제대로 작동 되는지 확인

	* MemberService의 memberInfo()메서드 *
	//회원정보 조회 메소드
	public MemberDto memberInfo(String sessionLoginId) {
		System.out.println("MemberService memberInfo() 호출");
		MemberDto mInfo = dao.seleceMemberInfo(sessionLoginId);
		return mInfo;
	}

	* MemberDao의 seleceMemberInfo()메서드 *
	//회원정보 SELECT 메소드
	public MemberDto seleceMemberInfo(String sessionLoginId) {
		System.out.println("MemberDao selectMemberInfo() 호출");
		String sql = "SELECT * FROM TEST_MEMBER "
			+ "WHERE MID = ?";
		MemberDto mInfo = null;
	try {
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sessionLoginId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			mInfo = new MemberDto();
			mInfo.setMid(rs.getString(1));
			mInfo.setMpw(rs.getString(2));
			mInfo.setMname(rs.getString(3));
			mInfo.setMbrith(rs.getString(4));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return mInfo;
}
	
	/**회원목록 조회
	 * @return str
	 */
	private String selectAll() {
		System.out.println("[회원 목록 조회(아이디, 이름, 성별)]");
				
		
		//2) 로그인이 되어있는 경우
		//		회원정보를 출력할 문자열을 만들어서 반환(return)
		//		단, 비밀번호는 제외
		String str = "이름 :" +loginMember.getMemberName(); // 이름
		str += "\n아이디 : " +loginMember.getMemberId(); // 아이디
		str += "\n성별 : " + loginMember.getMemberGender(); // 성별
				
		// 이름 : 유저일
		// 아이디 : user01
		// 나이 : 50세
				
		return str;
		
		
		}	
	

	private int updateMember() {
		System.out.println("[내 정보 수정(이름, 성별)]");
		
		if(loginMember == null) {
			return -1;
		}	
		
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();
		
		while(true) {
		System.out.print("수정할 성별(M/F) : ");
		memberGender = sc.next().toUpperCase();
		
		System.out.println();
		if(memberGender.equals("M") || memberGender.equals("F")) {
			break;
		} else {
			System.out.println("[M 또는 F만 입력하세요!]");
		}
		
		System.out.println();
	}
		return 0;
		
	}
	
	private int updatePw() {
		System.out.println("[비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)]");
		
		if(loginMember == null) {
			return -1;
		}	
		
		System.out.print("수정할 비밀번호: ");
		String inputName = sc.next();
		
		while(true) {
		System.out.print("수정할 성별(M/F) : ");
		memberGender = sc.next().toUpperCase();
		
		System.out.println();
		if(memberGender.equals("M") || memberGender.equals("F")) {
			break;
		} else {
			System.out.println("[M 또는 F만 입력하세요!]");
		}
		
		System.out.println();
	}
		return 0;
		
	}



}
