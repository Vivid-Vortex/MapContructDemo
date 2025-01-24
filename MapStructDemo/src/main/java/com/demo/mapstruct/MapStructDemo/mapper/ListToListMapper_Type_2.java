package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_1;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_2;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_1;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * In this simple List to List mapping you can see see
 * all you need to do is to create a simple one-to-one mapping for the actual object inside the list seperately.
 * And simply specify the source and target list in the main mapper method.
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ListToListMapper_Type_2 {

    ListToListMapper_Type_2 INSTANCE = Mappers.getMapper(ListToListMapper_Type_2.class);

    // Explicitly map SourceList to TargetList
    @Mapping(source = "sourcePerson.addresses", target = "targetPerson.addresses")
    TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);


    // Map individual SourceAddress to TargetAddress
    @Mapping(source = "sourceStreet", target = "targetStreet")
    @Mapping(source = "sourceCity", target = "targetCity")
    @Mapping(source = "sourceState", target = "targetState")
    @Mapping(source = "sourceZip", target = "targetZip")
    @Mapping(source = "sourceCountry", target = "targetCountry")
    TargetAddress sourceAddressToTargetAddress(SourceAddress sourceAddress);

}
