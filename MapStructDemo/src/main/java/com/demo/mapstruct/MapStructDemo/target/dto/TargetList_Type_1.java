package com.demo.mapstruct.MapStructDemo.target.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class TargetList_Type_1 {
    private List<TargetAddress> addresses;
}
