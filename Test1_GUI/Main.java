package Test1_GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.login.LoginContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//MySQL의 emp 테이블을 대상으로 GUI 서비스 만들기 (Swing 사용)

public class Main extends JFrame {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	JLabel jl1 = new JLabel("사원번호");
	JTextField tf1 = new JTextField(5);
	JLabel jl2 = new JLabel("사원명");
	JTextField tf2 = new JTextField(5);
	JLabel jl3 = new JLabel("직업명");
	JTextField tf3 = new JTextField(5);
	JLabel jl4 = new JLabel("관리자번호");
	JTextField tf4 = new JTextField(5);
	JLabel jl5 = new JLabel("고용날짜");
	JTextField tf5 = new JTextField(5);
	JLabel jl6 = new JLabel("연봉");
	JTextField tf6 = new JTextField(5);
	JLabel jl7 = new JLabel("성과금");
	JTextField tf7 = new JTextField(5);
	JLabel jl8 = new JLabel("부서번호");
	JTextField tf8 = new JTextField(5);

	JButton b1 = new JButton("전체 내용"); // SELECT 쿼리 (전체 조회)
	JButton b2 = new JButton("입력"); // INSERT 쿼리
	JButton b3 = new JButton("이름 검색"); // SELECT 쿼리 (사원별 조회)
	JButton b4 = new JButton("수정"); // UPDATE 쿼리
	JButton b5 = new JButton("삭제"); // DELETE 쿼리
	JButton b6 = new JButton("메인메뉴로"); //메인메뉴로

	JTextArea ta1 = new JTextArea(20, 80);
	LoginInfo loginfo = new LoginInfo();

	public Main() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(loginfo.getUrl(), loginfo.getId(), loginfo.getPass());
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Container co = this.getContentPane();
		co.setLayout(new BorderLayout());

		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.add(b1);
		jp1.add(b2);
		jp1.add(b3);
		jp1.add(b4);
		jp1.add(b5);
		jp1.add(b6);
		co.add(jp1, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(ta1);
		JPanel jp2 = new JPanel(new FlowLayout());
		jp2.add(scroll);
		co.add(jp2, BorderLayout.CENTER);

		JPanel jp3 = new JPanel(new FlowLayout());
		co.add(jp3, BorderLayout.NORTH);
		jp3.add(jl1);
		jp3.add(tf1);
		jp3.add(jl2);
		jp3.add(tf2);
		jp3.add(jl3);
		jp3.add(tf3);
		jp3.add(jl4);
		jp3.add(tf4);
		jp3.add(jl5);
		jp3.add(tf5);
		jp3.add(jl6);
		jp3.add(tf6);
		jp3.add(jl7);
		jp3.add(tf7);
		jp3.add(jl8);
		jp3.add(tf8);

		mainMenu(); //메인 메뉴

		b1.addActionListener(new ActionListener() { // 전체 내용
			@Override
			public void actionPerformed(ActionEvent e) {
				clearTextField();

				select();
			}
		});

		b2.addActionListener(new ActionListener() { // 입력
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();

				clearTextField();

			}
		});

		b3.addActionListener(new ActionListener() { // 이름 검색

			@Override
			public void actionPerformed(ActionEvent e) {
				nameSearch();

				clearTextField();
			}
		});

		b4.addActionListener(new ActionListener() { // 수정

			@Override
			public void actionPerformed(ActionEvent e) {
				update();

				clearTextField();
			}
		});

		b5.addActionListener(new ActionListener() { // 삭제

			@Override
			public void actionPerformed(ActionEvent e) {
				delete();

				clearTextField();

			}
		});
		
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenu();
				
