package model;

public class User {
	private String name;
	private int id;
	private String password;

	public User() {}

	/**
	 * ユーザインスタンスを生成する
	 * @param name ユーザ名
	 * @param password パスワード
	 */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}


	/**
	 * ユーザインスタンスを生成
	 * @param name ユーザ名
	 * @param id ユーザID
	 * @param password パスワード
	 */
	public User(String name, int id, String password) {
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
