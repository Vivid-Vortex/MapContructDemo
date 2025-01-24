package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SimpleSource;
import com.demo.mapstruct.MapStructDemo.target.dto.SimpleDestination;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSourceDestinationMapperTest {

    private final SimpleSourceDestinationMapper mapper = Mappers.getMapper(SimpleSourceDestinationMapper.class);

    @Test
    public void testSourceToDestination() {
        // Arrange
        SimpleSource source = new SimpleSource();
        source.setName("Amit");
        source.setDescription("Source Description");

        // Act
        SimpleDestination destination = mapper.sourceToDestination(source);

        System.out.println("Name :" +destination.getName());
        System.out.println("Description :" +destination.getDescription());

        // Assert
        assertEquals(source.getName(), destination.getName());
        assertEquals(source.getDescription(), destination.getDescription());
    }

    @Test
    public void testDestinationToSource() {
        // Arrange
        SimpleDestination destination = new SimpleDestination();
        destination.setName("Amit");
        destination.setDescription("Destination Description");

        System.out.println("Name :" +destination.getName());
        System.out.println("Description :" +destination.getDescription());

        // Act
        SimpleSource source = mapper.destinationToSource(destination);

        // Assert
        assertEquals(destination.getName(), source.getName());
        assertEquals(destination.getDescription(), source.getDescription());
    }
}
