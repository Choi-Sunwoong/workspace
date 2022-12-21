package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {
	
	private Product[] pro = new Product[10];
	
	public int count;
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		int menuNum = 0;
		
		
		do {
			System.out.println("===== 제품 관리 메뉴 ===== ");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("＊ 프로그램 종료");
			
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1:System.out.println(productInput()); break;
			case 2: break;
			case 3: break;
			case 4:
			
			
			
			}
		}while(menuNum != 0);

	}
	public String productInput() {
		System.out.println(" 제품 정보 추가");
		
		System.out.print("제품 번호: ");
		int pld = sc.nextInt();
		
		System.out.print("제품명: ");
		String pName = sc.next();
		
		System.out.print("제품 가격: ");
		int price = sc.nextInt();
		
		System.out.print("제품 세금: ");
		double tax = sc.nextDouble();
		
		pro[count] = new Product(pld, pName, price, tax);
		
		return;
		
		
		
	}
	
	public int emptyIndex() {
		// memberArr배열을 0번 인덱스부터 끝까지 접근해서
		// 참조하는 값이 null인 경우의 인덱스를 반환
		for(int i = 0; i < pro.length; i++) {
			if(pro[i] == null) {
				return i;
			}
		}
		// for문을 수행했지만 return이 되지 앟은 경우 해당 위치 코드가 수행!
		
		return -1;
	}
	
 
}