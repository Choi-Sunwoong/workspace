package edu.kh.emp.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.emp.model.vo.Employee;

// DAO(Data Access Object, 데이터 접근 객체)
// -> 데이터베이스에 접근(연결)하는 객체
// --> JDBC 코드 작성
public class EmployeeDAO {
	
	// JDBC 객체 참조 변수 필드 선언 (class 내부에 공통 사용)
	
	
	private Connection conn; // 필드(Heep, 변수가 비어있을 수 없
	private Statement stmt;	// -> JVM이 지정한 기본값으로 초기화
	private ResultSet rs = null;	// -> 참조형의 초기값은 null
									// 별도 초기화 안해도 된다!
	
	private PreparedStatement pstmt;
	// Statement의 자식으로 향상된 기능 제공
	// -> ? 기호 (placeholder / 위치홀더)를 이용해서
	// SQL에 작성되어지는 리터럴을 동적으로 제어함
	
	// SQL ? 기호에 추가되는 값은
	// 숫자인 경우 '' 없이 대입
	// 문자열인 경우 '' 가 자동으로 추가되어 대입
	
	/*
	public void method() {
		Connection conn2; // 지역변수(Stack, 변수가 비어있을 수 있음)
	}
	*/
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "kh";
	private String pw = "kh1234";

