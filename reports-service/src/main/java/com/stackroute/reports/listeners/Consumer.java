package com.stackroute.reports.listeners;

import com.stackroute.reports.domain.Reports;
import com.stackroute.reports.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    ReportRepository reportRepository;

    @KafkaListener(topics="Kafka_Example1",groupId = "group_id")
    public void consume(Reports reports) throws IOException {
        System.out.println("Inside Designer");
        System.out.println(reports);
        Reports obj=new Reports();
        obj.setId(reports.getId());
        System.out.println(obj.getId());
        reportRepository.save(obj);
    }
    @KafkaListener(topics="PRODUCTS_BOUGHT",groupId = "group_id")
    public void consumecustomer(Reports reports) throws IOException {
        System.out.println("Inside Customer");
        System.out.println(reports);
        Reports obj=new Reports();
        obj.setCount(reports.getCount());
        reportRepository.save(obj);
    }
}
