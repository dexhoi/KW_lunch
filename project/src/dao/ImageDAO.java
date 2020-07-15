package dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

/**
 * img_tblのDAO
 *
 */
public class ImageDAO extends AbstractDAO {

	private static final String SEPARATOR = System.getProperty("file.separator");

	/**
	 * 画像パスを商品IDとともに追加する
	 * @param shopId 商品ID
	 * @param imgPath 画像パス
	 * @return
	 */
	public boolean add(int shopId, String imgPath){
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


	/**
	 * 商品IDと一致するすべての画像パスを取得する
	 * @param shop_id 商品ID
	 * @return
	 */
	public List<String> getImgList(int shop_id){
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

	/**
	 * 画像ファイルを読み込んでBase64形式に変換します
	 * @param path 画像パス
	 * @return Base64形式の画像文字列
	 */
	public String convertBase64(String path) {

		String result = "";
		if(!(new File(path).exists())) {
			return result;
		}

		if(path.contains("png")) {
			result = "data:image/png;base64,";
		}

		if(path.contains("jpeg") || path.contains("jpg")) {
			result = "data:image/jpeg;base64,";
		}

		try(var reader = new FileInputStream(path);
				var out = new ByteArrayOutputStream()) {

			byte[] buffer = new byte[4096];
			int i;
			while((i = reader.read(buffer)) != -1) {
				out.write(buffer, 0, i);
			}

			out.flush();
			var imgData = Base64.encode(out.toByteArray());
			result = result + new String(imgData);

		}catch(IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * ShopIDと一致するすべての画像ファイルをBase64形式に変換して取得します
	 * @param shopId 商品ID
	 * @param root TomcatのTEMPフォルダ
	 * @return
	 */
	public List<String> getImgDataByShopId(int shopId, File root){
		var paths = getImgList(shopId);
		for(int i = 0; i < paths.size(); i++) {
			var newPath = root + SEPARATOR + shopId + SEPARATOR + paths.get(i);
			paths.set(i, newPath);
		}

		List<String> results = new ArrayList<String>(paths.size());
		for(var path : paths) {
			results.add(convertBase64(path));
		}

		return results;
	}
}
