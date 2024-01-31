package Test1_CLI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	Scanner sc = new Scanner(System.in);
	String num;
	ResultSet rs = null;

	void deleteData(Connection conn, Message ms) {
		do {
			try {
				Statement st = conn.createStatement();

				System.out.print("☞ 데이터를 삭제할 사원의 사원번호를 입력하세요.: ");
				int empno = sc.nextInt();

//				String empnoExist //////추가기능 - 조회기능 추가 후에, 해당되는 사원이 없습니다 넣기. (있으면 다음 단계로 넘어가게)
//				int result = st.executeUpdate(empnoExist);

				String sql = "delete from emp where empno = " + empno;

				int result = st.executeUpdate(sql);

				if (result >= 1) {
					ms.dataSuccess(empno, "삭제"); // 입력 정보 확인차 empno 까지 메시지로 알려주기
				} else {
					ms.dataFail("삭제");
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