				clearTextField();
			}
		});

		this.setLocation(500, 400);
		this.setSize(950, 450);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void clearTextField() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tf7.setText("");
		tf8.setText("");
	}

	public void select() { // 전체 조회
		String sql = "select * from emp";
		try {
			rs = st.executeQuery(sql);
			ta1.setText(""); // 그 전에 불러온 내용 지우고 TextArea 빈 공간으로 만듦.
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				Double sal = rs.getDouble("sal");
				Double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");

				String str = String.format("%d, %s, %s, %d, %s, %f, %f, %d\n", empno, ename, job, mgr, hiredate, sal,
						comm, deptno);

				ta1.append(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert() {
		String sql = String.format("insert into emp values(%s, '%s', '%s', %s, '%s', %s, %s, %s)", tf1.getText(),
				tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(),
				tf8.getText());
		try {
			int result = st.executeUpdate(sql);
			ta1.setText("");
			String m = "\n[알림] '" + tf1.getText() + "'번 사원의 데이터가 등록되었습니다.";
			ta1.append(m);
		} catch (SQLException e) {
			String m = "\n [알림] 데이터 등록에 실패하였습니다.";
			e.printStackTrace();
		}
	}

	public void nameSearch() {
		String sql = String.format("select * from emp where empno = %s ", tf1.getText());

		try {
			rs = st.executeQuery(sql);
			ta1.setText(""); // 그 전에 불러온 내용 지우고 TextArea 빈 공간으로 만듦.

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				Double sal = rs.getDouble("sal");
				Double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");

				String str = String.format("%d, %s, %s, %d, %s, %f, %f, %d\n", empno, ename, job, mgr, hiredate, sal,
						comm, deptno);

				ta1.append(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update() {

		// 사원명 변겅
		String sql1 = String.format("update emp set ename = '%s' where empno = %s", tf2.getText(), tf1.getText());

		// 직업 변경
		String sql2 = String.format("update emp set job = '%s' where empno = %s", tf3.getText(), tf1.getText());

		// 관리자번호 변경
		String sql3 = String.format("update emp set mgr = %s where empno = %s", tf4.getText(), tf1.getText());

		// 연봉 변경
		String sql4 = String.format("update emp set sal = %s where empno = %s", tf6.getText(), tf1.getText());

		// 성과금 변경
		String sql5 = String.format("update emp set comm = %s where empno = %s", tf7.getText(), tf1.getText());

		// 부서번호 변경
		String sql6 = String.format("update emp set deptno = %s where empno = %s", tf8.getText(), tf1.getText());

		try {
			int result = st.executeUpdate(sql1);
			int result2 = st.executeUpdate(sql2);
			int result3 = st.executeUpdate(sql3);
			int result4 = st.executeUpdate(sql4);
			int result5 = st.executeUpdate(sql5);
			int result6 = st.executeUpdate(sql6);

			if ((result | result2 | result3 | result4 | result5 | result6) >= 1) {
				String m = "\n[알림] '" + tf1.getText() + "'번 사원의 데이터가 변경되었습니다.";
				ta1.append(m);
			} else {
				String m = "\n [알림] 데이터 변경에 실패하였습니다.";
				ta1.append(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {

		String sql = String.format("delete from emp where empno = %s", tf1.getText());

		int result;
		try {
			result = st.executeUpdate(sql);
			ta1.setText("");
			if (result >= 1) {
				String m = "\n[알림] '" + tf1.getText() + "'번 사원의 데이터가 삭제되었습니다.";
				ta1.append(m);

			} else {
				String m = "\n [알림] 데이터 삭제에 실패하였습니다.";
				ta1.append(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mainMenu() {
		ta1.setText("");
		String m = "[메인 메뉴]\n"+"\n ▷ [ 수정 ] \n 1. 수정을 원하는 사원의 '사원번호'를 입력 \n 2. 변경할 항목들에 대해 '전부' 입력 후 클릭 (단, 사원번호와 입사일은 변경 불가)" + "\n"
				+ "\n ▷ [ 이름 검색 ], [ 삭제 ] \n 1. 전체 내용을 눌러 사원정보를 조회 \n 2. (검색 또는 삭제할)사원의 '사원번호'를 입력 후 클릭";
		ta1.append(m);
	}

	public static void main(String[] args) {
		new Main();

	}

}
