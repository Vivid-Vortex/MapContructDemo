package com.demo.mapstruct.MapStructDemo.source.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class SourcePerson {
    private List<SourceAddress> addresses;
}
