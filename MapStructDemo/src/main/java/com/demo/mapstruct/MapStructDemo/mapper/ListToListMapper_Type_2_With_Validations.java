package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_2;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_2;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ListToListMapper_Type_2_With_Validations {

    @Mapping(source = "sourcePerson.addresses", target = "targetPerson.addresses")
    TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);

    // Map individual SourceAddress to TargetAddress with null/empty checks for each field
    @Mapping(source = "sourceStreet", target = "targetStreet", qualifiedByName = "validate")
    @Mapping(source = "sourceCity", target = "targetCity", qualifiedByName = "validate")
    @Mapping(source = "sourceState", target = "targetState", qualifiedByName = "validate")
    @Mapping(source = "sourceZip", target = "targetZip", qualifiedByName = "validate")
    @Mapping(source = "sourceCountry", target = "targetCountry", qualifiedByName = "validate")
    TargetAddress sourceAddressToTargetAddress(SourceAddress sourceAddress);

    // Default method to handle empty addresses list in SourceList
    @Named("mapAddressList")
    default List<TargetAddress> mapAddressList(List<SourceAddress> sourceAddresses) {
        if (sourceAddresses == null || sourceAddresses.isEmpty()) {
            // If the list is null or empty, return an empty list or handle accordingly
            return Collections.emptyList(); // You could also return a list with default TargetAddress or null if desired
        }

        // Map each SourceAddress to TargetAddress if the list is not empty
        List<TargetAddress> targetAddresses = new ArrayList<>();
        for (SourceAddress sourceAddress : sourceAddresses) {
            targetAddresses.add(sourceAddressToTargetAddress(sourceAddress));
        }
        return targetAddresses;
    }

    /**
     * Generic method to validate and return default values for different types.
     * Please note that you have to use qualifiedByName sourceAddressToTargetAddress for each field getting mapped. This is in contract to the above approach.
     */

    @Named("validate")
    default <T> T validate_1(T value) { // This is to show that method name doesn't matter. It's getting qualified by beanName which yo specified with qualifiedByName and @Named("validate")
        // Handle String types
        if (value instanceof String) {
            String stringValue = (String) value;
            if (stringValue == null || stringValue.trim().isEmpty()) {
                return (T) "Unknown"; // Return "Unknown" for empty or null strings
            }
            return value; // Return original string if it's not empty
        }

        // Handle Integer types (return default value if null or 0)
        if (value instanceof Integer) {
            Integer intValue = (Integer) value;
            if (intValue == null || intValue == 0) {
                return (T) Integer.valueOf(-1); // Default to -1 for null or zero integers
            }
            return value; // Return original integer if valid
        }

        // Handle Long types (return default value if null or 0)
        if (value instanceof Long) {
            Long longValue = (Long) value;
            if (longValue == null || longValue == 0L) {
                return (T) Long.valueOf(-1); // Default to -1 for null or zero longs
            }
            return value; // Return original long if valid
        }

        // Handle Boolean types (return default value if null or false)
        if (value instanceof Boolean) {
            Boolean boolValue = (Boolean) value;
            if (boolValue == null || !boolValue) {
                return (T) Boolean.TRUE; // Default to TRUE if null or false
            }
            return value; // Return original boolean if valid
        }

        // Handle Double types (return default value if null or 0.0)
        if (value instanceof Double) {
            Double doubleValue = (Double) value;
            if (doubleValue == null || doubleValue == 0.0) {
                return (T) Double.valueOf(-1.0); // Default to -1.0 for null or zero doubles
            }
            return value; // Return original double if valid
        }

        // Handle List types (return empty list if null or empty)
        if (value instanceof List) {
            List<?> listValue = (List<?>) value;
            if (listValue == null || listValue.isEmpty()) {
                return (T) Collections.emptyList(); // Return an empty list if null or empty
            }
            return value; // Return original list if it's not empty
        }

        // Handle other types (return value as is for unsupported types)
        return value; // Return value as is for unsupported types
    }

    /**
     * Generic method to validate and return default values for different types using <mark>switch</> statement
     * You can use swith in place of if contion for vlaidations
     */
    ////////////////////////// ALTERNATIVE IMPLEMENTATION  of abvoe validate_1 method//////////////////////////
