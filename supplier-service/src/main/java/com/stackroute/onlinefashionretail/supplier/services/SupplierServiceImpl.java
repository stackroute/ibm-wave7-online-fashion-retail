package com.stackroute.onlinefashionretail.supplier.services;

import com.stackroute.onlinefashionretail.supplier.repository.SupplierRepository;
import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import com.stackroute.onlinefashionretail.supplier.domain.SupplierOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    SupplierRepository supplierRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "ORDER_STATUS";

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        logger.info("Inside saveSupplier");
        Supplier savedUser = supplierRepository.save(supplier);
        return savedUser;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        logger.info("Inside getAllSupplier in SupplierServiceImpl");
        return supplierRepository.findAll();
    }

    @Override
    public boolean deleteSupplier(String id) {
        try {
            logger.info("Inside deleteSupplier try block in SupplierServiceImpl");
            supplierRepository.deleteById(id);

            return true;

        } catch (Exception exception) {
            logger.info("Inside deleteSupplier catch block in SupplierServiceImpl");
            return false;
        }
    }

    @Override
    public Supplier updateSupplier(Supplier supplier, String id) {
        logger.info("Inside updateSupplier in SupplierServiceImpl");
        Supplier supplier1 = supplierRepository.findById(id).orElse(null);

        supplier1.setName(supplier.getName());
        supplier1.setEmail(supplier.getEmail());
        supplier1.setCity(supplier.getCity());
        supplier1.setRating(supplier.getRating());

        Supplier savedSupplier = supplierRepository.save(supplier);
        return savedSupplier;
    }

    @Override
    public Supplier getLoggedInSupplier(String email) {
        if (supplierRepository.findByEmail(email).isEmpty()) {
            try {
                logger.info("Inside getLoggedInSupplier try block in SupplierServiceImpl");
                throw new Exception("supplier not found!");
            } catch (Exception e) {
                logger.info("Inside getLoggedInSupplier catch block in SupplierServiceImpl");
                e.printStackTrace();
                return null;
            }
        } else {
            logger.info("in get logged in supplier service: " + supplierRepository.findByEmail(email).get(0).toString());
            return supplierRepository.findByEmail(email).get(0);
        }
    }

    @Override
    public SupplierOrder saveOrder(String id, SupplierOrder supplierOrder) throws Exception {
        logger.info("Inside the saveOrder in SupplierServiceimpl");
        Supplier save = supplierRepository.findById(id).orElseThrow(() -> new Exception("null value no id"));
        if (save.getSupplierOrders() == null)
            save.setSupplierOrders(new ArrayList<>());
        save.getSupplierOrders().add(supplierOrder);
        supplierRepository.save(save);
        System.out.println("suuplier order:" + supplierOrder);
        return supplierOrder;
    }

    @Override
    public List<SupplierOrder> getAllOrders(String id) {
        logger.info("inside getAllOrders in SupplierServiceImpl");
        Supplier save = supplierRepository.findById(id).orElse(null);
        logger.info("", save.getSupplierOrders());
        return save.getSupplierOrders();
    }

    @Override
    public boolean deleteOrder(String id) {
        try {
            logger.info("inside deleteOrder try block in SupplierServiceImpl");
            supplierRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            logger.info("inside deleteOrder catch block in SupplierServiceImpl");
            return false;
        }
    }

    @Override
    public SupplierOrder updateOrder(SupplierOrder supplierOrder, String id) {
        logger.info("inside updateOrder in SupplierServiceImpl");
        Supplier supplier = supplierRepository.findById(id).orElse(null);

        SupplierOrder supplierOrder1 = null;
        for (SupplierOrder sup : supplier.getSupplierOrders()) {
            if (sup.getId().equals(supplierOrder.getId())) {
                System.out.println("inside");
                sup.setMaterial(supplierOrder.getMaterial());
                sup.setQuantity(supplierOrder.getQuantity());
                sup.setOrderStatus(supplierOrder.getOrderStatus());
                supplierRepository.save(supplier);
                supplierOrder1 = sup;
            }
        }
        boolean inProgress = false;
        boolean rejected = false;
        for (SupplierOrder sup : supplier.getSupplierOrders()) {
            if (sup.getTagId().equals(supplierOrder.getTagId()) && sup.getOrderStatus().equals("in-progress")){
                inProgress = true;
            }
            if (sup.getTagId().equals(supplierOrder.getTagId()) && sup.getOrderStatus().equals("rejected")){
                rejected = true;
            }
        }
        if (!inProgress && rejected){
            //send Kafka message to update order status to rejected
            kafkaTemplate.send(TOPIC,supplierOrder.getTagId()+"-supplier_rejected");
            logger.info("sending supplier_rejected message on TOPIC: "+TOPIC);
        }
        else if (!inProgress){
            //send Kafka message to update order status to accepted
            kafkaTemplate.send(TOPIC,supplierOrder.getTagId()+"-supplier_accepted");
            logger.info("sending supplier_accepted message on TOPIC: "+TOPIC);
        }
        boolean allCompleted = true;
        for (SupplierOrder sup : supplier.getSupplierOrders()) {
            if (sup.getTagId().equals(supplierOrder.getTagId()) && !sup.getOrderStatus().equals("completed")){
                allCompleted = false;
            }
        }
        if (allCompleted && !(inProgress || rejected)){
            //send Kafka message to update order status to rejected
            kafkaTemplate.send(TOPIC,supplierOrder.getTagId()+"-supplier_completed");
            logger.info("sending supplier_completed message on TOPIC: "+TOPIC);
        }
        return supplierOrder1;
    }

    @Override
    public SupplierOrder getOrderById(String id) {
        for (SupplierOrder sup :
                supplierRepository.findById(id).orElse(null).getSupplierOrders()) {
            logger.info("inside getOrderById in SupplierServiceImpl");
            if (sup.getId().equals(id))
                return sup;
        }
        return null;
    }

    @Override
    public Supplier getSupplierById(String id) {
        return supplierRepository.findById(id).orElse(null);
    }

}
