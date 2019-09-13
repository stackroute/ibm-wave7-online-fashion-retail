package com.stackroute.onlinefashionretail.supplier.services;

import com.stackroute.onlinefashionretail.supplier.domain.Material;

import java.util.List;

public interface MaterialService {

  public Material saveMaterial(Material material);

  public List<Material> getAllMaterials();

  public boolean deleteMaterial(String id ) ;

  public Material updateMaterial(Material material, String id);

  public Material findById(String id);
}
