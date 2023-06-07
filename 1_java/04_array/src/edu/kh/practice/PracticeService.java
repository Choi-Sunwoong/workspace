package edu.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
	public void practice4() {
		
	Scanner sc = new Scanner(System.in);  
	int[] arr = new int[4];
		
	for(int i=0; i <arr.length; i++) {
		System.out.printf("입력 %d : ",i);
		arr[i] = sc.nextInt();
		}
	
	System.out.print("검색할 값 : ");
	int search = sc.nextInt();
	
	boolean flag = true;
	for(int i=0; i <arr.length; i++) {
		if(arr[i] ==search) {
			System.out.println("인덱스 : " + i);
			flag = false;
			break;
		}
	}
		
	if(flag)System.out.println("일치하는 값이 존재하지 않습니다.");
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int count = 0;
		
		System.out.print(str + "에" + ch + "가 존재하는 위치(인덱스) : ");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == ch) {
				System.out.print(i + " ");
				
				count++;
			}
		}
		
		System.out.println(); 
		
		System.out.println(ch + "개수: " + count);
		
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 :");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print("배열" + i + "번째 인덱스에 넣을 값 :");
			arr[i] = sc.nextInt();
		}
		int sum =0;
		for (int i = 0; i <arr.length;i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		
		System.out.println();
		System.out.println("총합 :" +sum);
		
	}
	
	public void practice7(){
		Scanner sc =new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		char[] arr = new char[input.length()];
		
		for (int i =0; i < arr.length; i++) {
			
			if(i<=7 ) {
				arr[i] = input.charAt(i);
			}else {
				arr[i] = '*';
			}
		System.out.print(arr[i]);
 			
		}
	}
	
	public void practice8() {
		Scanner sc=new Scanner(System.in);
		
		while (true) {
			
			System.out.print("정수 :");
			int input = sc.nextInt();
			
			if (input < 3 || input % 2 == 0) {
				System.out.print("다시 입력하세요.");
			
			}else {
				
				int[]arr = new int[input];
				
				int num = 0;
				
				for (int i = 0;i < arr.length; i++) {
					if(i <= arr.length/2) {
						arr[i] = ++num;
					
					}else {
						arr[i] = --num;
					}
					
					if (i==arr.length - 1) {
						System.out.print(arr[i]);
					
					}else {
						System.out.print(arr[i] + ",");
					}
				}
				break;
			}
		}
	}
	
	public void practice9() {
		
		int arr[] = new int[10];
		
		
		System.out.print("발생한 난수:");	
		
		for(int i = 0; i < arr.length; i++ ){
			int random =(int)(Math.random() * 10+1);
			
			arr[i] = random;
			
			System.out.print(arr[i]+" ");
			
			
		}	
		
	
		
	
	}
	
	public void practice10() {
		
		int arr[] = new int[10];
		
		System.out.print("발생한 난수:");
		
		for(int i =0; i < arr.length; i++){
			int random = (int)(Math.random() * 10+1);
			
			arr[i] = random;
			
			System.out.print(arr[i]+" ");
		}
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0; i<arr.length; i++) {
			
			if(arr[i] > max) { 
				max = arr[i];
			}
			else if(arr[i] < min) { 
				min = arr[i];
				
			}
		}
		System.out.println();
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		
	}
	
	public void practice11(){
		
	int arr[] = new int[10];
		
		for(int i =0; i < arr.length; i++){
			int random = (int)(Math.random() * 10+1);
			
			arr[i] = random;
				
			for(int j =0; j < i; j++) {
			if(random == arr[j]) {
				
				i--;
				
				break;
				
				}
			}		
		}	
		
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12(){
		int Lotto[] = new int[10];
		
			for(int i = 0; i < Lotto.length; i++){
				int random = (int)(Math.random() * 6+1);
				
				Lotto[i] = random;
				
				for(int x = 0; i < x; x++) {
					if(random == Lotto[x]) {		
						
						i--;
						
						break;
					}
					
					
 				}
				
			}
			Arrays.sort(Lotto);
			System.out.println(Arrays.toString(Lotto));
			
	}
	
	public void practice13() {
		
		Scanner sc=new Scanner(System.in);

		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
	
		}
		
		int count = 0;
		
		System.out.print("문자열에 있는 문자 : ");
		
		for(int i=0; i<arr.length; i++) {
			
			boolean flag =true; // 중복 체크용 flag
			
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					flag =false;
					break;
				}
			}
			if(flag) {
				
				if(i ==0) {
					System.out.print(arr[i]);
				}else {
					System.out.print(", "+arr[i]);
				}
				
				count++;
			}
		}
		
		System.out.println();
		System.out.println("문자 개수 : " + count);


	}

}	