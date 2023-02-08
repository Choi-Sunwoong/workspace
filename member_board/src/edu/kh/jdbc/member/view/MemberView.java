package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.Scanner;

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
		
		//2) 로그인이 되어있는 경우
		//		회원정보를 출력할 문자열을 만들어서 반환(return)
		//		단, 비밀번호는 제외
		String str = "이름 :" +loginMember.getMemberName(); // 이름
		str += "\n아이디 : " +loginMember.getMemberId(); // 아이디
		str += "\n성별 : " + loginMember.getMemberGender(); // 성별
		
		// 이름 : 유저일
		// 아이디 : user01
		// 나이 : 50세
		
		return;
		
		
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
