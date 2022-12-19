package edu.kh.oarr.model.servicce;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	private Scanner sc = new Scanner(System.in);
	
	// Member 5칸짜리 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];
	
	// 현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMember = null;
	
	public MemberService() { // 기본생성자
		// memberArr 배열 0,1,2 인덱스 초기화
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "홍길순", 25, "경기");
		memberArr[2] = new Member("user03", "pass03", "고길동", 37, "강원");
		
	}
	
	// 메뉴 출력용 메서드
	public void displayMenu() {
		int menuNum = 0;
			
		
		
		do { // 한 번은 무조건 반복
			System.out.println("=======회원 정보 관리 프로그램 v2 ========");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1:System.out.println(signUp()); break;
			case 2:System.out.println(login()); break;
			case 3:System.out.println(selectMember()); break;
			case 4:System.out.println(updateMember()); break;
			case 5:System.out.println(search());break;
			case 0: break;
			default : System.out.println("\n잘못 입력 하셨습니다.");
			}
			
		}while(menuNum != 0);

	}
	// 회원가입 메서드
	public String signUp() {
		System.out.println("\n======== 회원 가입 ========="); 
		
		// 객체 배열(memberArr)에 가입한 회원 정보를 저장할 예정
		// -> 새로운 회원 정보를 저장할 공간이 있는지 확인하고
		// 	  빈 공간의 인덱스 번호를 얻어오기 --> 새로운 메서드 작성
		
		int index = emptyIndex(); // memberArr 배열에서 비어있는 인덱스를 반환 받음.
		
		System.out.println("현재 회원 수:" + index );
		
		if(index == -1) { // 비어있는 인덱스가 없을 경우 -> 회원 가입 불가
			return "회원가입이 불가능 합니다.(인원 수 초과)";
		}
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		System.out.print("지역 : ");
		String region = sc.next();
		
		if( memberPw.equals(memberPw2)) {
			// Member 객체를 생성해서 할당된 주소를 memberArr 비어있는 인덱스에 대입
			memberArr[index] = new Member(memberId,memberPw,memberName,memberAge,region);
		
			return "회원 가입 성공!!";
		
		} else {
		
		
		return "회원 가입 실패(비밀번호 불일치)";
		}
	}
	// memberArr이 비어있는 인덱스 번호를 반환하는 메서드
	// 단, 비어있는 인덱스가 없으면 -1 반환
	public int emptyIndex() {
		// memberArr배열을 0번 인덱스부터 끝까지 접근해서
		// 참조하는 값이 null인 경우의 인덱스를 반환
		for(int i = 0; i < memberArr.length; i++) {
			if(memberArr[i] == null) {
				return i;
			}
		}
		// for문을 수행했지만 return이 되지 앟은 경우 해당 위치 코드가 수행!
		
		return -1;
	}
	
	public String login() {
		System.out.println("\n=======로그인=======");
		
		// 1) memberArr 배열 내 요소를 순서대로 접근하여 null이 아닌지 확인
		if(memberArr == null) { 
			return "회원 가입부터 진행하세요";
		}
		
		// 회원 정보가 있을 경우
		// 2) 회원정보(memberArr[i])의 아이디, 비밀번호와 
		// 입력받은 아이디, 비밀번호가 같은지 확인
			// 3) 로그인 회원 정보 객체(Member)를 참조하는 변수 loginMember에
			// 	  현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사

		System.out.print("아이디 입력: ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력: ");
		String memberPw = sc.next();
		
		if( memberId.equals(memberArr[0].getMemberId()) &&
			memberPw.equals(memberArr[0].getMemberPw()) ) {
			
			loginMember = memberArr[5];
			
			return loginMember.getMemberName()+"님 환영합니다!";
			
		} else {
			return "아이디 또는 비밀번호가 일치하지 않습니다";
		
		}
		// 4) 로그인 성공/실패 여부에 따라 결과값을 반환		
	}

	public String selectMember() {
		
		System.out.println("========회원 정보 조회========");
		
		
		if(loginMember == null) {
			return "로그인 후 이용해주세요";
		}
		
	
		String str = "이름 :" +loginMember.getMemberName(); // 이름
		str += "\n아이디 : " +loginMember.getMemberId(); // 아이디
		str += "\n나이 : " + loginMember.getMemberAge(); // 나이
		str += "\n지역 : " + loginMember.getRegion(); // 지역
		
		return str;
		
	}
	
	public int updateMember() {
		
		System.out.println("\n***** 회원 정보 수정 *****");
		
		// 1) 로그인 여부 판별
		//	로그인이 되어있지 않으면 -1 반환
		if(loginMember == null) {
			return -1;
		}
		
		// 2) 수정할 회원 정보 입력 받기(이름, 나이)
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
	
		System.out.print("수정할 지역 입력 : ");
		String inputregion = sc.next();
		
		sc.nextLine();
		// 입력버퍼 정리하기
		
		// 3) 비밀번호 입력 받아서
		// 	  로그인한 회원의 비밀번호와 일치하는지 확인
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if( inputPw.equals(loginMember.getMemberPw())) {		
		// 4) 비밀번호 같은 경우
		// 	  로그인한 회원의 이름, 나이 정보를 입력받은 값으로 변경 후
		//    1 반환 
		loginMember.setMemberName(inputName);
		// 입력받은 inputName을
		// loginMember가 참조하는 Member객체의 필드 memberName에 대입
		loginMember.setMemberAge(inputAge);
		
		loginMember.setRegion(inputregion);
		
		return 1;
		}else {
		// 5) 비밀번호가 다를 경우 0 반환
		return 0;

		}
	}
	
	public String search() {
		
		System.out.println("========회원 검색(지역) ========");
		
		if(loginMember == null) {
			return " ";
		}
		
		System.out.print("아이디 입력: ");
		String memberId = sc.next();
		
		if(memberId.equals(memberArr[0].getMemberId())){
			memberId += "\n지역 : " + loginMember.getRegion(); // 지역
			
			return " ";
			
		}
		return memberId;
	
		
		
	}

}

	