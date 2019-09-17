package com.stackroute.onlinefashionretail.supplier.services;

import com.stackroute.onlinefashionretail.supplier.repository.MappingRepository;
import com.stackroute.onlinefashionretail.supplier.domain.Mapping;
import com.stackroute.onlinefashionretail.supplier.domain.Material;
import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MappingServiceImpl implements MappingService {

  private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

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
    logger.info("Inside saveMapping");
    if(materialService.findById(mapping.getMaterial().getId()) == null)
    {
      Material saveMaterial= materialService.saveMaterial(mapping.getMaterial());
    }
    Mapping savedMapping = mappingRepository.save(mapping);
    return savedMapping;
  }

  @Override
  public List<Mapping> getAllMappings(String email) {
   logger.info("inside getAllMappings mapping service");
    Supplier supplier2= supplierService.getLoggedInSupplier(email);
    logger.info("after supplier service method call: "+mappingRepository.findBySupplier(supplier2));
    return mappingRepository.findBySupplier(supplier2);
  }

  @Override
  public List<Mapping> getMappings() {
    logger.info("inside getMapping");
    return mappingRepository.findAll();
  }

  @Override
  public boolean deleteMapping(String id ){
    try {
      logger.info("",mappingRepository.findByMaterial(mappingRepository.findById(id).get().getMaterial()));
      logger.info("Inside deleteMapping try block in MappingSericeImpl");
      if (mappingRepository.findByMaterial(mappingRepository.findById(id).get().getMaterial()).size() == 1){
        materialService.deleteMaterial(mappingRepository.findById(id).get().getMaterial().getId());
      }
      mappingRepository.delete(mappingRepository.findById(id).get());
      return true;

    }
    catch (Exception exception)
    {
      logger.info("Inside deleteMapping catch block in MappingSericeImpl");
      return false;
    }
  }
  @Override
  public Mapping updateMapping(Mapping mapping, String id)
  {
    logger.info("Inside updateMapping in MappingSericeImpl");
    Optional<Mapping> mapping1 = mappingRepository.findById(id);

    mapping.setQuantity(mapping.getQuantity());
    mapping.setPrice(mapping.getPrice());
    mapping.setMaterial(mapping1.get().getMaterial());
    mapping.setSupplier(mapping1.get().getSupplier());

    Mapping savedMapping = mappingRepository.save(mapping);
    return savedMapping;
  }

  @Override
  public String getSupplierId(String mappingId) {
    if (mappingRepository.findById(mappingId).isPresent())
      return mappingRepository.findById(mappingId).get().getSupplier().getId();
    return null;
  }

  @Override
  public Material getMaterialById(String mappingId) {
    if (mappingRepository.findById(mappingId).isPresent())
      return mappingRepository.findById(mappingId).get().getMaterial();
    return null;
  }
}
