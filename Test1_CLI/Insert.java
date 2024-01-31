package Test1_CLI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
	Scanner sc = new Scanner(System.in);
	String num;

	void insertData(Connection conn, Message ms) {
		do {
			ms.insertMenu();
			
			try (Statement st = conn.createStatement();) {
				System.out.print("☞ 사원번호(네자리수): ");
				int empno = Integer.parseInt(sc.nextLine());

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

				String sql = "insert into emp (empno, ename, job, mgr, hiredate ,sal, comm, deptno) values(" + empno
						+ ",'" + ename + "','" + job + "'," + mgr + ",'" + hiredate + "'," + sal + "," + comm + ","
						+ deptno + ")";

				int result = st.executeUpdate(sql);

				if (result == 1) {
					ms.dataSuccess(empno, "추가"); // 입력 정보 확인차 ename 까지 알려주기
				} else {
					ms.dataFail("추가");
					
				}
				ms.coiceMenu();
				ms.inputField();
				num = sc.nextLine();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (num.equals("1"));
		ms.returnToMain();
	}
}