	/** 전체 사원 정보 조회 DAO
	 * @return empList
	 */
	// alt+shift+j
	public List<Employee> selectAll() {
		// 1. 결과 저장용 변수 선언
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. JDBC 참조 변수에 객체 대입
			// -> conn. stmt, rs에 객체 대입
			Class.forName(driver); // 오라클 jdbc 드라이버 객체 메모리 로드
			
			conn = DriverManager.getConnection(url, user, pw);
			// 오라클 jdbc 드라이버 객체를 이용하여 DB 접속 방법 생성
			
			String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE,\r\n"
					+ "NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,\r\n"
					+ "JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)";
			

			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL을 수행 후 결과(ResultSet) 반환 받음
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과를 얻어와 한 행씩 접근하여
			// Employee 객체 생성 후 컬럼값 옮겨 담기
			// -> List 추가
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				// EMP_ID 컬럼은 문자열 컬럼이지만
				// 저장된 값들이 모두 숫자형태
				// -> DB에서 자동으로 형변환 진행해서 얻어옴
				
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				Employee emp = new Employee(empId, empName, empNo, email, 
						phone, departmentTitle
						,jobName, salary);
				
				empList.add(emp); // List 담기
				
			} // while 종료
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			// 4. JDBC 객체 자원 반환
			try {
				if(rs != null) rs.close();
 				if(stmt != null) stmt.close();
 				if(conn != null) conn.close();

			}catch(SQLException e) {
				e.printStackTrace();
			}
					
		}
		
		// 5. 결과 반환
		return empList;
	}

	
	
	/** 주민등록번호가 일치하는 사원 정보 조회 DAO
	 * @param empNo
	 * @return emp
	 */
	public Employee selectEmpNo(String empNo) {
	
		// 결과 저장용 변수 선언
		Employee emp = null;
		
		try {
			// Connection 생성
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE,\r\n"
					+ "NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,\r\n"
					+ "JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE EMP_NO = ?";
									// placeholder
			
			// Statement 객체 사용 시 순서
			// SQL작성 -> Statement 생성 -> SQL 수행 후 결과 반환
			
			// PreparedStatement 객체 사용 시 순서
			// SQL작성
			// -> PreparedStatement 객체 생성( ? 가 포함된 SQL을 매개변수로 사용)
			// -> ? 에 알맞은 값 대입
			// -> SQL 수행 후 결과 반환
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// ? 에 알맞은 값 대입
			pstmt.setString(1, empNo);
			
			// SQL 수행 후 결과 반환
			rs = pstmt.executeQuery();
			// PreparedStatment는 
			// 객체 생성 시 이미 SQL이 담겨져 있는 상태이므로
			// SQL 수행(executeQuery()) 시 매개변수로 전달할 필요가 없다!
			
			// pstmt.executeQuery(sql);
			// -> ? 에 작성되어있던 값이 모두 사라져 수행 시 오류발생
			
			if(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				//String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				emp = new Employee(empId, empName, empNo, email, 
						phone, departmentTitle
						,jobName, salary);
				
			
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
	
	/**
	 * @param emp
	 * @return result(INSERT 성공한 행의 개수 반환)
	 */
	public int insertEmployee(Employee emp) {
		
		// 결과 저장용 변수 선언
		int result = 0;
		
		try {
			
			// 커넥션 생성
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
			
			// ** DML 수행할 예정 **
			// 트랜잭션에 DML 구문이 임시 저장
			// --> 정상적인 DML인지를 판별해서 개발자가 직접 commit, rollback을 수행
			
			// Connection 객체 생성 시
			// AutoCommit이 활성화 되어 있는 상태이기 때문에
			// 이를 해제하는 코드를 추가!
			conn.setAutoCommit(false); // AutoCommit 비활성화
			
			// AutoCommit 비활성화 해도
			// conn.close(); 구문이 수행되면 자동으로 Commit이 수행됨
			// --> close() 수행 전에 트랜잭션 제어 코드를 작성해야 한다!
			
			// SQL 작성
			String sql
				= "INSERT INTO EMPLOYEE VELUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, DEFAULT)";
			// 퇴사 여부 컬럼의 DEFAULT == 'N'
			
			// PreparedStatement 객체 생성(매개변수에 SQL 추가)
			pstmt = conn.prepareStatement(sql);
			
			// ?(placeholder)에 알맞은 값 대입
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDeptCode());
			pstmt.setString(7, emp.getJobCode());
			pstmt.setString(8, emp.getSalLevel());
			pstmt.setInt(9, emp.getSalary());
			pstmt.setDouble(10, emp.getBonus());
			pstmt.setInt(11, emp.getManagerId());
			
			
			// SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate();
			// executeQuery() : SELECT 수행 후 ResultSet반환
			// executeUpdate() : DML(INSERT, UPDATE, DELETE) 수행 후 결과 행 개수 반환
			
			
			
			
			// *** 트랜잭션 제어 처리***
			// -> DML 성공 여부에 따라서 commit, rollback 제어
			
			if(result > 0) conn.commit(); // DML 성공 시 commit
			else		 conn.rollback(); // DML 실패 시 rollback
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	public int updateEmployee(Employee emp) {
	int result = 0;
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pw);
		conn.setAutoCommit(false); // AutoCommit 비활성화
		
		String sql = "UPDATE EMPLOYEE SET"
				+ "EMAIL = ?, PHONE = ?, SALARY = ? "
				+ "WHERE EMP_ID = ?";
		
		// PreparedStatement 생성
		pstmt = conn.prepareStatement(sql);
		
		// ?에 알맞은 값 세팅
		pstmt.setString(1, emp.getEmail());
		pstmt.setString(2, emp.getPhone());
		pstmt.setInt(3, emp.getSalary());
		pstmt.setInt(4, emp.getEmpId());
		
		// 트랜잭션 제어 처리
		if(result == 0) conn.rollback();
		else			conn.commit();
		
	} catch(Exception e) {
		
	} finally {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		
		} catch(Exception e) {
			e.printStackTrace();
			}
		}
	
		return result;
	}

	
	public int deleteEmployee(int empId) {
		
		int result = 0; // 결과 저장용 변수
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false); // AutoCommit 비활성화
			
			String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
			
			// PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empId);
			
			result = pstmt.executeUpdate();
			// 트랜잭션 제어 처리
			if(result == 0) conn.rollback();
			else			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}


