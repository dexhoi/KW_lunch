package model;

import java.time.LocalTime;

import dao.GenreDAO;
import dao.ReviewDAO;
import dao.UserDAO;
import dao.VacationDAO;

/**
 * 店情報を格納する
 *
 */
public class Shop {

	private static GenreDAO genreDAO = new GenreDAO();
	private static ReviewDAO reviewDAO = new ReviewDAO();
	private static VacationDAO vacationDAO = new VacationDAO();
	private static UserDAO userDAO = new UserDAO();

	private int id = -1;
	private int userId = -1;
	private String name = "";
	private int genreId = -1;
	private int price = -1;
	private LocalTime offer;
	private String address = "";

	public Shop() {
	}

	/**
	 * 店のインスタンス生成
	 * @param userId 投稿者ユーザID
	 * @param name 店名
	 * @param genreId ジャンルID
	 * @param price 価格帯
	 * @param offer 食べられる時間(m)
	 * @param address 住所
	 */
	public Shop(int userId, String name, int genreId, int price, LocalTime offer, String address) {
		setUserId(userId);
		setName(name);
		setGenreId(genreId);
		setPrice(price);
		setOffer(offer);
		setAddress(address);
	}


	/**
	 * 登録ユーザ名を取得する
	 * @return
	 */
	public String getUserName() {
		return userDAO.getUserName(userId);
	}

	/**
	 * 定休日情報を文字列で取得する
	 * @return
	 */
	public String getVacations() {
		return vacationDAO.generateTxt(getId());
	}

	/**
	 * この店の評価の平均値を取得する
	 * @return 取得に失敗した場合は-1
	 */
	public double getScoreAVG() {
		if(id == -1) {
			return -1;
		}
		return reviewDAO.avg(id);
	}

	/**
	 * ジャンル名を取得する
	 * @return
	 */
	public String getGenreTxt() {
		return genreDAO.getGenreName(genreId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int  genreId) {
		this.genreId = genreId;
	}

	public LocalTime getOffer() {
		return offer;
	}

	public void setOffer(LocalTime offer) {
		this.offer = offer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
