package Test1_CLI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	Message ms = new Message();
	Scanner sc = new Scanner(System.in);
	String num;
	ResultSet rs = null; // 지울까?
	
	void updateData(Connection conn) {
		do {
			System.out.print("☞ 데이터를 변경할 사원의 사원번호: "); 
			int empno = sc.nextInt();
			
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
				updateDeptno (conn, empno); 
				break;
			default:
				ms.menuFail(); 
				break;
			}
			ms.coiceMenu();
			ms.inputField();
			num = sc.nextLine();

		} while (num.equals("1"));
		ms.returnToMain();
	}

	void updateEname(Connection conn, int empno) {
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 사원명: ");
			String ename = sc.nextLine();

			String sql = "update emp set ename = '" + ename
					+ "', job = job, mgr = mgr, sal = sal, comm = comm, deptno = deptno where empno = "+ empno;
			int result = st.executeUpdate(sql);

			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 메시지로 알려주기
				ms.updateMessage(result, ename);
			} else {
				ms.dataFail("변경");
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updateJob(Connection conn, int empno) {
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 직업명: ");
			String job = sc.nextLine();

			String sql = "update emp set ename = ename, job = '" + job + "', mgr = mgr, sal = sal, comm = comm, deptno = deptno where empno = " + empno;
			int result = st.executeUpdate(sql);

			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기
				ms.updateMessage(result, job); 
			} else {
				ms.dataFail("변경");
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updateMgr(Connection conn, int empno) {
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 관리자번호(네자리수): ");
			int mgr = Integer.parseInt(sc.nextLine());

			String sql = "update emp set ename = ename, job = job, mgr = '" + mgr + "', sal = sal, comm = comm, deptno = deptno where empno = " + empno;
			int result = st.executeUpdate(sql);

			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기
				String str = String.valueOf(mgr);
				ms.updateMessage(result, str); 
			} else {
				ms.dataFail("변경");
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updateSal(Connection conn, int empno) {
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 연봉: ");
			double sal = Double.parseDouble(sc.nextLine()); 

			String sql = "update emp set ename = ename, job = job, mgr = mgr, sal = '" + sal + "', comm = comm, deptno = deptno where empno = " + empno;
			int result = st.executeUpdate(sql);

			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기 
				String str = String.valueOf(sal); 
				ms.updateMessage(result, str);  
			} else {
				ms.dataFail("변경");
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updateComm(Connection conn, int empno) {
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 성과금: ");
			double comm = Double.parseDouble(sc.nextLine());

			String sql = "update emp set ename = ename, job = job, mgr = mgr, sal = sal, comm = '" + comm + "', deptno = deptno where empno = " + empno;
			int result = st.executeUpdate(sql);

			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기
				String str = String.valueOf(comm);
				ms.updateMessage(result, str); 
			} else {
				ms.dataFail("변경");
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updateDeptno (Connection conn, int empno) {
		try {
			Statement st = conn.createStatement();

			System.out.print("☞ 새로 변경된 부서번호(두자리수): ");
			int deptno = Integer.parseInt(sc.nextLine()); 

			String sql = "update emp set ename = ename, job = job, mgr = mgr, sal = sal, comm = comm, deptno = '" + deptno + "' where ename = " + empno;
			int result = st.executeUpdate(sql); 

			if (result >= 1) {
				ms.dataSuccess(empno, "변경"); // 입력 정보 확인차 empno 까지 알려주기  
				String str = String.valueOf(deptno);
				ms.updateMessage(result, str);
			} else {
				ms.dataFail("변경");
				System.out.println(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}