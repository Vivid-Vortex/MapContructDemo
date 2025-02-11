package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.UserDtoAbstract;
import com.demo.mapstruct.MapStructDemo.target.dto.UserEntityAbstract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbstractUserMapper_using_abstract_methodsTest {

    private AbstractUserMapper_using_abstract_methods userMapper;

    @BeforeEach
    void setUp() {
        userMapper = Mappers.getMapper(AbstractUserMapper_using_abstract_methods.class);
    }

    @Test
    void testMapToEntity() {
        // Arrange
        UserDtoAbstract dto = new UserDtoAbstract();
        dto.setFullName("John Doe");

        // Act
        UserEntityAbstract entity = userMapper.mapToEntity(dto);

        // Assert
        assertNotNull(entity);
        assertEquals("JOHN DOE", entity.getName()); // Since formatName() converts to uppercase
    }

    @Test
    void testMapToDto() {
        // Arrange
        UserEntityAbstract entity = new UserEntityAbstract();
        entity.setName("Jane Doe");

        // Act
        UserDtoAbstract dto = userMapper.mapToDto(entity);

        // Assert
        assertNotNull(dto);
        assertEquals("JANE DOE", dto.getFullName()); // Since formatName() converts to uppercase
    }
}
