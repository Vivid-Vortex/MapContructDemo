package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceUserLocation;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetUserLocation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "source", target = "fullName", qualifiedByName = "mapFullName")
    @Mapping(source = "email", target = "contactEmail")
    @Mapping(source = "phoneNumber", target = "mobile")
    TargetUserLocation sourceToTarget(SourceUserLocation source);

    @Named("mapFullName")
    default String mapFullName(SourceUserLocation source) {
        if (source.getFirstName() == null || source.getLastName() == null) {
            return null; // Return null if either firstName or lastName is null
        }
        return source.getFirstName() + " " + source.getLastName();
    }
}
