package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_1;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_1;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class ListToListMapperTest {

    private final ListToListMapper_Type_1 listToListMapper = Mappers.getMapper(ListToListMapper_Type_1.class);

    @Test
    public void testSourceListToTargetList() {
        // Arrange: Create a SourceList with a list of SourceAddress
        SourceAddress sourceAddress1 = new SourceAddress();
        sourceAddress1.setSourceStreet("123 Main St");
        sourceAddress1.setSourceCity("CityA");
        sourceAddress1.setSourceState("StateA");
        sourceAddress1.setSourceZip("11111");
        sourceAddress1.setSourceCountry("CountryA");

        SourceAddress sourceAddress2 = new SourceAddress();
        sourceAddress2.setSourceStreet("456 Elm St");
        sourceAddress2.setSourceCity("CityB");
        sourceAddress2.setSourceState("StateB");
        sourceAddress2.setSourceZip("22222");
        sourceAddress2.setSourceCountry("CountryB");

        SourceList_Type_1 sourceList = new SourceList_Type_1();
        sourceList.setAddresses(Arrays.asList(sourceAddress1, sourceAddress2));

        // Act: Use the mapper to map the SourceList to TargetList
        TargetList_Type_1 targetList = listToListMapper.sourceListToTargetList(sourceList);

        // Assert: Check that the target list has the same size and the individual address fields are correctly mapped
        assertEquals(2, targetList.getAddresses().size());

        TargetAddress targetAddress1 = targetList.getAddresses().get(0);

        // console print
        System.out.println("\n\nTarget Address 1:");
        System.out.println("Street: " + targetAddress1.getTargetStreet());
        System.out.println("City: " + targetAddress1.getTargetCity());
        System.out.println("State: " + targetAddress1.getTargetState());
        System.out.println("Zip: " + targetAddress1.getTargetZip());
        System.out.println("Country: \n\n" + targetAddress1.getTargetCountry());

        // assert
        assertEquals("123 Main St", targetAddress1.getTargetStreet());
        assertEquals("CityA", targetAddress1.getTargetCity());
        assertEquals("StateA", targetAddress1.getTargetState());
        assertEquals("11111", targetAddress1.getTargetZip());
        assertEquals("CountryA", targetAddress1.getTargetCountry());

        TargetAddress targetAddress2 = targetList.getAddresses().get(1);

        // console print
        System.out.println("Target Address 2:");
        System.out.println("Street: " + targetAddress2.getTargetStreet());
        System.out.println("City: " + targetAddress2.getTargetCity());
        System.out.println("State: " + targetAddress2.getTargetState());
        System.out.println("Zip: " + targetAddress2.getTargetZip());
        System.out.println("Country: \n\n" + targetAddress2.getTargetCountry());

        // assert
        assertEquals("456 Elm St", targetAddress2.getTargetStreet());
        assertEquals("CityB", targetAddress2.getTargetCity());
        assertEquals("StateB", targetAddress2.getTargetState());
        assertEquals("22222", targetAddress2.getTargetZip());
        assertEquals("CountryB", targetAddress2.getTargetCountry());
    }
}
