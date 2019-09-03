package com.stackroute.user.services;

import com.stackroute.user.domain.Mapping;
import com.stackroute.user.domain.Material;

import java.util.List;

public interface MappingService {

  public Mapping saveMapping(Mapping mapping);

  public List<Mapping> getAllMappings(String email);

  public boolean deleteMapping(int id ) ;

  public Mapping updateMapping(Mapping mapping, int id);

}
