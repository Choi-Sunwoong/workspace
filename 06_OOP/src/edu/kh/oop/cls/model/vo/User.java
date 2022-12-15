package edu.kh.oop.cls.model.vo;

public class User {
	// 필드
	// == 속성
		
	// 아이디, 비밀번호, 이름, 나이, 성별
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;
	
	// 생성자
	public User() { 
		// 기능
		System.out.println("기본 생성자로 User 객체 생성");
			
		// 필드 초기화 + 기능
		userId = "user01";
		userPw = "pass01";
		userName = "홍길동";
		userAge = 20;
		userGender = 'M';
		
		// ==> 
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
	// 메서드
	// 캡슐화로 인한 간접 접근 기능(getter/setter)
	
	
	// getter/setter 자동 완성
	// alt + shift + s -> Generate Getters and setters
	// => 선택 후 Generate
	

}
