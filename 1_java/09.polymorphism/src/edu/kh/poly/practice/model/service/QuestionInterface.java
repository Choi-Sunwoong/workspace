package edu.kh.poly.practice.model.service;

import java.util.Scanner;

public interface QuestionInterface {
	Scanner sc = new Scanner(System.in);
	
	private Person pArr = null; 

	// 메뉴 출력
	public abstract void displayMenu(); 
		menuNum1 = 0;
		
		do {
				System.out.println("====== 메뉴 출력======");
				System.out.println("1.모든 요소 출력");
				System.out.println("2.학생 정보만 출력");
				System.out.println("3.직원 정보만 출력");
				System.out.println("4.정보 찾기(이름)");
				System.out.println("5.모든 사람의 나이 (합/최고/최저) 출력");
				System.out.println("6.입력 인덱스 삭제");
				System.out.println("7.학생 or 직원등록");
				System.out.println("0.프로그램 종료");
				
				
				System.out.print("메뉴 입력 >> ");
				int menuNum1 = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum1) {
					case 1:System.out.println(); break;
					case 2:System.out.println(); break;
					case 3:
					case 4:
					case 5:	
						
				}
		
		}while(menuNum != 0);
		
	


	}	
		
	
	// 1. person 배열 pArr에 학생 또는 직원 등록하기.
	// -> 숫자 1을 입력 받으면 학생 객체를 생성해 배열요소에 대입
	// -> 숫자 2를 입력 받으면 직원 객체를 생성해 배열 요소에 대입
	public abstract void insertPerson();
	 menuNum = 0;
			
		do {
			System.out.println("====== 등록하기======");
			System.out.println("1.학생 등록");
			System.out.println("2.직원 등록");
			System.out.println("뒤로가기");
					
			System.out.print("메뉴 입력 >> ");
			int menuNum = sc.nextInt();
			sc.nextLine();
					
			switch(menuNum) {
				case 1:System.out.println(); break;
				case 2:System.out.println(); break;
				case 3:
				case 4:
				case 5:	
							
					}
			
		}while(menuNum != 0);
			public abstract void studnetup() {
				System.out.println("\n***** 등록 *****");
		
				System.out.print("이름: ");
				String Name = sc.next();
		
				System.out.print("나이: ");
				int Age = sc.nextInt();
		
				System.out.print("학년: ");
				int grade = sc.nextInt();
		
				System.out.print("반: ");
				int classroom = sc.nextInt();
		
				System.out.print("회사: ");
				String Company = sc.next();
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
				return "등록 성공";
				}
		 	
		

	}

	public abstract void selectAll() { 
		System.out.println("\n**********회원 정보 조회************");
	
		if(pArr == null) {
			return "로그인 후 이용해주세요";
}

		String str = "이름 :" +pArr.getName(); 
		int = "\n나이 : " + pArr.getAge() + "세"; 
		int = "\학년 : "+ pArr.getgrade() + "학년";
		int = "\반 : " + pArr.getclassroom() + "반";	
		Str = "회사 : " + pArr.getCompany();


		return str;
	}
	
	public abstract void selectStudent() {
		System.out.println("\n************학생 정보 출력***************");
		
		if(pArr == null) {
			return "로그인 후 이용해주세요";
}

		String str = "이름 :" +pArr.getName(); 
		int = "\n나이 : " + pArr.getAge() + "세"; 
		int = "\학년 : "+ pArr.getgrade() + "학년";
		int = "\반 : " + pArr.getclassroom() + "반";	
		

		return str;

	

	
	}
	
	public abstract void selectEmployee() {
		
		System.out.println("\n**********회원 정보 조회************");
		
		if(pArr == null) {
			return "로그인 후 이용해주세요";
}

		String str = "이름 :" +pArr.getName(); 
		int = "\n나이 : " + pArr.getAge() + "세"; 
		Str = "회사 : " + pArr.getCompany();


		return str;
			
	
	}
	
	public abstract Person serchName();
}