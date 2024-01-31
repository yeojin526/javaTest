package Test1_CLI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {
	Scanner sc = new Scanner(System.in);
	String num = null;
	ResultSet rs = null;

	void selectData(Connection conn, Message ms) {
		do {
			ms.selectMenu();
			String menuNum = sc.nextLine();

			switch (menuNum) {
			case "1": // 전체 조회
				selectOne(conn);
				break;
			case "2": // 선택 조회(사원별 조회)
				selectTwo(conn);
				break;
			}
			ms.coiceMenu(); 
			ms.inputField();
			num = sc.nextLine();
		} while (num.equals("1"));
		ms.returnToMain();
	}

	void selectOne(Connection conn) {
		try {
			Statement st = conn.createStatement();
			String sql = "select * from emp";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				String comm = rs.getString("comm");  //null이 보이게 하려고 String을 씀. (입력이 아니라 조회니까 String으로 써도 무관하다고 판단)
				int deptno = rs.getInt("deptno");

				String str = empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm
						+ "\t" + deptno;

				System.out.println(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void selectTwo(Connection conn) {
		try {
			Statement st = conn.createStatement();
			
			System.out.print("조회할 사원의 사원번호를 입력하세요.: ");
			int empno = sc.nextInt();
			
			String sql = "select * from emp where empno = " + empno;
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
				
				System.out.println(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
