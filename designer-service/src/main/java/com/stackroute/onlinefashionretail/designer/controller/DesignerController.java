package com.stackroute.onlinefashionretail.designer.controller;

import com.stackroute.onlinefashionretail.designer.model.Designer;
import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;
import com.stackroute.onlinefashionretail.designer.service.DesignerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v1")
public class DesignerController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    DesignerService designerService;
    Designer designer = new Designer();

    @Autowired
    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }


    //Post mapping to save the user details
    @PostMapping("designer")
    public ResponseEntity<?> saveDesigner(@RequestBody Designer designer) {
        ResponseEntity responseEntity;
        try {
            designerService.saveDesigner(designer);
            logger.info("Entered into saveDesiner in DesignerController");
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("designer/{id}")
    public ResponseEntity<?> getDesigner(@PathVariable String id) {
        ResponseEntity responseEntity;
        logger.info("Entered into getDesignersById method in DesignerController");

        try {

            responseEntity = new ResponseEntity<>(designerService.getDesigner(id), HttpStatus.OK);
            logger.info("got designer : "+designerService.getDesigner(id));
        } catch (Exception exception) {
            logger.info("Entered into getDesignersById exception: "+exception.toString());
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("designer")
    public ResponseEntity<?> getAllDesigners() {
        ResponseEntity responseEntity;
        logger.info("Entered into getAllDesigners method in DesignerController");
        try {
            responseEntity = new ResponseEntity<List<Designer>>(designerService.getAllDesigners(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("designer/{id}")
    public ResponseEntity<?> deleteDesigner(@PathVariable String id) {
        ResponseEntity responseEntity;
        logger.info("Entered into deleteDesigner method in DesignerController");
        try {
            designerService.deleteDesigner(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("designer/{id}")
    public ResponseEntity<?> updateDesigner(@RequestBody Designer designer, @PathVariable String id) {
        ResponseEntity responseEntity;
        logger.info("Entered into updateDesigner method in DesignerController");
        try {
            designerService.updateDesigner(designer,id);
            responseEntity = new ResponseEntity<>(designerService.getDesigner(id), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
