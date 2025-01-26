package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceUserLocation;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetUserLocation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

/**
 * if any source is null, then explore:
 *
 * Use either of below 2 options beside target:
 * 1. if source is null, then you can give default value to replace null
 * 2. nullValueCheckStrategy = NulVAlueCheckSttrategy.ALWAYS
 *
 * if any source is empty, then explore:
 *
 * @BeanMapping(ignoreByDefault = true) // Ignore all unmapped properties by default and only map those getting explicitly mapped here.
 *
 * If if you have specified @BeanMapping annotation at the parent mapping level, then you don't need to do it again for child mapping.
 * check ListToListMapper_Type_3.java for example. Here @BeanMapping is specified at parent level on sourceListToTargetList method. Then all other linked child
 * method need not do it again.
 */
public interface NullEmptySourceCheckStrategy {
    @Mapping(source = "phoneNumber", target = "mobile", defaultValue = "1234567890") // If phoneNumber is null, then default value will be used.
    @Mapping(source = "email", target = "contactEmail", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @BeanMapping(ignoreByDefault = true) // Ignore all unmapped properties by default and only map those getting explicitly mapped here.
    TargetUserLocation sourceToTarget(SourceUserLocation source);
}
