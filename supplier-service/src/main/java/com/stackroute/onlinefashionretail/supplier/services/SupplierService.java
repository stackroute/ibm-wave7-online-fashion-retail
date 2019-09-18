package com.stackroute.onlinefashionretail.supplier.services;

import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import com.stackroute.onlinefashionretail.supplier.domain.SupplierOrder;

import java.util.List;

public interface SupplierService {

    public Supplier saveSupplier(Supplier supplier);

    public List<Supplier> getAllSuppliers();

    public boolean deleteSupplier(String id ) ;

    public Supplier updateSupplier(Supplier supplier, String id);

    public Supplier getLoggedInSupplier(String email);

    public SupplierOrder saveOrder(String id,SupplierOrder supplierOrder) throws Exception;

    public List<SupplierOrder> getAllOrders(String id);

    public boolean deleteOrder(String id);

    public SupplierOrder updateOrder(SupplierOrder supplierOrder, String id);

    public SupplierOrder getOrderById(String id);

    Supplier getSupplierById(String id);

}
