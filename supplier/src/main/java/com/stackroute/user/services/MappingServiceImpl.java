package com.stackroute.user.services;

import com.stackroute.user.domain.Mapping;
import com.stackroute.user.domain.Material;
import com.stackroute.user.domain.Supplier;
import com.stackroute.user.repository.MappingRepository;
import com.stackroute.user.repository.MaterialRepository;
import com.stackroute.user.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MappingServiceImpl implements MappingService {
  MappingRepository mappingRepository;

  @Autowired
  SupplierService supplierService;
  @Autowired
  MaterialService materialService;

  @Autowired
  public MappingServiceImpl(MappingRepository mappingRepository)
  {
    this.mappingRepository = mappingRepository;
  }

  @Override
  public Mapping saveMapping(Mapping mapping) {

    if(materialService.findById(mapping.getMaterial().getId()) == null)
    {
      System.out.println("in save mapping if");
      Material saveMaterial= materialService.saveMaterial(mapping.getMaterial());
    }
    Mapping savedMapping = mappingRepository.save(mapping);
    return savedMapping;
  }

  @Override
  public List<Mapping> getAllMappings(String email) {
    System.out.println("in get all mappings mapping service");
    Supplier supplier2= supplierService.getLoggedInSupplier(email);
    System.out.println("after supplier service method call: "+mappingRepository.findBySupplier(supplier2));
    return mappingRepository.findBySupplier(supplier2);
  }

  @Override
  public List<Mapping> getMappings() {
    return mappingRepository.findAll();
  }

  @Override
  public boolean deleteMapping(int id ){
    // Optional<User> user1 = userRepository.findById(id);

    try {
      System.out.println(mappingRepository.findByMaterial(mappingRepository.findById(id).get().getMaterial()));

      if (mappingRepository.findByMaterial(mappingRepository.findById(id).get().getMaterial()).size() == 1){
        materialService.deleteMaterial(mappingRepository.findById(id).get().getMaterial().getId());
      }
      mappingRepository.delete(mappingRepository.findById(id).get());
      return true;

    }
    catch (Exception exception)
    {
      return false;
    }
  }
  @Override
  public Mapping updateMapping(Mapping mapping, int id)
  {
    Optional<Mapping> mapping1 = mappingRepository.findById(id);

    mapping.setQuantity(mapping.getQuantity());
    mapping.setPrice(mapping.getPrice());
    mapping.setMaterial(mapping1.get().getMaterial());
    mapping.setSupplier(mapping1.get().getSupplier());

    Mapping savedMapping = mappingRepository.save(mapping);
    return savedMapping;
  }
}
