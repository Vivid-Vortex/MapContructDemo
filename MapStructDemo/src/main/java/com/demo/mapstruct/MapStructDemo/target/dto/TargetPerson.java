package com.demo.mapstruct.MapStructDemo.target.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class TargetPerson {
    private List<TargetAddress> addresses;
}
