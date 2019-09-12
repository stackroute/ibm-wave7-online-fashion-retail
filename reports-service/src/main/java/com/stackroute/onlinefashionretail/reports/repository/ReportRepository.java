package com.stackroute.onlinefashionretail.reports.repository;

import com.stackroute.onlinefashionretail.reports.domain.Reports;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<Reports, String> {
}
