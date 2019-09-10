package com.stackroute.manufacture.repository;

import com.stackroute.manufacture.domain.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManufactureRepository extends MongoRepository<Manufacturer,String> {
}
