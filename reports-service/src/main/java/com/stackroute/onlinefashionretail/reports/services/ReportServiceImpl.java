package com.stackroute.onlinefashionretail.reports.services;

import com.stackroute.onlinefashionretail.reports.repository.ReportRepository;
import com.stackroute.onlinefashionretail.reports.domain.Reports;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    ReportRepository reportRepository;
    Reports savedReport;
    Reports report;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository)
    {
        logger.info("Inside reportServiceImpl in ReportServiceImpl");
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Reports> getAllReports() {
        logger.info("inside getAllReport in ReposrtServiceImpl");
        return reportRepository.findAll();
    }

    @Override
    public List designCount()
    {
        String c="0";
        logger.info("inside designCount in ReposrtServiceImpl");
        int designs=0;
        List list = new ArrayList();
        List<Reports> reports =reportRepository.findAll();
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
            logger.info("inside deleteUser in ReposrtServiceImpl");
            reportRepository.deleteAll();
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

}
