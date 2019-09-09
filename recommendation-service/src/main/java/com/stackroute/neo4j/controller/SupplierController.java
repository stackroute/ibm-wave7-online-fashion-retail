package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.Supplier;
import com.stackroute.neo4j.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SupplierController
{
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return new ResponseEntity<Supplier>(supplierService.create(supplier), HttpStatus.OK);
    }
    @DeleteMapping("supplier/{id}")
    public void deleteSupplier(@PathVariable long id){
        supplierService.delete(id);
    }
    @GetMapping("/supplier")
    public ResponseEntity<?> getSupplier()
    {
        return new ResponseEntity<Iterable<Supplier>>(supplierService.getAllSuppliers(),HttpStatus.OK);
    }
    @PutMapping("/supplier")
    public ResponseEntity<?> updateSupplier(@RequestBody Supplier supplier)
    {
        return new ResponseEntity<Supplier>(supplierService.updateSupplier(supplier),HttpStatus.OK);
    }
}
