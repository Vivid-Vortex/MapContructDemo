package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_1;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_1;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ListToListMapper_Type_1 {

    ListToListMapper_Type_1 INSTANCE = Mappers.getMapper(ListToListMapper_Type_1.class);

    // Explicitly map SourceList to TargetList
    @Mapping(source = "addresses", target = "addresses")
    TargetList_Type_1 sourceListToTargetList(SourceList_Type_1 sourceList);


    // Map individual SourceAddress to TargetAddress
    @Mapping(source = "sourceStreet", target = "targetStreet")
    @Mapping(source = "sourceCity", target = "targetCity")
    @Mapping(source = "sourceState", target = "targetState")
    @Mapping(source = "sourceZip", target = "targetZip")
    @Mapping(source = "sourceCountry", target = "targetCountry")
    TargetAddress sourceAddressToTargetAddress(SourceAddress sourceAddress);

}
