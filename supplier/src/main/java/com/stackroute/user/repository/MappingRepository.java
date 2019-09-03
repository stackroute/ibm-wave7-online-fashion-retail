package com.stackroute.user.repository;

import com.stackroute.user.domain.Mapping;
import com.stackroute.user.domain.Material;
import com.stackroute.user.domain.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappingRepository extends MongoRepository<Mapping,Integer> {
  List<Mapping> findBySupplier(Supplier supplier);
  List<Mapping> findByMaterial(Material material);
}
