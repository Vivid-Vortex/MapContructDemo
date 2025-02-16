package com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings;

import lombok.Data;

import java.util.List;

@Data
public class ContactTarget {
    private List<CommunicationChannelTarget> communicationChannel;
}
