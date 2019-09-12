package com.stackroute.onlinefashionretail.supplier.services;

import com.stackroute.onlinefashionretail.supplier.repository.MaterialRepository;
import com.stackroute.onlinefashionretail.supplier.domain.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaterialServiceImpl implements MaterialService {

  private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  MaterialRepository materialRepository;

  @Autowired
  public MaterialServiceImpl(MaterialRepository materialRepository)
  {
    this.materialRepository = materialRepository;
  }

  @Override
  public Material saveMaterial(Material material) {
    logger.info("Inside save Material in MaterialServiceImpl");
    return materialRepository.save(material);
  }

  @Override
  public List<Material> getAllMaterials() {
    logger.info("Inside getAllMaterial in MaterialServiceImpl");
    return materialRepository.findAll();
  }

  @Override
  public boolean deleteMaterial(String id ){
    try {
      logger.info("Inside deleteMaterial  try block in MaterialServiceImpl");
      materialRepository.deleteById(id);

      return true;

    }
    catch (Exception exception)
    {
      logger.info("Inside deleteMaterial catch block in MaterialServiceImpl");
      return false;
    }
  }

  @Override
  public Material updateMaterial(Material material, String id)
  {
    logger.info("Inside updateMaterial in MaterialServiceImpl");
    Optional<Material> material1 = materialRepository.findById(id);
    material.setName(material.getName());
    material.setCategory(material.getCategory());
    material.setImage(material.getImage());
    Material savedMaterial = materialRepository.save(material);
    return savedMaterial;
  }

  @Override
  public Material findById(String id) {
    return materialRepository.findById(id).orElse(null);
  }
}
