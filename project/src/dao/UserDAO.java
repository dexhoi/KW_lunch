package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UserInfo;

public class UserDAO extends AbstractDAO {

	public static List<UserInfo> getUserInfoList(){
		List<UserInfo> list = new ArrayList<UserInfo>();
		final String SQL = "select * from user_tbl";
		//接続
		try(var con = getConnection();
				var pstmt = con.prepareStatement(SQL)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new UserInfo(	rs.getString("name"),
												rs.getInt("id"),
												rs.getString("password")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int insertUser(UserInfo user){
		final String INSERTSQL = "insert into user_tbl (name, password) values(?, ?)";
		int row = 0;
		//接続
		try(var con = getConnection();
				var pstmt = con.prepareStatement(INSERTSQL, Statement.RETURN_GENERATED_KEYS)){
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			//update(反映)されます
			row = pstmt.executeUpdate();

			var rs = pstmt.getGeneratedKeys();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
