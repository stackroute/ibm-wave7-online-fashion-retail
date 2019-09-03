package com.stackroute.user.services;

import com.stackroute.user.domain.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    public Supplier saveSupplier(Supplier supplier);

    public List<Supplier> getAllSuppliers();

  public Optional<Supplier> getSupplier(int id);

    public boolean deleteSupplier(int id ) ;

    public Supplier updateSupplier(Supplier supplier, int id);

}
