package com.example.demo.model;

public class UserReview {
	
	private String review;
	private int rating;
	/**
	 * 
	 */
	public UserReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param review
	 * @param rating
	 */
	public UserReview(String review, int rating) {
		super();
		this.review = review;
		this.rating = rating;
	}
	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}
	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

}
