package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample { // 기능 정의용 클래스
	
	public void ex1() {
		// if문
		// - 조건식이 true 일 때만 내부 코드 수행
		/*
		 * [작성법]
		 * 	if(조건식) {
		 * 		조건식이 true 일 때 수행될 코드
		 * 	} 
		 * 
		 * 
		 * if - else 문
		 * - 조건식 결과가 true면 if문,
		 * 	false면 else 구문이 수행됨.
		 * 
		 * [작성법]
		 * if(조건식) {
		 * 		조건식이 true일 때 수행도리 코드
		 * } else {
		 * 		조건식이 false일 때 수행될 코드
		 * }
		 *  
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 입력된 정수가 양수인지 검사
		if(input > 0) {
			System.out.println("양수 입니다.");
		} else {
			System.out.println("양수가 아니다.");
		}
		
		/*if(input <= 0) {
			System.out.println("양수가 아니다." );
		}*/
	}
	
	public void ex2() {
		//	홀짝검사
		//	입력받은 값이 홀인지 짝인지 출력
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); 
		
		if(input % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
	}

	public void ex7() {
	// 연산자(+ - * / %)
	// 정수 1: 5
	// 정수 2: 10
	// 연산자 : *
	// 계산결과 : 5 * 10 =50
	
	Scanner sc = new Scanner(System.in);
	System.out.print("정수 1: "); 
	int num1 = sc.nextInt();
	
	System.out.println("정수 2: ");
	int num2 = sc.nextInt();
	
	System.out.println("연산자: ");
	String op = sc.next();
	
	switch(op) {
	case "+" : System.out.printf("%d + %d = %d\n", 
			num1, num2, num1 + num2);
	break;
	case "/" :
		if(num2 == 0) {
			System.out.println("0으로 못나눔");			
		}else {
			System.out.printf("%d / %d = %d\n",
					num1,num2,num1 / num2);
		}
		break;
	 }
	}	
	
	public void ex3() {

		
		// 달(month)를 입력받아 해당 달에 맞는 계절 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("달 입력: ");
		int month = sc.nextInt();
		
		String result;
		
		// 사용자에게 온도를 받음.
		/*System.out.print("온도 입력: ");
		int temperature = sc.nextInt();
		
		String season;
		
		// 봄: 3,4,5
		// 여름: 6,7,8
		// 가을: 9,10,11
		// 겨울: 12,1,2
		if(month == 3 || month == 4 || month == 5) {
			season ="봄";
		} else if( month >= 6 && month <= 8) {
			season = "여름";
			
			if(temperature >= 35) {
							// 여름 + "폭염 경보"
							// season = "여름" + "폭염 경보"
				season += "폭염 경보";
			}else if(temperature >= 33) {
				season += "폭염 주의보";
			}
		} else if ( month >= 9 && month <= 8) {
			season = "가을";
		} else if( month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else {
			season = "해당하는 계절 없음";			
		}
		
		System.out.println(season);*/
		
		switch(month) {
		case 3 : case 4 :case 5: result = "봄"; break;
		case 6 : case 7 : case 8: result = "여름"; break;
		case 9 : case 10 : case 11 : result = "가을"; break;
		case 12 : case 1 : case 2 : result = "겨울"; break;
		default : result = "해당하는 계절 없음";
		}
		System.out.println(result);
	    }
		
		
		
	
	
	public void ex4() {
		// 나이를 입력 받아
		// 13세 이하면 "어린이 입니다."
		// 13세 초과 19세 이하면 : "청소년 입니다."
		// 19세 초과 시 : "성인 입니다. 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		if (age <= 13) {
			System.out.println("어린이 입니다.");

		}	else if (age > 13 && age <= 19) {
				System.out.println("청소년 입니다.");
		}	else if (age >19) {
				System.out.println("성인입니다.");
		}
		
	}
	
	public void ex5() {
		// 점수(100점 만점)를 입력 받아
		// 90점 이상 : A
		// 80점 이상 90점 미만 : B
		// 70점 이상 80점 미만 : C
		// 60점 이상 70점 미만 : D
		// 60점 미만 : F
		// 0점 미만, 100 초과 : "잘못 입력하셨습니다"
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력: ");
		int score = sc.nextInt();
		
		String result;
		
		if(score < 0 || score > 100) {
			result = "잘못 입력";
		}else if(score >= 90) {
			result = "A";
		}else if(score >= 80) {
			result = "B";
		}else if(score >= 70){
			result = "C";
		}else if(score >= 60){
			result = "D";
		}else {
			result = "F";
		}
						
		System.out.println(result);
		
				
	}
	
	public void ex6() {
		// 놀이기구 탑승 제한 검사 프로그램
		// 조건 - 나이 : 12세 이상
		//     - 키  : 140.0cm 이상
		
		// 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
		// 키를 0~250.0cm 사이로 입력하지 않은 경우 ㅣ "키를 잘못 입력 하셨습니다."
		// -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
		
		// 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
		// 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
		// 나이 X , 키 X : "나이와 키 모두 적절치 않음";
		// 나이 O , 키 O : "탑승 가능"
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		String result; // 결과 담을 변수 선언. 초기화 X
		
		if( age < 0 || age > 100) {
			result = "나이 잘못 입력했어요.";
		} else {
			System.out.print("키 입력: ");
			double height = sc.nextDouble();
			
			if( height < 0 || height > 250) {
				result = "키 잘못 입력";
			}else {
				//키를 잘 입력한 경우
				
				if(age < 12 && height >= 140.0) { // 나이X, 키 O
					result = "키는 적절하나, 나이는 적절치 않음";
				} else if(age >= 12 && height < 140.0) { // 나이O, 키X
					result = "나이는 적절하나, 키는 적절치 않음";
				} else if(age < 12 && height < 140.0) {
					result = "나이와 키 모두 적절치 않음";
				} else {
					result = "탑승 가능";
				}
			}
			
		}
		
		System.out.println(result);
						
	
 }
}