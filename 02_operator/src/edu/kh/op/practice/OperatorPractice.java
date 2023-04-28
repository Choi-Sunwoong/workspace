package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();		
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		System.out.println();
				
		System.out.println("1인당 사탕 개수 : "+input2/input1);
		System.out.println("남는 사탕 개수 : "+input2%input1);
		

	}
	
	public void practice2(){
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("이름 : ");
		String input1 = sc.next();
		System.out.print("학년 : ");
		int input2 = sc.nextInt();
		System.out.print("반 : ");
		int input3 = sc.nextInt();
		System.out.print("번호 : ");
		int input4 = sc.nextInt();
		System.out.print("성별 : ");
		String input5 = sc.next();
		System.out.print("성적 : ");
		double input6 = sc.nextDouble();
		System.out.println();
		String input7 = input2+"학년 "+input3+"반 "+ input4+"번 "+ input1+" 남학생 "+ input5+"의 "+ "성적은 "+ input6+"이다.";
		System.out.println(input7);
			

	}
	
	 public void practice3(){
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("국어 : ");
		 int input1 = sc.nextInt();
		 System.out.print("영어 : ");
		 int input2 = sc.nextInt();
		 System.out.print("수학 : ");
		 int input3 = sc.nextInt();
		 System.out.println();
		 
		 System.out.println("합계 : "+(input1+input2+input3));
		 System.out.println("평균 : "+(input1+input2+input3)/3);
		 
	 }





}
