package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.UserDtoAbstract;
import com.demo.mapstruct.MapStructDemo.target.dto.UserEntityAbstract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AbstractUserMapper_using_abstract_methods {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name", expression = "java(formatName(dto.getFullName()))")
    abstract UserEntityAbstract mapToEntity(UserDtoAbstract dto);

    @Mapping(target = "fullName", expression = "java(formatName(entity.getName()))")
    abstract UserDtoAbstract mapToDto(UserEntityAbstract entity);

    String formatName(String name) {
        return name.toUpperCase();  // Example transformation
    }
}
