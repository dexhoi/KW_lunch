package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Shop;

public class ShopDAO extends AbstractDAO {

	/**
	 * 店を追加し、IDを割り当てます
	 * @param shop
	 * @return
	 */
	public boolean add(Shop shop) {
		boolean result = false;
		String query = "INSERT INTO shop_tbl(name, genre_id, price, offer_time, address) VALUES(?,?,?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, shop.getName());
			stmt.setInt(2, shop.getGenreId());
			stmt.setInt(3, shop.getPrice());
			stmt.setTime(4, java.sql.Time.valueOf(shop.getOffer()));
			stmt.setString(5, shop.getAddress());

			result = stmt.executeUpdate() > 0;

			var rs = stmt.getGeneratedKeys();

			while(rs.next()) {
				shop.setId(rs.getInt("id"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 店名が引数に含まれるものすべてを取得します
	 * @param keyword
	 * @return
	 */
	public List<Shop> searchByKeyword(String keyword){
		List<Shop> shops = new ArrayList<Shop>();
		String query = "SELECT * FROM shop_tbl WHERE name LIKE ?";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setString(1, "%" + keyword + "%");

			var rs = stmt.executeQuery();
			while(rs.next()) {
				var shop = new Shop(rs.getInt("user_id"), rs.getString("name"), rs.getInt("genre_id"), rs.getInt("price"), rs.getTime("offer_time").toLocalTime(),
						rs.getString("address"));

				shop.setId(rs.getInt("id"));

				shops.add(shop);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return shops;
	}

	/**
	 * 指定した時間内に食べることができる店をすべて取得します
	 * @param time
	 * @return
	 */
	public List<Shop> searchByTime(LocalTime time){
		List<Shop> shops = new ArrayList<Shop>();
		String query = "SELECT * FROM shop_tbl WHERE offer_time BETWEEN ? AND ?";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setTime(1, java.sql.Time.valueOf(time));
			stmt.setTime(2, java.sql.Time.valueOf(time));

			var rs = stmt.executeQuery();

			while(rs.next()) {
				var shop = new Shop(rs.getInt("user_id"), rs.getString("name"), rs.getInt("genre_id"), rs.getInt("price"), rs.getTime("offer_time").toLocalTime(),
						rs.getString("address"));

				shop.setId(rs.getInt("id"));

				shops.add(shop);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return shops;
	}

	/**
	 * ジャンルと一致するすべての店を取得します
	 * @param genreId
	 * @return
	 */
	public List<Shop> searchByGenre(int genreId){
		List<Shop> shops = new ArrayList<Shop>();
		String query = "SELECT * FROM shop_tbl WHERE genre_id = ?";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, genreId);

			var rs = stmt.executeQuery();
			while(rs.next()) {
				var shop = new Shop(rs.getInt("user_id"), rs.getString("name"), rs.getInt("genre_id"), rs.getInt("price"), rs.getTime("offer_time").toLocalTime(),
						rs.getString("address"));

				shop.setId(rs.getInt("id"));

				shops.add(shop);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return shops;
	}


	/**
	 * IDと一致する店を取得します
	 * @param id
	 * @return
	 */
	public Shop get(int id) {
		Shop shop = null;
		String query = "SELECT * FROM shop_tb WHERE id = ?";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)) {

			stmt.setInt(1, id);

			var rs = stmt.executeQuery();

			while(rs.next()) {
				shop = new Shop(rs.getInt("user_id"), rs.getString("name"), rs.getInt("genre_id"), rs.getInt("price"), rs.getTime("offer_time").toLocalTime(),
						rs.getString("address"));

				shop.setId(rs.getInt("id"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return shop;
	}



}
