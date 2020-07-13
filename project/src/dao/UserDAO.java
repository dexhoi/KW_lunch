package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends AbstractDAO {

	public List<User> getUserInfoList(){
		List<User> list = new ArrayList<User>();
		final String SQL = "select * from user_tbl";
		//接続
		try(var con = getConnection();
				var pstmt = con.prepareStatement(SQL)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getString("name"),
						rs.getInt("id"),
						rs.getString("password")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public boolean isExists(User user) {
		boolean result = false;
		String query = "SELECT * FROM user_tbl WHERE name = ? AND password = ?";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());

			var rs = stmt.executeQuery();
			while(rs.next()) {
				result = true;
				user.setId(rs.getInt("id"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean add(User user){
		boolean result = false;
		String query = "INSERT INTO user_tbl(name, password) VALUES(?, ?)";
		//接続
		try(var con = getConnection();
				var pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());

			result = pstmt.executeUpdate() > 0;

			var rs = pstmt.getGeneratedKeys();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
