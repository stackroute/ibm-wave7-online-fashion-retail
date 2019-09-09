package com.stackroute.manufacture.repository;

import com.stackroute.manufacture.domain.BasePrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasepriceRepository extends MongoRepository<BasePrice, String>
{


}