//    @Named("checkNullAndEmpty")
//    default <T> T mapAddress(T value) {
//        // Using switch with type patterns in Java 16 and later
//        switch (value) {
//            case String stringValue -> {
//                if (stringValue == null || stringValue.trim().isEmpty()) {
//                    return (T) "Unknown"; // Return "Unknown" for empty or null strings
//                }
//                return value; // Return original string if it's not empty
//            }
//            case Integer intValue -> {
//                if (intValue == null || intValue == 0) {
//                    return (T) Integer.valueOf(-1); // Default to -1 for null or zero integers
//                }
//                return value; // Return original integer if valid
//            }
//            case Long longValue -> {
//                if (longValue == null || longValue == 0L) {
//                    return (T) Long.valueOf(-1); // Default to -1 for null or zero longs
//                }
//                return value; // Return original long if valid
//            }
//            case Boolean boolValue -> {
//                if (boolValue == null || !boolValue) {
//                    return (T) Boolean.TRUE; // Default to TRUE if null or false
//                }
//                return value; // Return original boolean if valid
//            }
//            case Double doubleValue -> {
//                if (doubleValue == null || doubleValue == 0.0) {
//                    return (T) Double.valueOf(-1.0); // Default to -1.0 for null or zero doubles
//                }
//                return value; // Return original double if valid
//            }
//            case List<?> listValue -> {
//                if (listValue == null || listValue.isEmpty()) {
//                    return (T) Collections.emptyList(); // Return an empty list if null or empty
//                }
//                return value; // Return original list if it's not empty
//            }
//            default -> {
//                // Handle other types (return value as is for unsupported types)
//                return value; // Return value as is for unsupported types
//            }
//        }
//    }

    ////////////////////////// ALTERNATIVE IMPLEMENTATION  //////////////////////////

    // Explicitly map SourceList to TargetList with null and empty checks for addresses list
//    @Mapping(source = "sourcePerson.addresses", target = "targetPerson.addresses")
//    TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);
//
//    // Map individual SourceAddress to TargetAddress with null/empty checks for each field
//    @Mapping(source = "sourceStreet", target = "targetStreet")
//    @Mapping(source = "sourceCity", target = "targetCity")
//    @Mapping(source = "sourceState", target = "targetState")
//    @Mapping(source = "sourceZip", target = "targetZip")
//    @Mapping(source = "sourceCountry", target = "targetCountry")
//    TargetAddress sourceAddressToTargetAddress(SourceAddress sourceAddress);

//    @Named("mapAddressList")
//    default List<TargetAddress> mapAddressList(List<SourceAddress> sourceAddresses) {
//        if (sourceAddresses == null || sourceAddresses.isEmpty()) {
//            // If the list is null or empty, return an empty list or handle accordingly
//            return Collections.emptyList(); // You could also return a list with default TargetAddress if desired
//        }
//
//        // Map each SourceAddress to TargetAddress if the list is not empty
//        List<TargetAddress> targetAddresses = new ArrayList<>();
//        for (SourceAddress sourceAddress : sourceAddresses) {
//            // Validate fields inside the SourceAddress before mapping
//            String street = validateString(sourceAddress.getSourceStreet());
//            String city = validateString(sourceAddress.getSourceCity());
//            String state = validateString(sourceAddress.getSourceState());
//            String zip = validateString(sourceAddress.getSourceZip());
//            String country = validateString(sourceAddress.getSourceCountry());
//
//            // Create a new TargetAddress with validated fields
//            TargetAddress targetAddress = new TargetAddress();
//            targetAddress.setTargetStreet(street);
//            targetAddress.setTargetCity(city);
//            targetAddress.setTargetState(state);
//            targetAddress.setTargetZip(zip);
//            targetAddress.setTargetCountry(country);
//
//            // Add the mapped TargetAddress to the list
//            targetAddresses.add(targetAddress);
//        }
//        return targetAddresses;
//    }


//    default String validateString(String value) {
//        // Check if the value is null or empty and return default value accordingly
//        if (value == null || value.trim().isEmpty()) {
//            return "Unknown";
//        }
//        return value;
//    }
}
