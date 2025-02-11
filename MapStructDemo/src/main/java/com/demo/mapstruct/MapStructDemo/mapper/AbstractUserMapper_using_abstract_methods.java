package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.UserDtoAbstract;
import com.demo.mapstruct.MapStructDemo.target.dto.UserEntityAbstract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Abstract class with abstract methods for mapping between UserDtoAbstract and UserEntityAbstract.
 * The abstract methods are implemented in the generated implementation class by MapStruct.
 * This abstract class is also using an external method which would normally be part of external method. In thact you would need to
 * provide auto-wiring for the external method. So the better and easier way is to use expression.
 */
// You can use interfaces as well instead of abstract classes or methods. It will work the same way. All you need to do is to remove abstract keywords from methods.
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
