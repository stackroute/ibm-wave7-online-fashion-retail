package com.stackroute.reports.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reports {

@JsonProperty("id")
    private String id;

@JsonProperty("count")
    private String count;

    public String getCount() { return count; }

    public void setCount(String count) { this.count = count; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reports() { }
    public Reports(String id, String count) {
        this.id = id;
        this.count = count;
    }
}
