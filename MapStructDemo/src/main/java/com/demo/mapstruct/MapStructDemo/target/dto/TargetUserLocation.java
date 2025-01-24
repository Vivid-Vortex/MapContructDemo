package com.demo.mapstruct.MapStructDemo.target.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TargetUserLocation {
    private String fullName;
    private String contactEmail;
    private String mobile;
}
