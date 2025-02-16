package com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings;

import lombok.Data;

@Data
public class ChannelTarget {
    private MediumEnumTarget medium; // Can be Telephone, Email
    private String mediumDetail;
}
