package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.main.model.service.BoardService;

public class BoardView {
	private Scanner sc = new Scanner(System.in);
	
	private BoardService bService = new BoardService();

	public void boardMenu() {
		int input = -1;
			
			do {
				
				try {
							
						System.out.println("\n****** 게시판 기능 *******\n");
						System.out.println("1. 게시글 목록 조회");
						System.out.println("2. 게시글 상세 조회(+ 댓글 기능)");
						System.out.println("3. 게시글 작성");
						System.out.println("4. 게시글 검색");						
						System.out.println("0. 로그인 메뉴로 이동");
						
						System.out.print("\n메뉴 선택 : ");				
						input = sc.nextInt();
						sc.nextLine(); // 입력버퍼 개행문자 제거
						System.out.println();
						
						switch(input) {
						
						case 1: selectAllBoard(); break; // 로그인
						case 2: selectBoard(); break; // 회원가입
						case 3: insertBoard(); break;
						
						case 4:  searchBoard(); break;
						
						case 0 :System.out.println("[로그인 메뉴로 이동합니다.]"); break;
						default: System.out.println("메뉴에 작성된 번호만 입력 해주세요.");
					
						}
						
					
						System.out.println();
					
					
				} catch (InputMismatchException e) {
					System.out.println("\n <<입력 형식이 올바르지 않습니다.>>");
					sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 문자열 제거
				}
				
			}while ( input != 0 );
			
		
	}

	/**
	 * 게시글 목록 조회 
	 */
	private void searchBoard() {
		System.out.println("\n[게시글 목록 조회]\n");
		
		try {
			
			List<Board> boardList = bService.selectAllBoard();
			
			if(boardList.isEmpty()) { // 조회 결과가 없을 경우
				System.out.println("게시글이 존재하지 않습니다.");
				
			} else {
				for(Board b : boardList) {
					
					b.getBoardContent();
					b.getBoardNo();
					b.getBoardTitle();
					b.getCommentCount();
					b.getMemberNo();
					b.getMemberName();
					b.getCreateDate();
					b.getReadCount();
				}
				
			}
			
		} catch(Exception e) {
			System.out.println("\n<<게시글 목록 조회 중 예외 발생>>");
			e.printStackTrace();
		}
		
	}

	/**
	 * 게시글 검색 
	 */
	private void insertBoard() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 게시글 등록(삽입) 
	 */
	private void selectBoard() {
		System.out.println("\n[게시글 등록]\n");
		
		System.out.print("제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.println("내용 : ");
		String boardContent = inputContent();
		
		// Board 객체에 제목, 내용, 회원 번호를 담아서 서비스에 전달 
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberNo(LoginMember.getMemberNo());
		
		int result = bService.insertBoard(board);
		
	}

	/** 내용 입력
	 * @return
	 */
	private String inputContent() {
		String content = ""; // 빈 문자열
		String input = null; // 참조하는 객체가 없음
		
		System.out.println("입력 종료 시 ($exit) 입력");
		
		while(true) {
			input = sc.nextLine();
			
			if(input.equals("$exit")) {
				break;
			}
			
			// 입력된 내용을 content에 누적
			content += input + "\n";
		}
		
		return content;
	}

	/**
	 * 게시글 상세 조회 
	 */
	private void selectAllBoard() {
		// TODO Auto-generated method stub
		
	}
}
