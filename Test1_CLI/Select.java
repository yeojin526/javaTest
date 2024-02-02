package Test1_CLI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select { //4. SELECT 쿼리 (전체 조회 & 사원별 조회)
	Scanner sc = new Scanner(System.in);
	String num;
	ResultSet rs = null;
	void selectData(Connection conn, Message ms) {
			ms.selectMenu(); //조회 메뉴(1~2) 안내 및 선택
			String num = sc.nextLine();
			
			switch (num) {
			case "1": // 전체 조회
				selectOne(conn); 
				break;
			case "2": // 선택 조회(사원별 조회)
				selectTwo(conn); 
				break;
			default:
				 ms.menuFail(); 
				 break;
			}
		
		ms.returnToMain();
	}

	void selectOne(Connection conn) { //1. 전체 조회
		try {
			Statement st = conn.createStatement();
			// 실행할 SQL 쿼리 정의
			String sql = "select * from emp";
			
			// SQL 쿼리 실행 및 결과 반환
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				String comm = rs.getString("comm");  //null이 보이게 하려고 String을 씀. (입력이 아니라 조회니까 String으로 써도 무관하다고 판단함)
				int deptno = rs.getInt("deptno");

				String str = empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm
						+ "\t" + deptno;
				
				//결과 출력
				System.out.println(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void selectTwo(Connection conn) { //2. 선택 조회(사원별 조회)
		try {
			Statement st = conn.createStatement();
			
			// 조회할 사원 정보 입력 받기
			System.out.print("조회할 사원의 사원번호를 입력하세요.: ");
			int empno = sc.nextInt();
			
			// 실행할 SQL 쿼리 정의
			String sql = "select * from emp where empno = " + empno;
			
			// SQL 쿼리 실행 및 결과 반환
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				String comm = rs.getString("comm"); //null이 보이게 하려고 String을 씀. (입력이 아니라 조회니까 String으로 써도 무관하다고 판단)
				int deptno = rs.getInt("deptno");
				
				String str = empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm + "\t" + deptno;
				
				//결과 출력
				System.out.println(str);
				sc.nextLine();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
