package com.demo.mapstruct.MapStructDemo.target.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TargetAddress {
    private String targetStreet;
    private String targetCity;
    private String targetState;
    private String targetZip;
    private String targetCountry;
}
