package com.shef.converter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
    @JsonProperty("SRC_TGT")
    private SourceTarget SourceTargetObject;


    // Getter Methods

    public SourceTarget getSourceTarget() {
        return SourceTargetObject;
    }

    // Setter Methods

    public void setSourceTarget(SourceTarget SourceTargetObject) {
        this.SourceTargetObject = SourceTargetObject;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "SourceTargetObject=" + SourceTargetObject +
                '}';
    }
}
