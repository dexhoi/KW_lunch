package dao;

import java.sql.SQLException;

public class VacationDAO extends AbstractDAO {

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

}
