package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HotelInfo;
import com.example.demo.model.HotelinfoResponse;
import com.example.demo.model.RequestUserInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserReview;
import com.example.demo.service.BookingHotelService;
@RestController
@RequestMapping(value = "/bookinghotel")
public class BookingHotel {

	@Autowired
	private BookingHotelService bookingHotelService;
	
	@GetMapping(value = { "/{version:v[1]?}/listofhotels/{filter}/{value}" }, produces = "application/json")
	public List<HotelinfoResponse> listOfHotels(@PathVariable final String filter, @PathVariable final String value) {
		return bookingHotelService.listOfhotels(filter, value);
	}

	@PostMapping(value = { "/{version:v[1]?}/hotel" }, produces = "application/json")
	public int addHotels(@RequestBody HotelInfo hotelDetails) {
		return bookingHotelService.addhotels(hotelDetails);
	}

	@PutMapping(value = { "/{version:v[1]?}/hotel" }, produces = "application/json")
	public int updateHotels(@RequestBody HotelinfoResponse hotelDetails) {
		return bookingHotelService.updatehotels(hotelDetails);
	}

	@DeleteMapping(value = { "/{version:v[1]?}/hotel" }, produces = "application/json")
	public int deleteHotels(@RequestBody String hotelName) {
		return bookingHotelService.deletehotels(hotelName);
	}
	
	
	//user API
	@PostMapping(value = { "/{version:v[1]?}/adduser" }, produces = "application/json")
	public int addUser(@RequestBody UserInfo userInfo) {
		return bookingHotelService.addUser(userInfo);
	}

	@PutMapping(value = { "/{version:v[1]?}/updateuser" }, produces = "application/json")
	public int updateUser(@RequestBody RequestUserInfo userInfo) {
		return bookingHotelService.updateUser(userInfo);
	}

	@DeleteMapping(value = { "/{version:v[1]?}/deleteUser" }, produces = "application/json")
	public int deleteUser(@RequestBody String name) {
		return bookingHotelService.deleteUser(name);
	}
	
	@PutMapping(value = { "/{version:v[1]?}/addhotelreview/{id}" }, produces = "application/json")
	public int addReview(@PathVariable final String id,@RequestBody UserReview userReview) {
		return bookingHotelService.addReview(userReview, id);
	}
	
	@PutMapping(value = { "/{version:v[1]?}/deletehotelreview/{id}" }, produces = "application/json")
	public int deleteReview(@PathVariable final String id,@RequestBody UserReview userReview) {
		return bookingHotelService.deleteReview(userReview, id);
	}
}
