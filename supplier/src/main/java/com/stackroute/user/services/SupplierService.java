package com.stackroute.user.services;

import com.stackroute.user.domain.Supplier;
import com.stackroute.user.domain.SupplierOrder;
import org.apache.kafka.common.protocol.types.Field;

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

}
