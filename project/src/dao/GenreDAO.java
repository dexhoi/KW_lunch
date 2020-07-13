package dao;

import java.sql.SQLException;

import model.Genre;

public class GenreDAO extends AbstractDAO {

	public int getId(Genre genre) {
		int result = -1;
		String query = "SELECT id FROM genre_tbl WHERE name = ?";

		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setString(1, genre.name());

			var rs = stmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt("id");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getGenreName(int genreId) {
		String result = "";
		String query = "SELECT id FROM genre_tbl WHERE id = ?";

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

}
