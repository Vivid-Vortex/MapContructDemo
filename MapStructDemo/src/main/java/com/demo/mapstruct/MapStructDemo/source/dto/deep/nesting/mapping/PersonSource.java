package com.demo.mapstruct.MapStructDemo.source.dto.deep.nesting.mapping;

import lombok.Data;

@Data
public class PersonSource {
    private ContactSource contact;
}
