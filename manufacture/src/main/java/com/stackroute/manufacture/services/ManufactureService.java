package com.stackroute.manufacture.services;

import com.stackroute.manufacture.domain.Manufacture;

import java.util.List;

public interface ManufactureService {

    public Manufacture saveManufacture(Manufacture manufacture);

    public List<Manufacture> getAllManufactures();

    public boolean deleteManufacture(int id) ;

    public Manufacture updateManufacture(Manufacture manufacture, int id);

}
