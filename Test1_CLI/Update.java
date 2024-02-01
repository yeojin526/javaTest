package Test1_CLI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update { // 3. UPDATE 쿼리 (변경)
	Message ms = new Message();
	Scanner sc = new Scanner(System.in);
	String num;
	ResultSet rs = null; // 지울까?
	boolean run;

	void updateData(Connection conn) {
		System.out.print("☞ 데이터를 변경할 사원의 사원번호: ");
		String empno = sc.nextLine();

		ms.updateMenu(); // 변경할 메뉴 선택
		num = sc.nextLine();

		switch (num) {
		case "1": // 사원명
			updateEname(conn, empno);
			break;
		case "2": // 직업
			updateJob(conn, empno);
			break;
		case "3": // 관리자번호(네자리수)
			updateMgr(conn, empno);
			break;
		case "4": // 연봉
			updateSal(conn, empno);
			break;
		case "5": // 성과금
			updateComm(conn, empno);
			break;
		case "6": // 부서번호(두자리수)
			updateDeptno(conn, empno);
			break;
		default:
			ms.menuFail();
			break;
		}
		ms.returnToMain();
	}

	void updateEname(Connection conn, String empno) { // 1. 사원명 변경
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 사원명: ");
			String ename = sc.nextLine();

			// 실행할 SQL 쿼리 정의
			String sql = "update emp set ename = '" + ename
					+ "', job = job, mgr = mgr, sal = sal, comm = comm, deptno = deptno where empno = " + empno;

			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// (쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "변경");
				ms.updateMessage(result, ename);
			} else {
				ms.dataFail("변경");
//				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateJob(Connection conn, String empno) { // 2. 직업 변경
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 직업명: ");
			String job = sc.nextLine();

			// 실행할 SQL 쿼리 정의
			String sql = "update emp set ename = ename, job = '" + job
					+ "', mgr = mgr, sal = sal, comm = comm, deptno = deptno where empno = " + empno;

			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// (쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "변경");
				ms.updateMessage(result, job);
			} else {
				ms.dataFail("변경");
//				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateMgr(Connection conn, String empno) { // 3. 관리자번호(네자리수)변경
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 관리자번호(네자리수): ");
			int mgr = Integer.parseInt(sc.nextLine());

			// 실행할 SQL 쿼리 정의
			String sql = "update emp set ename = ename, job = job, mgr = '" + mgr
					+ "', sal = sal, comm = comm, deptno = deptno where empno = " + empno;

			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// (쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기
				String str = String.valueOf(mgr);
				ms.updateMessage(result, str);
			} else {
				ms.dataFail("변경");
//				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateSal(Connection conn, String empno) { // 4. 연봉 변경
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 연봉: ");
			double sal = Double.parseDouble(sc.nextLine());

			// 실행할 SQL 쿼리 정의
			String sql = "update emp set ename = ename, job = job, mgr = mgr, sal = '" + sal
					+ "', comm = comm, deptno = deptno where empno = " + empno;
			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// (쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기
				String str = String.valueOf(sal);
				ms.updateMessage(result, str);
			} else {
				ms.dataFail("변경");
//				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateComm(Connection conn, String empno) { // 5. 성과금 변경
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 성과금: ");
			double comm = Double.parseDouble(sc.nextLine());

			// 실행할 SQL 쿼리 정의
			String sql = "update emp set ename = ename, job = job, mgr = mgr, sal = sal, comm = '" + comm
					+ "', deptno = deptno where empno = " + empno;
			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// (쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "변경");
				String str = String.valueOf(comm);
				ms.updateMessage(result, str);
			} else {
				ms.dataFail("변경");
//				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateDeptno(Connection conn, String empno) { // 6. 부서번호(두자리수) 변경
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 부서번호(두자리수): ");
			int deptno = Integer.parseInt(sc.nextLine());

			// 실행할 SQL 쿼리 정의
			String sql = "update emp set ename = ename, job = job, mgr = mgr, sal = sal, comm = comm, deptno = '"
					+ deptno + "' where ename = " + empno;
			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// (쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "변경");
				String str = String.valueOf(deptno);
				ms.updateMessage(result, str);
			} else {
				ms.dataFail("변경");
//				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}