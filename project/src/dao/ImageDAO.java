package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO extends AbstractDAO {

	public static boolean insertImg(int shopId, String imgPath){
		String query = "insert into img_tbl (shop_id, img_path) values(?, ?)";
		//接続
		try(var con =getConnection();
				var pstmt = con.prepareStatement(query)){
			pstmt.setInt(1, shopId);
			pstmt.setString(2, imgPath);

			return pstmt.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public static List<String> getImgList(int shop_id){
		List<String> list = new ArrayList<String>();
		final String SQL = "select * from img_tbl where shop_id = ?";
		//接続
		try(var con =getConnection();
				var pstmt = con.prepareStatement(SQL)){
			pstmt.setInt(1, shop_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("img_path"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
