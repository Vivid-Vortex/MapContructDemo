package com.demo.mapstruct.MapStructDemo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.demo.mapstruct.MapStructDemo.source.dto.UserDtoAbstract;
import com.demo.mapstruct.MapStructDemo.target.dto.UserEntityAbstract;
import com.demo.mapstruct.MapStructDemo.util.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserMapperAbstract_provide_own_implTest {

    @Mock
    private UserUtil userUtil; // Mock the dependency

    @InjectMocks
    private UserMapperAbstract_provide_own_impl userMapper = new UserMapperAbstract_provide_own_impl() {}; // Provide anonymous implementation

    @BeforeEach
    void setUp() {
        lenient().when(userUtil.formatName("John Doe")).thenReturn("JOHN DOE");
        lenient().when(userUtil.formatName("Jane Doe")).thenReturn("JANE DOE");
    }

    @Test
    void testToEntity() {
        // Arrange
        UserDtoAbstract dto = new UserDtoAbstract();
        dto.setFullName("John Doe");
        dto.setAge(25);

        // Act
        UserEntityAbstract entity = userMapper.toEntity(dto);

        // Assert
        assertNotNull(entity);
        assertEquals("JOHN DOE", entity.getName()); // Ensuring formatName is applied
        assertEquals(25, entity.getAge());
        verify(userUtil).formatName("John Doe"); // Verify interaction with userUtil
    }

    @Test
    void testToDto() {
        // Arrange
        UserEntityAbstract entity = new UserEntityAbstract();
        entity.setName("Jane Doe");
        entity.setAge(30);

        // Act
        UserDtoAbstract dto = userMapper.toDto(entity);

        // Assert
        assertNotNull(dto);
        assertEquals("JANE DOE", dto.getFullName()); // Ensuring formatName is applied
        assertEquals(30, dto.getAge());
        verify(userUtil).formatName("Jane Doe"); // Verify interaction with userUtil
    }
}
