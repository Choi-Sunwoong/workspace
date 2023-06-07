package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	
	public void practice1(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int number = sc.nextInt();
		
		String result;
		
		if (number % 2 == 0 && number > 0) {
			result = "짝수입니다.";
		}else if (number % 1 == 0 && number>0) {
			result = "홀수 입니다.";
		}else {
			result = "양수만 입력해주세요";
		}
		
		System.out.println(result);
	}	
	
	public void practice2(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
			
		System.out.print("수학점수 : ");
		int mat = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		String result;
		
		int sum = kor+eng+mat;
		double avg = (kor+eng+mat)/3; 
		
		if (avg>=60 && kor>=40 && eng>=40 && mat>=40 ) {
			result = "국어 : " + kor + "\n" + "수학 : " + mat  + "\n" 
					+"영어 : " + eng + "\n" + "합계 : " +  sum + "\n"
					+ "평균 : " + avg + "\n" + "축하합니다, 합격입니다" ;
		} else   {
			result = "불합격입니다.";
		}
		
		System.out.println(result);
			

		}
		
	public void practice3(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		String result;
		
		switch(month) {
		
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		System.out.printf(month + "월은 31일까지 있습니다.");
		break;
		
		case 2: case 4: case 6: case 9: case 11:
		System.out.printf(month + "월은 30일까지 있습니다.");
		break;
		
		default:
		result= month+"월은 잘못 입력된 달입니다.";
		
		System.out.println(result);
		}
	}	
	public void practice4(){
		
Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		System.out.print("BMI 지수 : ");
		double BMI = (weight/(height*height));
		
		String result;
		
		if( BMI < 18.5) {
			result  = "저체중";
		}else if( BMI >= 18.5 && BMI < 23) {
			result = "정상체중";
		}else if( BMI >= 23 && BMI < 25) {
			result = "과체중";
		}else if( BMI >= 25 && BMI < 30) {	
			result = "비만";
		}else {
			result = "고도 비만";
		}
		
		System.out.println(BMI);
		System.out.println(result);
	}	
	public void practice5(){
		
Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		double mid = sc.nextDouble();
			
		System.out.print("기말 고사 점수 : ");
		double fina = sc.nextDouble();
		
		System.out.print("과제 점수   : ");
		double work = sc.nextDouble();
		
		System.out.print("출석 횟수  : ");
		int cheack = sc.nextInt();
		
		System.out.println("================= 결과 =================");
		
		double mid20 = mid * 0.2;
		double fina30 = fina * 0.3;
		double work30 = work * 0.3;
		int allcheack = 20;
		double cheack20 = (cheack/0.2)*0.2; 
		
		double all = mid20+fina30+work30+cheack20;
		
		
		if (allcheack/0.3 >= cheack20/0.2 ) {
			System.out.print("Fail");
			System.out.printf("[출석 횟수 부족 (%d/20)]",cheack);
		
		}else if (mid20+fina30+work30+cheack20 > 70) {
			System.out.println("중간 고사 점수(20) : " + mid20);
			System.out.println("기말 고사 점수(30) : " + fina30);
			System.out.println("과제 점수	(30) : " + work30);
			System.out.println("출걱 점수	(20) : " + cheack20);
			System.out.println("총점 : " + all);
			System.out.println("Pass");
			
		}else {
			System.out.println("중간 고사 점수(20) : " + mid20);
			System.out.println("기말 고사 점수(30) : " + fina30);
			System.out.println("과제 점수	(30) : " + work30);
			System.out.println("출걱 점수	(20) : " + cheack20);
			System.out.println("총점 : " + all);
			System.out.println("Fail [점수 미달]");
			
			
			
		
		


		}
	
	}
}
	
	

	
		
	

