package com.stackroute.onlinefashionretail.reports.listeners;

import com.stackroute.onlinefashionretail.reports.repository.ReportRepository;
import com.stackroute.onlinefashionretail.reports.domain.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    ReportRepository reportRepository;
    Reports obj = new Reports();
    int designerCount=0;

    @KafkaListener(topics = "Kafka_Example1", groupId = "group_id")
    public void consume(String reports) throws IOException {
        System.out.println("Inside Designer");
        System.out.println(reports);
        obj.setId(reports);
//        obj.setCount(null);
        System.out.println("id is:" + obj.getId()+"count is : "+obj.getCount());
      reportRepository.save(obj);
    }

    @KafkaListener(topics = "PRODUCTS_BOUGHT", groupId = "group")
    public void consumecustomer(String count) throws IOException {
        System.out.println("Inside Customer");
        System.out.println(count);
        obj.setCount(count);
        obj.setId(null);
        System.out.println(obj.getCount() + "------" + obj.getId());
        reportRepository.save(obj);
    }
//    @KafkaListener(topics="Kafka_Example1",groupId = "group")
//    public void consume(String id) throws IOException {
//        System.out.println("Inside Designer");
//        System.out.println(id);
//        reports.setCount(id);
//        reportRepository.save(reports);
//    }
}
