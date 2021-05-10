package com.example.demo.dbBookingHotelRepository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.UserInfo;

public interface DbUserRepository extends MongoRepository<UserInfo, ObjectId>{

}
