package com.stackroute.onlinefashionretail.reports.controller;

import com.stackroute.onlinefashionretail.reports.domain.Reports;
import com.stackroute.onlinefashionretail.reports.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1")
public class ReportController {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    ReportService reportService;
    Reports savedReports;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @GetMapping("reports")
    public ResponseEntity<?> getAllReports() {
        ResponseEntity responseEntity;
        try {
            logger.info("inside getAllReports try block in getAllReport");
            responseEntity = new ResponseEntity<List<Reports>>(reportService.getAllReports(), HttpStatus.OK);

        } catch (Exception exception) {
            logger.info("inside getAllReports catch block in getAllReport");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("design/reports")
    public ResponseEntity<?> getReport() {
        ResponseEntity responseEntity;
        try {
            logger.info("inside getReports try block in getAllReport");
            responseEntity = new ResponseEntity<>(reportService.designCount(), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("inside getReports catch block in getAllReport");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("reports")
    public ResponseEntity<?> deleteReport() {
        ResponseEntity responseEntity;
        try {
            logger.info("inside deleteReports try block in getAllReport");
            reportService.deleteUser();
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("inside deleteReports catch block in getAllReport");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
