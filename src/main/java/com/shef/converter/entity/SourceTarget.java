package com.shef.converter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceTarget {
    @JsonProperty("val")
    private Double val;


    // Getter Methods

    public Double getVal() {
        return val;
    }

    // Setter Methods

    public void setVal(Double val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "SourceTarget{" +
                "val=" + val +
                '}';
    }
}