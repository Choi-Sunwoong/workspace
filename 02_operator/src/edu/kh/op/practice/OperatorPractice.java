package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	public void practice1(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο� �� : ");
		int input1 = sc.nextInt();		
		System.out.print("���� ���� : ");
		int input2 = sc.nextInt();
		System.out.println();
				
		System.out.println("1�δ� ���� ���� : "+input2/input1);
		System.out.println("���� ���� ���� : "+input2%input1);
		

	}
	
	public void practice2(){
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("�̸� : ");
		String input1 = sc.next();
		System.out.print("�г� : ");
		int input2 = sc.nextInt();
		System.out.print("�� : ");
		int input3 = sc.nextInt();
		System.out.print("��ȣ : ");
		int input4 = sc.nextInt();
		System.out.print("���� : ");
		String input5 = sc.next();
		System.out.print("���� : ");
		double input6 = sc.nextDouble();
		System.out.println();
		String input7 = input2+"�г� "+input3+"�� "+ input4+"�� "+ input1+" ���л� "+ input5+"�� "+ "������ "+ input6+"�̴�.";
		System.out.println(input7);
			

	}
	
	 public void practice3(){
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("���� : ");
		 int input1 = sc.nextInt();
		 System.out.print("���� : ");
		 int input2 = sc.nextInt();
		 System.out.print("���� : ");
		 int input3 = sc.nextInt();
		 System.out.println();
		 
		 System.out.println("�հ� : "+(input1+input2+input3));
		 System.out.println("��� : "+(input1+input2+input3)/3);
		 
	 }





}
