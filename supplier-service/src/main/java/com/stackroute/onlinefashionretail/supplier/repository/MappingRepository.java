package com.stackroute.onlinefashionretail.supplier.repository;

import com.stackroute.onlinefashionretail.supplier.domain.Mapping;
import com.stackroute.onlinefashionretail.supplier.domain.Material;
import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappingRepository extends MongoRepository<Mapping,String> {
  List<Mapping> findBySupplier(Supplier supplier);
  List<Mapping> findByMaterial(Material material);
}
