package com.stackroute.user.services;

import com.stackroute.user.domain.Supplier;

import java.util.List;

public interface SupplierService {

    public Supplier saveSupplier(Supplier supplier);

    public List<Supplier> getAllSuppliers();

    public boolean deleteSupplier(int id ) ;

    public Supplier updateSupplier(Supplier supplier, int id);

}
