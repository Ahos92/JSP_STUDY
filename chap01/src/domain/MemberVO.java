package domain;

public class MemberVO {

	private String user_id;
	private String user_password;
	private String user_name;
	private int user_age;
	private String user_salt;
	
	public MemberVO() {
		
	}
	
	public String getUser_salt() {
		return user_salt;
	}

	public void setUser_salt(String user_salt) {
		this.user_salt = user_salt;
	}

	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_password() {
		return user_password;
	}
	
	public void setUser_password(String user_password) {
		this.user_password = user_password; 
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public int getUser_age() {
		return user_age;
	}
	
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	
	
	
}
