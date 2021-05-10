package com.example.demo.dbBookingHotelRepository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.HotelInfo;

public interface dbBookingHotelRepository extends MongoRepository<HotelInfo, ObjectId>{

	@Query(value = "{ '_id' : ?0 }")
	public Optional<HotelInfo> findById(final ObjectId id);

}
