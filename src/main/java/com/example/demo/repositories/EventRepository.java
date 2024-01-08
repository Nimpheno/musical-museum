package com.example.demo.repositories;

import com.example.demo.entity.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventEntity,String> {


}
