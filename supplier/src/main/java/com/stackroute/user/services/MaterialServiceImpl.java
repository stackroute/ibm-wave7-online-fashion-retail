package com.stackroute.user.services;

import com.stackroute.user.domain.Material;
import com.stackroute.user.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaterialServiceImpl implements MaterialService {
  MaterialRepository materialRepository;

  @Autowired
  public MaterialServiceImpl(MaterialRepository materialRepository)
  {
    this.materialRepository = materialRepository;
  }

  @Override
  public Material saveMaterial(Material material) {
    System.out.println("In save Material");
    return materialRepository.save(material);
  }

  @Override
  public List<Material> getAllMaterials() {
    return materialRepository.findAll();
  }

  @Override
  public boolean deleteMaterial(String id ){
    // Optional<User> user1 = userRepository.findById(id);

    try {

      materialRepository.deleteById(id);

      return true;

    }
    catch (Exception exception)
    {
      return false;
    }
  }
  @Override
  public Material updateMaterial(Material material, String id)
  {
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
