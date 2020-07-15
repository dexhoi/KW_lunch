package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VacationDAO extends AbstractDAO {

	private static Map<Integer, String> vacMap;

	static {
		vacMap = new HashMap<Integer, String>();
		vacMap.put(1, "月曜日");
		vacMap.put(2, "火曜日");
		vacMap.put(3, "水曜日");
		vacMap.put(4, "木曜日");
		vacMap.put(5, "金曜日");
		vacMap.put(6, "土曜日");
		vacMap.put(7, "日曜日");
	}

	/**
	 * 商品IDとともに休暇情報を追加
	 * @param shopId 商品ID
	 * @param vacations 休暇配列
	 */
	public void addAll(int shopId, int[] vacations) {

		if(vacations == null) {return;}

		String query = "INSERT INTO vac_tbl(shop_id, vacation) VALUES(?,?)";
		for(int vacation : vacations) {
			try(var con = getConnection();
					var stmt = con.prepareStatement(query)) {

				stmt.setInt(1, shopId);
				stmt.setInt(2, vacation);

				stmt.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 店IDと一致する定休日を文字列にして表示する
	 * @param shopId 店ID
	 * @return
	 */
	public String generateTxt(int shopId) {
		StringBuilder builder = new StringBuilder();
		String query = "SELECT vacation FROM vac_tbl WHERE shop_id = ?";
		List<Integer> vacs = new LinkedList<Integer>();
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, shopId);

			var rs = stmt.executeQuery();
			while(rs.next()) {
				vacs.add(rs.getInt("vacation"));
			}

			for(var vac : vacs) {
				builder.append(vacMap.get(vac));
				builder.append(",");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

}
