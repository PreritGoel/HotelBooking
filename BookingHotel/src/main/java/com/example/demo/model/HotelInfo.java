package com.example.demo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotelInfo")
public class HotelInfo {

	private ObjectId _id;
	private String hotelName;
	private String city;
	private String stars;
	private boolean ac;
	private boolean wifi;
	private boolean restaurent;
	private boolean meal;
	private int costOfStay;
	private List<UserReview> userReview;
	
	/**
	 * 
	 */
	public HotelInfo() {
		super();
	}

	/**
	 * @param hotelName
	 * @param city
	 * @param stars
	 * @param ac
	 * @param wifi
	 * @param restaurent
	 * @param meal
	 * @param costOfStay
	 */
	public HotelInfo(String hotelName, String city, String stars, boolean ac, boolean wifi, boolean restaurent,
			boolean meal, int costOfStay) {
		super();
		this.hotelName = hotelName;
		this.city = city;
		this.stars = stars;
		this.ac = ac;
		this.wifi = wifi;
		this.restaurent = restaurent;
		this.meal = meal;
		this.costOfStay = costOfStay;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the stars
	 */
	public String getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}

	/**
	 * @return the ac
	 */
	public boolean isAc() {
		return ac;
	}

	/**
	 * @param ac the ac to set
	 */
	public void setAc(boolean ac) {
		this.ac = ac;
	}

	/**
	 * @return the wifi
	 */
	public boolean isWifi() {
		return wifi;
	}

	/**
	 * @param wifi the wifi to set
	 */
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	/**
	 * @return the restaurent
	 */
	public boolean isRestaurent() {
		return restaurent;
	}

	/**
	 * @param restaurent the restaurent to set
	 */
	public void setRestaurent(boolean restaurent) {
		this.restaurent = restaurent;
	}

	/**
	 * @return the meal
	 */
	public boolean isMeal() {
		return meal;
	}

	/**
	 * @param meal the meal to set
	 */
	public void setMeal(boolean meal) {
		this.meal = meal;
	}

	/**
	 * @return the costOfStay
	 */
	public int getCostOfStay() {
		return costOfStay;
	}

	/**
	 * @param costOfStay the costOfStay to set
	 */
	public void setCostOfStay(int costOfStay) {
		this.costOfStay = costOfStay;
	}

	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/**
	 * @return the userReview
	 */
	public List<UserReview> getUserReview() {
		return userReview;
	}

	/**
	 * @param userReview the userReview to set
	 */
	public void setUserReview(List<UserReview> userReview) {
		this.userReview = userReview;
	}
}
