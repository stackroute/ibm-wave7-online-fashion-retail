package com.stackroute.onlinefashionretail.designer.repository;

import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerOrderRepository extends MongoRepository<DesignerOrder,String> {

}
