package com.stackroute.manufacture.services;

import com.stackroute.manufacture.domain.Manufacture;

import java.util.List;
import java.util.Optional;

public interface ManufactureService {

    public Manufacture saveManufacture(Manufacture manufacture);

    public List<Manufacture> getAllManufactures();

    public boolean deleteManufacture(int id) ;

    public Optional<Manufacture> getManufacture(int id);

    public Manufacture updateManufacture(Manufacture manufacture, int id);

}
