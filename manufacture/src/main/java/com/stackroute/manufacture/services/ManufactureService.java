package com.stackroute.manufacture.services;

import com.stackroute.manufacture.domain.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufactureService {

    public Manufacturer saveManufacture(Manufacturer manufacturer);

    public List<Manufacturer> getAllManufactures();

    public boolean deleteManufacture(String id) ;

    public Optional<Manufacturer> getManufacture(String id);

    public Manufacturer updateManufacture(Manufacturer manufacturer, String id);

}
