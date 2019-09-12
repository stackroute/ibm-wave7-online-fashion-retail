package com.stackroute.reports.services;

import com.stackroute.reports.domain.Reports;
import com.stackroute.reports.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    ReportRepository reportRepository;
    Reports savedReport;
    Reports report;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository)
    {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Reports> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List designCount()
    {
        String c="0";
        int designs=0;
        List list = new ArrayList();
        List<Reports> reports =reportRepository.findAll();
//        System.out.println("report size");
//        System.out.println(reports.size());
//        if(report.getCount()==null) {
//            list.add(reports.size());
//        }
        for( Reports report : reports)
        {
            if(report.getCount()==null)
                designs++;

            if(report.getCount()== null)
                continue;
                c = (report.getCount());


        }
        list.add(designs);
        list.add(Integer.parseInt(c));
        System.out.println(list);
        return list;
    }

    @Override
    public boolean deleteUser(){
        try {
            reportRepository.deleteAll();
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

}
