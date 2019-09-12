package com.stackroute.onlinefashionretail.supplier.services;

import com.stackroute.onlinefashionretail.supplier.domain.Mapping;

import java.util.List;

public interface MappingService {

  public Mapping saveMapping(Mapping mapping);

  public List<Mapping> getAllMappings(String email);

  public List<Mapping> getMappings();

  public boolean deleteMapping(String id ) ;

  public Mapping updateMapping(Mapping mapping, String id);

}
