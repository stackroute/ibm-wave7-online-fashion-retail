package com.stackroute.Baseprice.repository;

import com.stackroute.Baseprice.domain.Baseprice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasepriceRepository extends MongoRepository<Baseprice, Integer>
{


}
