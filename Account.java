package onlineBanking;

public class Account {
	
	private int userId;
	private String password;
	
	public Account() {
		this.userId = 99887766;
		this.password = "abc9876";
	}
	
	public Account(int u, String psw) {
		this.userId = u;
		this.password = psw;
	}
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
