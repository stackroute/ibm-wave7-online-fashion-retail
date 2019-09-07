package com.stackroute.designerdashboard.repository;

import com.stackroute.designerdashboard.model.Designer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DesignerRepository extends MongoRepository<Designer,String> {
}