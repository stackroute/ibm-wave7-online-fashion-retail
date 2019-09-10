package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService
{
    private ManufacturerRepository manufacturerRepository;
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public Manufacturer create(Manufacturer designer)
    {
        return manufacturerRepository.save(designer);
    }

    public void delete(Long id)
    {
        manufacturerRepository.deleteById(id);
    }
    public Iterable<Manufacturer> getAllManufacturers()
    {
        return manufacturerRepository.findAll();
    }
    public Manufacturer updateManufacturer(Manufacturer manufacturer)
    {
        manufacturer.setName(manufacturer.getName());
        manufacturer.setCity(manufacturer.getCity());
        manufacturer.setEmail(manufacturer.getEmail());
        return manufacturerRepository.save(manufacturer);
    }

}
