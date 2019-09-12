package com.stackroute.onlinefashionretail.supplier.repository;

import com.stackroute.onlinefashionretail.supplier.domain.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends MongoRepository<Material,String> {

}
