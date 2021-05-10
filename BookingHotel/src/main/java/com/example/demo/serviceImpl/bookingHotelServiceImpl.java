package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.dbBookingHotelRepository.DbUserRepository;
import com.example.demo.dbBookingHotelRepository.dbBookingHotelRepository;
import com.example.demo.model.HotelInfo;
import com.example.demo.model.HotelinfoResponse;
import com.example.demo.model.RequestUserInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserReview;
import com.example.demo.service.BookingHotelService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.result.UpdateResult;

@Service("bookingHotelService")
public class bookingHotelServiceImpl implements BookingHotelService{

	@Autowired
	private dbBookingHotelRepository dbBookingHotelRepository;
	
	@Autowired
	private DbUserRepository dbUserRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 *Method to get list of Hotels
	 *
	 * @param filter
	 * @param value
	 * 
	 **/
	@Override
	public List<HotelinfoResponse> listOfhotels(final String filter, final String value) {
		try {
			final List<HotelInfo> listOfhotels = dbBookingHotelRepository.findAll();
						
			// checking listOfhotels is null or empty
			if(null == listOfhotels || listOfhotels.isEmpty()) {
				return Collections.emptyList();
			}
			final List<HotelInfo> filterlistOfhotels = new ArrayList<>();
			
			// fetching info according to filter
			switch (filter) {

			case "all":
				filterlistOfhotels.addAll(listOfhotels);
				break;

			case "stars":
				listOfhotels.stream().filter(Objects::nonNull).forEach(holel -> {
					if (value.equals(holel.getStars())) {
						filterlistOfhotels.add(holel);
					}
				});
				break;

			case "city":
				listOfhotels.stream().filter(Objects::nonNull).forEach(holel -> {
					if (value.equals(holel.getCity())) {
						filterlistOfhotels.add(holel);
					}
				});
				break;
				
			case "budget":
				listOfhotels.stream().filter(Objects::nonNull).forEach(holel -> {
					if (Integer.parseInt(value) >= holel.getCostOfStay()) {
						filterlistOfhotels.add(holel);
					}
				});
				break;

			default:
				return Collections.emptyList();
			}
			
			final List<HotelinfoResponse> listOfhotelsResponse = new ArrayList<>(filterlistOfhotels.size());
			// iterating list of hotels to set in response
			filterlistOfhotels.stream().filter(Objects::nonNull).forEach(holels -> {
				listOfhotelsResponse.add(new HotelinfoResponse(holels.get_id().toString(), holels.getHotelName(),
						holels.getCity(), holels.getStars(), holels.isAc(), holels.isWifi(), holels.isRestaurent(),
						holels.isMeal(), holels.getCostOfStay()));
			});
			return listOfhotelsResponse;
			
		} catch (final Exception e) {
			return Collections.emptyList();
		}
		
	}

	
	/**
	 *Method to add Hotel info
	 *
	 * @param hotelDetails
	 * 
	 * 
	 **/
	@Override
	public int addhotels(final HotelInfo hotelDetails) {
		try {
			dbBookingHotelRepository.save(hotelDetails);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	/**
	 *Method to update Hotel info
	 *
	 * @param hotelDetails
	 * 
	 * 
	 **/
	@Override
	public int updatehotels(final HotelinfoResponse hotelDetails) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(new ObjectId(hotelDetails.getId())));

		final Update update = new Update();
		update.set("hotelName", hotelDetails.getHotelName());
		update.set("city", hotelDetails.getCity());
		update.set("stars", hotelDetails.getStars());
		update.set("costOfStay", hotelDetails.getCostOfStay());
		
		final UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, HotelInfo.class);
		if (updateFirst.getModifiedCount() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 *Method to delete Hotel info
	 *
	 * @param hotelDetails
	 * 
	 * 
	 **/
	@Override
	public int deletehotels(final String hotelName) {
		try {
			final Query query = new Query();
			query.addCriteria(Criteria.where("hotelName").is(hotelName));

			// delete the data from hotelInfo
			mongoTemplate.remove(query, HotelInfo.class);
			return 1;

		} catch (final Exception e) {
			return 0;
		}
	}

	/**
	 *Method to add User info
	 *
	 * @param userInfo
	 * 
	 * 
	 **/
	@Override
	public int addUser(final UserInfo userInfo) {
		try {
			dbUserRepository.save(userInfo);
			return 1;
		} catch (final Exception e) {
			return 0;
		}
	}

	/**
	 *Method to update User info
	 *
	 * @param userInfo
	 * 
	 * 
	 **/
	@Override
	public int updateUser(final RequestUserInfo userInfo) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(userInfo.get_id()));

		final Update update = new Update();
		update.set("email", userInfo.getEmail());
		update.set("name", userInfo.getName());
		update.set("password", userInfo.getPassword());
		update.set("contact", userInfo.getContact());
		
		final UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, UserInfo.class);
		if (updateFirst.getModifiedCount() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 *Method to delete User info
	 *
	 * @param id
	 * 
	 * 
	 **/
	@Override
	public int deleteUser(final String name) {
		final Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));

		// delete the data from userInfo
		mongoTemplate.remove(query, UserInfo.class);
		return 1;
	}
	
	/**
	 *Method to add Review of hotel
	 *
	 * @param userInfo
	 * 
	 * 
	 **/
	@Override
	public int addReview(final UserReview userReview, String id) {
		
		final HotelInfo hotelInfo = dbBookingHotelRepository.findById(new ObjectId(id)).get();
		
		List<UserReview> userReviews = new ArrayList<>();
		if (null != hotelInfo.getUserReview() && !hotelInfo.getUserReview().isEmpty()) {
			userReviews.addAll(hotelInfo.getUserReview());
		}
		
		userReviews.add(userReview);
		final Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));
				
		final Update update = new Update();
		update.set("userReview;",userReviews);		
		final UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, HotelInfo.class);
		if (updateFirst.getModifiedCount() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 *Method to delete Review of hotel
	 *
	 * @param userReview
	 * @param id
	 * 
	 **/
	@Override
	public int deleteReview(UserReview userReview, String id) {
		final Query query = new Query();
		// adding criteria
		query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));
				

		final Update update = new Update();
		// checking peerIdList is empty or not
	
			update.pull("userReview",
					new BasicDBObject("review", userReview.getReview()));
		

		// updating result
		mongoTemplate.updateFirst(query, update, HotelInfo.class);
		return 1;
		
	}


}
