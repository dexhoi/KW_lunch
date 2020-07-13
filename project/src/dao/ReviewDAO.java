package dao;

import java.sql.SQLException;

public class ReviewDAO extends AbstractDAO {

	public boolean add(int shopId, int score) {
		String query = "INSERT INTO review_tbl(shop_id, score) VALUES(?, ?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, shopId);
			stmt.setInt(2, score);

			return  stmt.executeUpdate() > 0;

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
