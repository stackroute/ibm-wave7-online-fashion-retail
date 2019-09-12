package com.stackroute.onlinefashionretail.supplier.repository;

import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierRepository extends MongoRepository<Supplier,String> {
  List<Supplier> findByEmail(String email);
}
