package com.demo.mapstruct.MapStructDemo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceDto;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetDto;
import com.demo.mapstruct.MapStructDemo.util.MappingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyMapperUsingExternalHelperClassImpl.class})
public class MyMapperUsingExternalHelperClassTest {

//    private final MyMapperUsingExternalHelperClass myMapper = MyMapperUsingExternalHelperClass.INSTANCE;
    MyMapperUsingExternalHelperClass myMapper;
    private MappingUtils mappingUtils;

    @BeforeEach
    void setup() {
        mappingUtils = new MappingUtils();
        myMapper = Mappers.getMapper(MyMapperUsingExternalHelperClass.class);
    }
    @Test
    void shouldMapSourceDtoToTargetDto() {
        // Given
        SourceDto source = new SourceDto();
        source.setName("hello");

        // When
        TargetDto target = myMapper.map(source);

        // Then
        assertThat(target).isNotNull();
        assertThat(target.getName()).isEqualTo("HELLO"); // Ensuring the transformation to uppercase
    }

    @Test
    void shouldHandleNullValues() {
        // Given
        SourceDto source = new SourceDto();
        source.setName(null);

        // When
        TargetDto target = myMapper.map(source);

        // Then
        assertThat(target).isNotNull();
        assertThat(target.getName()).isNull(); // Null should be preserved
    }

    @Test
    void shouldHandleEmptyString() {
        // Given
        SourceDto source = new SourceDto();
        source.setName("");

        // When
        TargetDto target = myMapper.map(source);

        // Then
        assertThat(target).isNotNull();
        assertThat(target.getName()).isEqualTo(""); // Empty string remains empty
    }
}
