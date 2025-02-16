package com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings;

import lombok.Data;

@Data
public class UserTarget {
    private PersonTarget person;
}
