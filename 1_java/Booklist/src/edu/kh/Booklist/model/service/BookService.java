package edu.kh.Booklist.model.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.Booklist.model.vo.Book;




public class BookService {
	
	private Scanner sc = new Scanner(System.in);
	
	List<Book> bookList = new ArrayList<Book>();
	List<Book> favoritesList = new ArrayList<Book>();
	
	public void displayMenu() {
		int menuNum = 0;
		
		do {
			System.out.println("\n==============도서 목록 프로그랠=================\n");
			System.out.println("1. 도서 정보 등록");
			System.out.println("2. 도서 정보 조회");
			System.out.println("3. 도서 정보 수정");
			System.out.println("4. 도서 정보 삭제");
			System.out.println("5. 즐겨찾기 추가");
			System.out.println("6. 즐겨찾기 취소");
		
			
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n 메뉴 번호 선택 >>");
			
			try {
				menuNum = sc.nextInt();
				System.out.println(); // 줄바꿈용도
				switch(menuNum) {
				case 1: System.out.println( addBook());break;
				case 2: selectAll(); break;
				case 3: updateBook();break;
				case 4: System.out.println(removeBook());break;
				case 5: System.out.println(addfavorites());break;
				case 6:	removefavorites(); break;
				case 0: System.out.println("프로그램 종료");break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요!");
				}
				
				
			} catch(InputMismatchException e) {
				
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시도해주세요!");
				sc.nextLine(); 
				menuNum = -1; 
							
			}
			
		}while(menuNum != 0);
		
	}
	
	public String addBook() throws InputMismatchException {
		System.out.println("=======도서 정보 등록=======");
		
		System.out.print("도서명 : ");
		String bookname = sc.next();
		
		System.out.print("도서등록번호 : ");
		int bookNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.print("작가 : ");
		String author = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("출판사: ");
		String publisher = sc.next();
		
		
		if( bookList.add(new Book(bookname,bookNumber,author,price,publisher))) {
			return "성공";
		
		}else {
			return "실패";
		
		}			
	}
	
	public void selectAll() {
		
		System.out.println("========도서 목록========");
		
		if(bookList.isEmpty()) {
			System.out.println("도서 정보가 없습니다.");
		
			return;
		}
		
		for( Book std : bookList) {
			System.out.println(std);
		
		}	
	}
	
	public String updateBook() {
		
		System.out.println("=====도서 정보 수정======");
		
		 System.out.print("인덱스 번호 입력: ");
		 int index = sc.nextInt();
		 sc.nextLine();
		 
		
		 if( bookList.isEmpty()) {
			 return "입력된 도서 정보가 없습니다.";
		
		
		} else if( index < 0) {
			return "음수는 입력할 수 없습니다.";
		 
		
		} else if( index >= bookList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		
		}else {
			
			System.out.println(index + "번쩨 인덱스에 저장된 도서 정보");
			System.out.println(bookList.get(index));
			
			System.out.print("도서명 : ");
			String bookname = sc.next();
			
			System.out.print("도서등록번호 : ");
			int bookNumber = sc.nextInt();
			sc.nextLine();
			
			System.out.print("작가 : ");
			String author = sc.nextLine();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			
			System.out.print("출판사: ");
			String publisher = sc.next();
			
			Book temp = bookList.set(index, new Book(bookname,bookNumber,author,price,publisher));
			
			return temp.getBookname() + "의 정보가 변경되었습니다.";
		}
	}
	
	public String removeBook() {
			

		System.out.println("===== 도서 정보 제거 ======");
		
		System.out.print("삭제할 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		
		if( bookList.isEmpty()) {
			return "입력된 도서 정보가 없습니다.";
		
		 
		
		} else if( index < 0) {
			return "음수는 입력할 수 없습니다.";
		 
		
		} else {
			
			
			
			System.out.println("정말 삭제 하겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
					
			
			if(ch == 'Y') {
				Book temp = bookList.remove(index);
				return temp.getBookname() + "의 정보가 제거되었습니다.";
				
			} else {
				return "취소";
			}
		}
		
	
	}
	
	public String addfavorites() {
		
	
		System.out.println("===== 즐겨찾기 추가 ======");
		
		System.out.print("즐겨찾기 도서 입력: ");
		String bookname = sc.next();
		
		boolean flag = false;
		

		for( Book std : bookList ) {
			
			if( bookname.equals(std.getBookname())) { 
				System.out.println(std);
				flag = false;
			}
		}
		
		String filePath = "favorites.txt";
		BufferedWriter writer =null;
		
		try {
			File file = new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
		
			writer = new BufferedWriter(new FileWriter(file));
		
			for(Book temp : bookList) {
				writer.write(temp.favorites());
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "등록";
		

	

	}
	
	public String removefavorites() {
		
		String delete = " ";

		System.out.println("===== 즐겨찾기 취소 ======");
		
		System.out.print("취소할 도서 입력 : ");
		String bookname = sc.next();
		
		
		boolean flag = false;
		

		String filePath = "favorites.txt";
		BufferedWriter writer =null;
		
		try {
			File file = new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
		
			writer = new BufferedWriter(new FileWriter(file));
		
			for(Book temp : bookList) {
				writer.write(delete);
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "취소";
		

	

	}
	
	
}