package com.stackroute.onlinefashionretail.manufacturer.repository;

import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManufactureRepository extends MongoRepository<Manufacturer,String> {
}
