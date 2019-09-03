package com.stackroute.manufacture.repository;

import com.stackroute.manufacture.domain.Manufacture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManufactureRepository extends MongoRepository<Manufacture,Integer> {
}