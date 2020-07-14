package dao;

import java.sql.SQLException;

public class ReviewDAO extends AbstractDAO {

	/**
	 * 評価を追加する
	 * @param shopId 店ID
	 * @param userId ユーザID
	 * @param score 評価
	 * @return
	 */
	public boolean add(int shopId, int userId, int score) {
		String query = "INSERT INTO review_tbl(shop_id, user_id, score) VALUES(?, ?, ?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, shopId);
			stmt.setInt(2, userId);
			stmt.setInt(3, score);

			return  stmt.executeUpdate() > 0;

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *ShopIDをもとに評価の平均値を出力する
	 * @param shopId
	 * @return
	 */
	public double avg(int shopId) {
		String query = "SELECT AVG(score) AS avg FROM review_tbl WHERE shop_id = ?";
		double result = -1;
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, shopId);
			var rs = stmt.executeQuery();
			while(rs.next()) {
				result = rs.getDouble("avg");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
