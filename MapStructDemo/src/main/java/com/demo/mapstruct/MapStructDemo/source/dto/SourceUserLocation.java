package com.demo.mapstruct.MapStructDemo.source.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SourceUserLocation {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
