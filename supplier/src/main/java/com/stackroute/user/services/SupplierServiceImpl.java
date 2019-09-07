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
    public Optional<Supplier> getSupplier(int id) { return supplierRepository.findById(id); }

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
    String name=supplier1.get().getName();
    String email=supplier1.get().getEmail();


    supplier.setId(id);
    supplier.setName(name);
    supplier.setEmail(email);
    supplier.setCity(supplier.getCity());
    supplier.setRating(supplier.getRating());
    supplier.setContactNumber(supplier.getContactNumber());

    Supplier savedSupplier = supplierRepository.save(supplier);
    return savedSupplier;
  }

}
