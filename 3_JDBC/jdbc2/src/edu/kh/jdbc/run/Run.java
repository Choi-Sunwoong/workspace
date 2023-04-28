package edu.kh.jdbc.run;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run {

	
	// 1. CreateXMLFile
	// 2. driver.xml
	// 3. LoadXMLFile
	// 4. JDBCTemplate4
	// 5. RUN/TestService/TestDAO/TestVO
	
	
	
	public static void main(String[] args) {
		
		TestService service = new TestService();
		
		// TB_TEST 테이블에 INSERT 수행
		// Run에서 원래 다쓰는 거 아니다.
		TestVO vo1 = new TestVO(1, "제목1", "내용1");
		
		// TB_TEST 테이ㅏ블에 insert를 수행하는 서비스 메서드를
		// 호출 후 결과 반환 받기
		
		try {
		
		int result = service.insert(vo1);
		
		if(result > 0) {
			System.out.println("insert 성공");
		}	else {
			System.out.println("insert 실패");
		}
	} catch(Exception e) {
		System.out.println("SQL 수행 중 오류 발생");
		e.printStackTrace();
	}
	}
	
}
