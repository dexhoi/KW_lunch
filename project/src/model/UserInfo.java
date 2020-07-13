package model;

public class UserInfo {
	private String name;
	private int id;
	private String password;

	public UserInfo() {}

	public UserInfo(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public UserInfo(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public UserInfo(String name, int id, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
