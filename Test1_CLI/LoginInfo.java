package Test1_CLI;

public class LoginInfo { //MySQL 데이터베이스에 연결하기 위한 정보들
	private String url = "jdbc:mysql://localhost:3306/firm";
	private String id = "root";
	private String pass = "mysql";

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}