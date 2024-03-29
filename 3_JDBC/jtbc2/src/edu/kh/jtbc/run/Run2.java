package edu.kh.jtbc.run;

import edu.kh.jdbc.model.vo.TestVO;
import edu.kh.jtbc.model.service.TestService;

public class Run2 {

	public static void main(String[] args) {
		// TB_TEST 테이블에 한번에 3행 삽입
		TestService service = new TestService();

		TestVO vo1 = new TestVO(70, "제목70", "내용 70입니다");
		TestVO vo2 = new TestVO(80, "제목80", "내용 80입니다");
		TestVO vo3 = new TestVO(90, "제목90", "내용 90입니다");
		
		try {
			int result = service.insert(vo1, vo2, vo3);
			
			if(result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
		} catch(Exception e) {
			// service, dao 수행 중 발생한 예외를 처리
			System.out.println("SQL 수행 중 오류 발생");
			e.printStackTrace();
		}
			
		
	}

}
