package com.stackroute.designerdashboard.repository;

import com.stackroute.designerdashboard.model.DesignerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerOrderRepository extends MongoRepository<DesignerOrder,String> {

}
