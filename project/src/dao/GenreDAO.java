package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * genre_tblのDAO
 *
 */
public class GenreDAO extends AbstractDAO {

	/**
	 * ジャンルIDと一致するジャンル名を取得する
	 * @param genreId
	 * @return
	 */
	public String getGenreName(int genreId) {
		String result = "";
		String query = "SELECT name FROM genre_tbl WHERE id = ?";

		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, genreId);

			var rs = stmt.executeQuery();
			while(rs.next()) {
				result = rs.getString("name");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * すべてのジャンル名を取得する
	 * @return
	 */
	public List<String> getAll(){
		List<String> list = new LinkedList<String>();

		String query = "SELECT name FROM genre_tbl";

		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {


			var rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("name"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
