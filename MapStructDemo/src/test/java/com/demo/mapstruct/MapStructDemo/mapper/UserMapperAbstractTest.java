package com.demo.mapstruct.MapStructDemo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demo.mapstruct.MapStructDemo.source.dto.UserDtoAbstract;
import com.demo.mapstruct.MapStructDemo.target.dto.UserEntityAbstract;
import com.demo.mapstruct.MapStructDemo.util.UserUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

//@ExtendWith(MockitoExtension.class)
//@ContextConfiguration(classes = {UserMapperAbstract.class})

// TODO: Try enabling above annotation and check why it will not work
public class UserMapperAbstractTest {

    @InjectMocks
    private UserMapperAbstract_provide_own_impl mapper = new UserMapperAbstract_provide_own_impl() {}; // Anonymous class to allow injection

    @Mock
    private UserUtil userUtil;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // use when no using @ExtendWith(MockitoExtension.class) on test class
        Mockito.when(userUtil.formatName("John Doe")).thenReturn("JOHN DOE");
        Mockito.when(userUtil.formatName("Jane Doe")).thenReturn("JANE DOE");
    }

    @Test
    public void testToEntity() {
        UserDtoAbstract dto = new UserDtoAbstract();
        dto.setFullName("John Doe");
        dto.setAge(30);

        UserEntityAbstract entity = mapper.toEntity(dto);

        assertEquals("JOHN DOE", entity.getName());
        assertEquals(30, entity.getAge());
    }

    @Test
    public void testToDto() {
        UserEntityAbstract entity = new UserEntityAbstract();
        entity.setName("Jane Doe");
        entity.setAge(25);

        UserDtoAbstract dto = mapper.toDto(entity);

        assertEquals("JANE DOE", dto.getFullName());
        assertEquals(25, dto.getAge());
    }
}

