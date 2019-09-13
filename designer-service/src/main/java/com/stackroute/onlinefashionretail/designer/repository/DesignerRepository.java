package com.stackroute.onlinefashionretail.designer.repository;

import com.stackroute.onlinefashionretail.designer.model.Designer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DesignerRepository extends MongoRepository<Designer,String> {
}