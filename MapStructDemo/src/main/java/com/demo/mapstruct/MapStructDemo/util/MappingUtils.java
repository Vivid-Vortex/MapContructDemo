package com.demo.mapstruct.MapStructDemo.util;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MappingUtils {

    private static UserUtil userUtil;

    @Autowired
    public static void setUserUtil(UserUtil userUtil) {
        MappingUtils.userUtil = userUtil;
    }

    @Named("convertToUpperCase")
    public static String convertToUpperCase(String input) {
        return input != null ? userUtil.formatName(input) : null;
    }
}
