package com.demo.mapstruct.MapStructDemo.target.dto;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class TargetUserLocation {
    private String fullName;
    private String contactEmail;
    private String mobile;
    private List<TargetAddress> addresses;
}
