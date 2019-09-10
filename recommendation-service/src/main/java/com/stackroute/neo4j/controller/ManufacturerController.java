package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ManufacturerController {
    private ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }


    @PostMapping("/manufacturer")
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
        return new ResponseEntity<Manufacturer>(manufacturerService.create(manufacturer), HttpStatus.OK);
    }
    @DeleteMapping("manufacturer/{id}")
    public void deleteManufacturer(@PathVariable long id){
        manufacturerService.delete(id);
    }
    @GetMapping("/manufacturer")
    public ResponseEntity<?> getManufacturer()
    {
        return new ResponseEntity<Iterable<Manufacturer>>(manufacturerService.getAllManufacturers(),HttpStatus.OK);
    }
    @PutMapping("/manufacturer")
    public ResponseEntity<?> updateManufacturer(@RequestBody Manufacturer manufacturer)
    {
        return new ResponseEntity<Manufacturer>(manufacturerService.updateManufacturer(manufacturer),HttpStatus.OK);
    }
}
