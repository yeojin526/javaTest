package Test1_CLI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert { // 1. INSERT 쿼리 (추가)
	Scanner sc = new Scanner(System.in);
	String num;

	void insertData(Connection conn, Message ms) {
		ms.insertMenu(); // 추가 메뉴 안내

		// 입력할 사원 정보 입력 받기
		try (Statement st = conn.createStatement();) {
			System.out.print("☞ 사원번호(네자리수): ");
			String empno = sc.nextLine();

			System.out.print("☞ 사원명: ");
			String ename = sc.nextLine();

			System.out.print("☞ 직업명: ");
			String job = sc.nextLine();

			System.out.print("☞ 관리자번호(네자리수): ");
			int mgr = Integer.parseInt(sc.nextLine());

			System.out.print("☞ 고용날짜(0000-00-00): ");
			String hiredate = sc.nextLine();

			System.out.print("☞ 연봉: ");
			double sal = Double.parseDouble(sc.nextLine());

			System.out.print("☞ 성과금: ");
			double comm = Double.parseDouble(sc.nextLine());

			System.out.print("☞ 부서번호(두자리수): ");
			int deptno = Integer.parseInt(sc.nextLine());

			// 실행할 SQL 쿼리 정의
			String sql = "insert into emp (empno, ename, job, mgr, hiredate ,sal, comm, deptno) values(" + empno + ",'"
					+ ename + "','" + job + "'," + mgr + ",'" + hiredate + "'," + sal + "," + comm + "," + deptno + ")";

			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// ((쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result == 1) {
				ms.dataSuccess(empno, "추가");
			} else {
				ms.dataFail("추가");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ms.returnToMain();
	}
}
