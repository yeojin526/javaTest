package Test1_CLI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try {
			LoginInfo loginfo = new LoginInfo();
			Insert insert = new Insert();
			Delete delete = new Delete();
			Update update = new Update();
			Select select = new Select();
			Message ms = new Message();
			
			Scanner sc = new Scanner(System.in);
			
			Connection conn = DriverManager.getConnection(loginfo.getUrl(), loginfo.getId(), loginfo.getPass());
			Statement st = conn.createStatement();
			boolean exit = false;

			while (!exit) {
				ms.mainMenu();
				String menuNum = sc.nextLine();

				switch (menuNum) {
				case "1": // INSERT 쿼리 (추가)
					insert.insertData(conn, ms);
					break;
				case "2": // DELETE 쿼리 (삭제)
					delete.deleteData(conn, ms);
					break;
				case "3": // UPDATE 쿼리 (변경)
					update.updateData(conn); 
					break;
				case "4": // SELECT 쿼리 (전체 조회 & 사원별 조회)
					select.selectData(conn, ms);
					break;
				case "5": // 프로그램 종료
					System.out.println("\n" + "[알림]프로그램을 종료합니다... .");
					exit = true;
					break;
				default:
					ms.menuFail();
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
