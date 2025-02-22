package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.DocumentationLink;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_2;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_2;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In this simple List to List mapping you can see see
 * all you need to do is to create a simple one-to-one mapping for the actual object inside the list seperately.
 * And simply specify the source and target list in the main mapper method.
 */


/**
 * For detailed documentation, see:
 * <a href="docs/expression.md">/doc/expression.md</a>
 */
@DocumentationLink("https://github.com/Vivid-Vortex/MapContructDemo/blob/main/MapStructDemo/doc/expression.md")
// Below documentation link points to Answer section in expression.md. It is to demonstrate that you can link to a specific section in the documentation.
//@DocumentationLink("https://github.com/Vivid-Vortex/MapContructDemo/blob/main/MapStructDemo/doc/expression.md#Answer")
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ListToListMapper_Type_3 {

    // Use expression for mapping SourceList to TargetList
    @Mapping(expression = "java(sourceList_Type_2.getSourcePerson() != null &&" +
            "sourceList_Type_2.getSourcePerson().getAddresses() != null ?" +
            "mapSourceAddresses(sourceList_Type_2.getSourcePerson().getAddresses()) : java.util.Collections.emptyList())", // You can also return null in place of java.util.Collections.emptyList()
            target = "targetPerson.addresses")
    @BeanMapping(ignoreByDefault = true) // Ignore all unmapped properties by default and only map those getting explicitly mapped here.
    TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);

    // Use expression for individual SourceAddress to TargetAddress mapping
    @Mapping(expression = "java(checkString(sourceAddress.getSourceStreet()))", target = "targetStreet")
    @Mapping(expression = "java(checkString(sourceAddress.getSourceCity()))", target = "targetCity")
    @Mapping(expression = "java(checkString(sourceAddress.getSourceState()))", target = "targetState")
    @Mapping(expression = "java(checkString(sourceAddress.getSourceZip()))", target = "targetZip")
    @Mapping(expression = "java(checkString(sourceAddress.getSourceCountry()))", target = "targetCountry")
    TargetAddress sourceAddressToTargetAddress(SourceAddress sourceAddress);

    // Default method for mapping list of SourceAddress to TargetAddress
    default List<TargetAddress> mapSourceAddresses(List<SourceAddress> sourceAddresses) {
        if (sourceAddresses == null || sourceAddresses.isEmpty()) {
            return Collections.emptyList();
        }
        return sourceAddresses.stream()
                .map(this::sourceAddressToTargetAddress)
                .toList();
    }

    // Separate method to check for null or empty strings
    default String checkString(String value) {
        return (value == null || value.trim().isEmpty()) ? "Unknown" : value;
    }
}
