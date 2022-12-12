package edu.kh.control.condition;

import java.util.Scanner;

public class SwitchExample {
	
	/*
	 * switch문
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문.
	 * -> 식의 결과로 얻은 값과 같은 case 구문이 실행된다.
	 * 
	 * [작성법]
	 * 
	 * switch(식) {
	 * 
	 * 	case 결과값1 : 수행코드1; break;
	 * 	case 결과값2 : 수행코드2; break;
	 * 	case 결과값3 : 수행코드3; break;
	 * 	...
	 * 	default : case를 모두 만족하지 않을 경우 수행하는 코드(==else)
	 * 
	 * }
	 *
	 **/
	
	public void ex1() {
		// 키보드로 점수를 입력 받아
		// 1 이면 "빨강색"
		// 2 이면 "주황색"
		// 3 이면 "노란색"
		// 4 이면 "초록색"
		// 1~4 사이 숫자가 아니면 "흰색" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수입력: ");
		int input = sc.nextInt();
		
		String result;
		
		/*if(input == 1) {
			result = "빨강";
		} else if(input == 2) {
			result = "주황";
		} else if(input == 3) {
			result = "노랑";
		} else if(input == 4) {
			result = "초록";
		} else {
			result = "흰색";
		}
		
		System.out.println(result);*/
		
		switch(input) {
		
		case 1 : result = "빨강";
		case 2 : result = "주황";
		case 3 : result = "노랑";
		case 4 : result = "초록";
		default : result = "흰색";
		}
		
		System.out.println(result);
		}
	}


