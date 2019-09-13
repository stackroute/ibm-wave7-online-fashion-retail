package com.stackroute.onlinefashionretail.reports.services;

import com.stackroute.onlinefashionretail.reports.domain.Reports;

import java.util.List;

public interface ReportService {

//    public Reports saveReport(Reports reports);

    public List<Reports> getAllReports();

    public List designCount();

//    public List report();

    public boolean deleteUser() ;


}