/** 입력 받은 부서와 일치하는 모든 사원 정보 조회 DAO
 * @param departmentTitle
 * @return
 */
	public List<Employee> selectDeptEmp(String departmentTitle) {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			// JDBC 드라이버 메모리 로드
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false); 
			
			String sql ="SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE,\r\n"
					+ "NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,\r\n"
					+ "JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE DEPT_TITLE = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, departmentTitle);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				//String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				Employee emp = new Employee(empId, empName, empNo, email, 
						phone, departmentTitle
						,jobName, salary);
				
				empList.add(emp); // List에 담기
				
				// 반환
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
				
		return empList;
	}
	

	/** 사번이 일치하는 사원 정보 조회 DAO
	 * @param empId
	 * @return emp
 	 */
	public Employee selectEmpId(int empId) {
		
		// 결과 저장용 변수 선언
		
	
		Employee emp = null;
		// 만약 조회 결과가 있으면 Employee 객체를 생성해서 emp에 대입(null이 아님)
		// 만약 조회 결과가 없으면 emp에 아무것도 대입하지 않음 (null)
		
		try {
			
			// 오라클 JDBC 드라이버 메모리 로드
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw); // 커넥션 생성해서 얻어오기
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE,\r\n"
					+ "NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,\r\n"
					+ "JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE EMP_ID = " + empId;
										// View에서 입력받은 사번
		
			// Statement 생성
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// ** 조회 결과가 최대 1행인 경우
			//	  불필요한 조건 검사를 줄이기 위해서 if문 사용 권장 **
		
			
			if(rs.next()) { // 조회결과가 있을 경우
				// empId -> 파라미터와 같은 값이므로 불필요
				//int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				emp = new Employee(empId, empName, empNo, email, 
						phone, departmentTitle
						,jobName, salary);
				
			
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				// 객체 생성 역순으로 닫기!(권장)
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
	
	/** 입력 받은 급여 이상을 받는 모든 사원 정보 조회 DAO
	 * @param salary
	 * @return
	 */
	public List<Employee> selectSalaryEmp(int salary) {
		
		// 결과 저장용 변수
		List<Employee> empList = new ArrayList<>();
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE,\r\n"
					+ "NVL(DEPT_TITLE, '부서없음') DEPT_TITLE,\r\n"
					+ "JOB_NAME, SALARY\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE SALARY >= ?";
		
			
			pstmt = conn.prepareStatement(sql);
			
			// ? 에 알맞은 값 대입
			pstmt.setInt(1, salary);
			
			// SQL 수행 후 결과 반환
			rs = pstmt.executeQuery();
		
			
			while(rs.next()) { // 한개 이상일 때는 while문
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String departmentTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				//int salary = rs.getInt("SALARY");
				
				Employee emp = new Employee(empId, empName, empNo, email, 
						phone, departmentTitle
						,jobName, salary);
				
				empList.add(emp);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return empList;
	}
	


	public Map<String, Integer> selectDeptTotalSalary() {
		
		//Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map = new LinkedHashMap<>();
		// LinkedHashMap : key 순서가 유지되는 HashMap
		// -> (ORDER BY절 정렬 결과를 그대로 저장 가능)
		
		try {
			// JDBC 드라이버 메모리 로드
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		
			String sql = "SELECT NVL (DEPT_CODE, '부서없음') DEPT_CODE, SUM(SALARY) TOTAL\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)\r\n"
					+ "GROUP BY DEPT_CODE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptCode = rs.getString("DEPT_CODE");
				int total = rs.getInt("TOTAL");
				
				map.put(deptCode, total);
				
			}	
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
				
		return map;
	}


	/** 직급별 급여 평균 조회 DAO
	 * @return map
	 */
	public Map<String, Double> selectJobAvgSalary() {
		
		Map<String, Double> map = new LinkedHashMap<>();
		
		try { 
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "SELECT JOB_NAME, ROUND(AVG(SALARY), 1) AVERAGE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "GROUP BY JOB_NAME, JOB_CODE \r\n"
					+ "ORDER BY JOB_CODE";
			
			// GROUP BY절에 JOB_CODE를 포함시켜
			// ORDER BY절 정렬 컬럼으로 사용 가능하게 만든다!
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				String jobName = rs.getString("JOB_NAME");
				double average = rs.getDouble("AVERAGE");
				
				map.put(jobName, average);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return map;
		
	}

}






