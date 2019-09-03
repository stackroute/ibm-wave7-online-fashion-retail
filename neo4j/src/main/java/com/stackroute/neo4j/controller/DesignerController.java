package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.Designer;
import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.entity.Order;
import com.stackroute.neo4j.entity.Supplier;
import com.stackroute.neo4j.service.DesignerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class DesignerController {
    private  DesignerService designerService;

    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }


    @PostMapping("/designer")
    public ResponseEntity<Designer> createDesigner(@RequestBody Designer designer) {
        return new ResponseEntity<Designer>(designerService.create(designer), HttpStatus.OK);
    }
    @DeleteMapping("designer/{id}")
    public void deleteDesigner(@PathVariable long id){
       designerService.delete(id);
    }
    @GetMapping("/designer")
    public ResponseEntity<?> getDesigners()
    {
        return new ResponseEntity<Iterable<Designer>>(designerService.getAllDesigners(),HttpStatus.OK);
    }

    @GetMapping("/match/{name}")
    public String match3(@PathVariable("name") String name)
    {
        List<Order> orderList= designerService.match3(name);
        String result="";
        for(int i=0; i<orderList.size(); i++) {
        result=orderList.get(i).getManufacturer().toString()+"   "+orderList.get(i).getMapping().getSupplier();
            System.out.println(orderList.get(i).getManufacturer());
            System.out.println(orderList.get(i).getMapping().getSupplier());
        }

        return result;
    }
    @PutMapping("/designer")
    public ResponseEntity<?> updateDesigner(@RequestBody Designer designer)
    {
        return new ResponseEntity<Designer>(designerService.update(designer),HttpStatus.OK);
    }
    @GetMapping("match1")
    public ResponseEntity<List<Supplier>> match1()
    {
        return new ResponseEntity<List<Supplier>>(designerService.match1(),HttpStatus.OK);
    }
    @GetMapping("match2")
    public ResponseEntity<List<Manufacturer>> match2()
    {
        return new ResponseEntity<List<Manufacturer>>(designerService.match2(),HttpStatus.OK);
    }
}

