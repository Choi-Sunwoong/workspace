package edu.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {
	
	
	public void practice1(){
		
		int[] arr;
		arr = new int[9];
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
		arr[i] = i+1;	
		
		if(i%2 == 0) 
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("짝수 번째 인덱스 합 : "+sum);
		
			
		}
	
	public void practice2(){
		
		int[] arr;
		arr = new int[9];
		int sum = 0;
	
		for(int i = 0; i < arr.length; i++) {
		arr[i] = i+1;
		}
		for(int i = arr.length-1; i >=0; i--) {
	
		if(i%2 == 1) 
			sum += arr[i];
		System.out.print(arr[i]+" ");
		}
		
		System.out.println("\n홀수 번째 인덱스 합 : "+sum);
		
	}
	
	public void practice3(){
		
		Scanner sc = new Scanner(System.in);  
		System.out.print("양의 정수: ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		
		for(int i=1; i <= arr.length; i++) {
			System.out.print(i+" ");
	
		}
	}	
	
/*	public void practice4() {
		
		Scanner sc = new Scanner(System.in);  
		int[] arr = new int[4];
		
		for(int i=0; i <arr.length; i++) {
			System.out.print("입력 " + i + " : ");
			arr[i] = sc.nextInt();
			}
		
		for(int i=0; i <arr.length; i++) {
			
			
			}
		
		System.out.print("검색할 값 : ");
		int arr = sc.nextInt(); 
			
		}
*/
	
	public void practice7(){
		Scanner sc =new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		String[] arr = new String[13];
		
		arr[7] = "*";
		arr[8] = "*";
		arr[9] = "*";
		arr[10] = "*";
		arr[11] = "*";
		arr[12] = "*";
		arr[13] = "*";
		
		System.out.print(arr);
 			
		}
		

		
		
	}
		
	





	