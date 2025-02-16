package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceDto;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetDto;
import com.demo.mapstruct.MapStructDemo.util.MappingUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring", uses = MappingUtils.class)
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = MappingUtils.class)
public interface MyMapperUsingExternalHelperClass {

    MyMapperUsingExternalHelperClass INSTANCE = Mappers.getMapper(MyMapperUsingExternalHelperClass.class);

    @Mapping(source = "name", target = "name", qualifiedByName = "convertToUpperCase")
    TargetDto map(SourceDto source);
}


