package model;

import java.time.LocalTime;

import dao.GenreDAO;

public class Shop {

	private static GenreDAO genreDAO = new GenreDAO();

	private int id;
	private int userId;
	private String name;
	private int genreId;
	private int price;
	private LocalTime offer;
	private String address;

	public Shop() {

	}

	/**
	 *
	 * @param name
	 * @param genreId
	 * @param price
	 * @param offer
	 * @param address
	 */
	public Shop(int userId, String name, int genreId, int price, LocalTime offer, String address) {
		setUserId(userId);
		setName(name);
		setGenreId(genreId);
		setPrice(price);
		setOffer(offer);
		setAddress(address);
	}



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
