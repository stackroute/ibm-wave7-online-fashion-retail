package com.stackroute.user.repository;

import com.stackroute.user.domain.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends MongoRepository<Supplier,Integer> {
}
