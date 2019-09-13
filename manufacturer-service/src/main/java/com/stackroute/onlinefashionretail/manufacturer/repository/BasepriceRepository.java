package com.stackroute.onlinefashionretail.manufacturer.repository;

import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasepriceRepository extends MongoRepository<BasePrice, String>
{


}
