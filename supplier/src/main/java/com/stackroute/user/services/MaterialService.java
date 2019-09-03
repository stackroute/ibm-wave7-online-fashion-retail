package com.stackroute.user.services;

import com.stackroute.user.domain.Material;

import java.util.List;

public interface MaterialService {

  public Material saveMaterial(Material material);

  public List<Material> getAllMaterials();

  public boolean deleteMaterial(int id ) ;

  public Material updateMaterial(Material material, int id);

  public Material findById(int id);
}
