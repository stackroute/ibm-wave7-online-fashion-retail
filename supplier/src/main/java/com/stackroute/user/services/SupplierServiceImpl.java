package com.stackroute.user.services;

import com.stackroute.user.domain.Supplier;
import com.stackroute.user.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository)
    {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        Supplier savedUser = supplierRepository.save(supplier);
        return savedUser;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public boolean deleteSupplier(int id ){
      // Optional<User> user1 = userRepository.findById(id);

        try {

            supplierRepository.deleteById(id);

            return true;

        }
        catch (Exception exception)
        {
            return false;
        }
    }
    @Override
    public Supplier updateSupplier(Supplier supplier, int id)
    {
        Optional<Supplier> supplier1 = supplierRepository.findById(id);

        supplier.setName(supplier.getName());
        supplier.setEmail(supplier.getEmail());
        supplier.setCity(supplier.getCity());
        supplier.setRating(supplier.getRating());

        Supplier savedSupplier = supplierRepository.save(supplier);
        return savedSupplier;
    }

  @Override
  public Supplier getLoggedInSupplier(String email) {
      if (supplierRepository.findByEmail(email).isEmpty()) {
        try {
          throw new Exception("supplier not found!");
        } catch (Exception e) {
          e.printStackTrace();
          return null;
        }
      }
      else
      {
        System.out.println("in get logged in supplier service: "+supplierRepository.findByEmail(email).get(0).toString());
        return supplierRepository.findByEmail(email).get(0);
      }
  }

}
