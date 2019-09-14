package com.stackroute.neo4j.repository;
import com.stackroute.neo4j.entity.Designer;
import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.entity.Supplier;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface DesignerRepository extends Neo4jRepository<Designer,String> {
  @Query("MATCH(s:Manufacturer) RETURN s ORDER BY s.rating DESC limit 2")
  List<Manufacturer> getManufacturers();
  @Query("MATCH(s:Supplier) RETURN s ORDER BY s.rating DESC limit 5")
  List<Supplier> getSuppliers();
//  @Query("")
//  List<Designer> getSuppliersAndManufacturersBasedOnPreviousOrders(@Param("name") String name);
}

