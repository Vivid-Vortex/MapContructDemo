package com.demo.mapstruct.MapStructDemo.source.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SourceAddress {
    private String sourceStreet;
    private String sourceCity;
    private String sourceState;
    private String sourceZip;
    private String sourceCountry;
}
