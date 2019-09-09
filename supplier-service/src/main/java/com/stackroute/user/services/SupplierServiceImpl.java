package com.stackroute.user.services;

import com.stackroute.user.domain.Supplier;
import com.stackroute.user.domain.SupplierOrder;
import com.stackroute.user.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public boolean deleteSupplier(String id ){
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
    public Supplier updateSupplier(Supplier supplier, String id)
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

  @Override
  public SupplierOrder saveOrder(String id, SupplierOrder supplierOrder) throws Exception {
    System.out.println("in order repo save");
     Supplier save =supplierRepository.findById(id).orElseThrow(() -> new Exception("null value no id"));
     if (save.getSupplierOrders() == null)
       save.setSupplierOrders(new ArrayList<>());
     save.getSupplierOrders().add(supplierOrder);
     supplierRepository.save(save);
    System.out.println("suuplier order:"+supplierOrder);
     return supplierOrder;
    }

  @Override
  public List<SupplierOrder> getAllOrders(String id) {
    Supplier save =supplierRepository.findById(id).orElse(null);
    return save.getSupplierOrders();
  }

  @Override
  public boolean deleteOrder(String id) {
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
  public SupplierOrder updateOrder(SupplierOrder supplierOrder, String id) {
      Supplier supplier = supplierRepository.findById(id).orElse(null);
    for (SupplierOrder sup:
      supplier.getSupplierOrders()) {
      if (sup.getId().equals(supplierOrder.getId()))
      {
        sup.setMaterial(supplierOrder.getMaterial());
        sup.setQuantity(supplierOrder.getQuantity());
        sup.setOrderStatus(supplierOrder.getOrderStatus());
        return sup;
      }
    }
    return null;
  }

  @Override
  public SupplierOrder getOrderById(String id) {
    for (SupplierOrder sup:
      supplierRepository.findById(id).orElse(null).getSupplierOrders()) {
      if (sup.getId().equals(id))
        return sup;
    }
    return null;
  }

}
