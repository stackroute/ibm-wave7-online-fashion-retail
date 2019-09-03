package com.stackroute.user.repository;

import com.stackroute.user.domain.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends MongoRepository<Material,Integer> {

}
