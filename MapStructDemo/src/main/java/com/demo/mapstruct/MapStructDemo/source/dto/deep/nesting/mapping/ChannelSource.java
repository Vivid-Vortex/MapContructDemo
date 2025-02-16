package com.demo.mapstruct.MapStructDemo.source.dto.deep.nesting.mapping;

import lombok.Data;

@Data
public class ChannelSource {
    private MediumEnum medium; // Can be Telephone, Email
    private String mediumDetail;
}
