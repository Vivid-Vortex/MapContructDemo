package com.demo.mapstruct.MapStructDemo.util;

import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public String formatName(String name) {
        return name.toUpperCase();  // Example transformation
    }
}

