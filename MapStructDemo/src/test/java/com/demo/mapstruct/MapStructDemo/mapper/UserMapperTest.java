package com.demo.mapstruct.MapStructDemo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceUserLocation;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetUserLocation;
import org.junit.jupiter.api.Test;

public class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl(); // Use the generated implementation

    @Test
    public void testSourceToTargetMapping() {
        // Create and populate SourceUserLocation object
        SourceUserLocation source = new SourceUserLocation();
        source.setFirstName("John");
        source.setLastName("Doe");
        source.setEmail("john.doe@example.com");
        source.setPhoneNumber("1234567890");

        // Call the mapper method
        TargetUserLocation target = userMapper.sourceToTarget(source);

        System.out.println("Full name :" +target.getFullName());
        System.out.println("Email :" +target.getContactEmail());
        System.out.println("Phone number :" +target.getMobile());
        // Assert that all fields are mapped correctly
        assertEquals("John Doe", target.getFullName(), "FullName mapping failed!");
        assertEquals("john.doe@example.com", target.getContactEmail(), "ContactEmail mapping failed!");
        assertEquals("1234567890", target.getMobile(), "Mobile mapping failed!");
    }

    @Test
    public void testNullSource() {
        // Pass a null source object
        TargetUserLocation target = userMapper.sourceToTarget(null);

        // Assert that the target object is null
        assertNull(target, "Target should be null when source is null!");
    }

    @Test
    public void testNullFieldsInSource() {
        // Create a source object with null fields
        SourceUserLocation source = new SourceUserLocation();
        source.setFirstName(null);
        source.setLastName(null);
        source.setEmail(null);
        source.setPhoneNumber(null);

        // Call the mapper method
        TargetUserLocation target = userMapper.sourceToTarget(source);

        System.out.println("Full name :" +target.getFullName());
        System.out.println("Email :" +target.getContactEmail());
        System.out.println("Phone number :" +target.getMobile());

        // Assert that fields are handled properly when null
        assertEquals(null, target.getFullName(), "FullName mapping with null values failed!");
        assertNull(target.getContactEmail(), "ContactEmail should be null!");
        assertNull(target.getMobile(), "Mobile should be null!");
    }
}
