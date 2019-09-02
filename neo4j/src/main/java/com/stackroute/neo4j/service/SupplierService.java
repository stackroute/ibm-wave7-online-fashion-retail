package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.Supplier;
import com.stackroute.neo4j.repository.DesignerRepository;
import com.stackroute.neo4j.repository.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService
{
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier create(Supplier supplier)
    {
        return supplierRepository.save(supplier);
    }

    public void delete(Long id)
    {
        supplierRepository.deleteById(id);
    }
    public Iterable<Supplier> getAllSuppliers()
    {
        return supplierRepository.findAll();
    }
    public Supplier updateSupplier(Supplier supplier)
    {
        supplier.setLocation(supplier.getLocation());
        supplier.setEmail(supplier.getEmail());
        supplier.setName(supplier.getName());
        return supplierRepository.save(supplier);
    }
}
