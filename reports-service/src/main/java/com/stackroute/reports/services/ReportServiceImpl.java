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

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository)
    {
        this.reportRepository = reportRepository;
    }


    @Override
    public List<Reports> getAllReports() {
        List<Reports> reports =reportRepository.findAll();
        return reports;
    }

    @Override
    public List designCount()
    {
        List list = new ArrayList();
        List<Reports> reports =reportRepository.findAll();
        System.out.println(reports.size());
        list.add(reports.size());
        return list;
    }
    @Override
    public boolean deleteUser(){
        // Optional<User> user1 = userRepository.findById(id);

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
