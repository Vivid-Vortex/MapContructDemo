package com.demo.mapstruct.MapStructDemo.source.dto.deep.nesting.mapping;

import lombok.Data;

import java.util.List;

@Data
public class ContactSource {
    private List<CommunicationChannelSource> communicationChannel;
}
