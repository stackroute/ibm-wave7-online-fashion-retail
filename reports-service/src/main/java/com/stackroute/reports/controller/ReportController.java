package com.stackroute.reports.controller;

import com.stackroute.reports.domain.Reports;
import com.stackroute.reports.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReportController {

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
            responseEntity = new ResponseEntity<List<Reports>>(reportService.getAllReports(), HttpStatus.OK);

        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("design/reports")
    public ResponseEntity<?> getReport() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<>(reportService.designCount(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("reports")
    public ResponseEntity<?> deleteTrack() {
        ResponseEntity responseEntity;
        try {
            reportService.deleteUser();
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
