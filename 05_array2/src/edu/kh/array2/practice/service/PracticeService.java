package edu.kh.array2.practice.service;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PracticeService {

	public void practice1() {
		//3행 3열짜리 문자열 배열을 선언 및 할당하고 
		//인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 "(0,0)"과 
		// 같은 형식으로 저장 후 출력하세요.
		int[][] arr = new int[3][3];
		
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length;j++) {
				System.out.print("("+i+", "+j+")");
			
			}
			System.out.println();
	
		}
		
	}

	public void practice2() {
		int[][] arr= new int[4][4];
		
		int num = 1;
		
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length;j++) {
				arr[i][j] = num;
				System.out.printf("%3d",arr[i][j]);
				num++;		
			}
			System.out.println();
		
		}
	}		
	public void practice3() {
		int[][] arr= new int[4][4];
			
		int num = 16;
			
			
		for(int i = arr.length-1; i > -1; i--) {
			for(int j = arr.length-1; j > -1;j--) {
				arr[i][j] = num;
				System.out.printf("%3d",arr[i][j]);
				num--;
			}
			System.out.println();
		}	
	}
	
	public void practice4() {
		
		int[][] arr= new int[4][4];
		arr[0][0] = 9;
		arr[0][1] = 3;
		arr[0][2] = 6;
		arr[0][3] = arr[0][0]+arr[0][1]+ arr[0][2];
		arr[1][0] = 3;
		arr[1][1] = 6;
		arr[1][2] = 10;
		arr[1][3] = arr[1][0]+arr[1][1]+ arr[1][2];
		arr[2][0] = 7;
		arr[2][1] = 9;
		arr[2][2] = 10;
		arr[2][3] = arr[2][0]+ arr[2][1] +arr[2][2];
		arr[3][0] = arr[0][0] +arr[0][1] +arr[0][2];
		arr[3][1] = arr[1][0] +arr[1][1] +arr[1][2];
		arr[3][2] = arr[2][0] +arr[2][1] +arr[2][2];
		arr[3][3] = arr[0][3] +arr[1][3] +arr[2][3];
			
		for(int i = 0; i <= arr.length; i++){
			for(int j = 0; j < arr[i].length;j++) {
				int num = 0;
				System.out.printf("%3d",arr[i][j]);
				num++;
			System.out.println();
		
			}	
		}
	}	
	
	public void practice5() {
		
		int[][] arr = new int [sc.nextInt][]
		
		
	}
	public void practice7() {
		
		// 1차원 문자열 배열에 학생 이름 초기화되어 있다.
		// 3행 2열 짜리 2차원 문자열 배열에 순서대로 저장하고 아래와 같이 출력하시오.
		//(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
		
		
		String[][] Students = {{"강건강", "남나나", "도대담", "류라라", "문미미","박보배"},
		{"송성실","윤예의","진재주","차천축","피풍표","홍하하"}};
			
		String[][] Students1 = new String[3][2]; 
		String[][] Students2 = new String[3][2];
		
		Students = Students1;
		Students = Students2;
		
		for(int i = 0; i < Students.length; i++) {
			for(int j = 0; j <Students.length; j++)
			Students[3][2] = Students[i][j] ;
		}
		
		System.out.println(Students);

		
	
		
		
		
		
		
	}

	
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");	
		String input = sc.nextLine();
		System.out.print("열 인덱스 입력 : ");
		String input1 = sc.nextLine();
		
		String[][] arr = new String[input.length()][input1.length()];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++)
			arr[i][j] = input.substring(i);
		}
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		int count = 0;
		
		System.out.print(input + "에 " + ch + "가 존재하는 위치(인덱스) : ");
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ch) {
				System.out.print(i + " ");
			}
		}System.out.println();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ch) {
				count++;
			}
		}System.out.print(ch + " 개수 : " + count);
		}
	}

