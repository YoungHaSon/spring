package kr.or.ddit.ioc.placeholder;

public class DbInfo {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	//생성자 주입?
	public DbInfo(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		
	}

	//가져와서 비교할 꺼라 getter만?
	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
