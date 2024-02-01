package Test1_CLI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete { // 2. DELETE 쿼리 (삭제)
	Scanner sc = new Scanner(System.in);
	String num;
	ResultSet rs = null;

	void deleteData(Connection conn, Message ms) {
		try {
			Statement st = conn.createStatement();

			// 삭제할 사원 정보 입력 받기
			System.out.print("☞ 데이터를 삭제할 사원의 사원번호를 입력하세요.: ");
			String empno = sc.nextLine();

			// 실행할 SQL 쿼리 정의
			String sql = "delete from emp where empno = " + empno;

			// SQL 쿼리 실행 및 결과 반환 (SQL 쿼리 실행, 영향을 받은 행의 수 반환)
			int result = st.executeUpdate(sql);

			// ((쿼리 실행 결과에 따른)입력 성공&실패 메세지
			if (result >= 1) {
				ms.dataSuccess(empno, "삭제");
			} else {
				ms.dataFail("삭제");
			}

		} catch (SQLException e) {
			e.printStackTrace();

			ms.returnToMain();

		}
	}
}
