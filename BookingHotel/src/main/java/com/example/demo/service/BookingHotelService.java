package com.example.demo.service;

import java.util.List;

import com.example.demo.model.HotelInfo;
import com.example.demo.model.HotelinfoResponse;
import com.example.demo.model.RequestUserInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserReview;

public interface BookingHotelService {

	public List<HotelinfoResponse> listOfhotels(String filter, String value);

	public int addhotels(final HotelInfo hotelDetails);

	public int updatehotels(final HotelinfoResponse hotelDetails);

	public int deletehotels(final String hotelName);

	public int addUser(final UserInfo userInfo);

	public int updateUser(final RequestUserInfo userInfo);

	public int deleteUser(final String name);

	public int addReview(final UserReview userReview, final String id);

	public int deleteReview(final UserReview userReview, final String id);

}
