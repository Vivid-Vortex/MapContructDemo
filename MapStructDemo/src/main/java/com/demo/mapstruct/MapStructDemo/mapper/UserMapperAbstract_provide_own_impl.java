package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.UserDtoAbstract;
import com.demo.mapstruct.MapStructDemo.target.dto.UserEntityAbstract;
import com.demo.mapstruct.MapStructDemo.util.UserUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UserMapperAbstract_provide_own_impl {

    @Autowired
    protected UserUtil userUtil;

    public static final UserMapperAbstract_provide_own_impl INSTANCE = Mappers.getMapper(UserMapperAbstract_provide_own_impl.class);

    @Mapping(source = "fullName", target = "name")
    public UserEntityAbstract toEntity(UserDtoAbstract dto) {
        UserEntityAbstract entity = new UserEntityAbstract();
        entity.setName(userUtil.formatName(dto.getFullName()));  // Using Util class
        entity.setAge(dto.getAge());
        return entity;
    }

    @Mapping(source = "name", target = "fullName")
    public UserDtoAbstract toDto(UserEntityAbstract entity) {
        UserDtoAbstract dto = new UserDtoAbstract();
        dto.setFullName(userUtil.formatName(entity.getName()));  // Using Util class
        dto.setAge(entity.getAge());
        return dto;
    }
}
