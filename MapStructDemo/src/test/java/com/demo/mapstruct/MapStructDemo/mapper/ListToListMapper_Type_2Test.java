package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_2;
import com.demo.mapstruct.MapStructDemo.source.dto.SourcePerson;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_2;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class ListToListMapper_Type_2Test {

    private final ListToListMapper_Type_2 listToListMapper = Mappers.getMapper(ListToListMapper_Type_2.class);

    @Test
    public void testSourceListToTargetList() {
        // Arrange: Create SourceAddress objects
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

        SourcePerson sourcePerson = new SourcePerson();
        sourcePerson.setAddresses(Arrays.asList(sourceAddress1, sourceAddress2));

        SourceList_Type_2 sourceList = new SourceList_Type_2();
        sourceList.setSourcePerson(sourcePerson);

        // Act: Map SourceList_Type_2 to TargetList_Type_2
        TargetList_Type_2 targetList = listToListMapper.sourceListToTargetList(sourceList);

        // Assert: Check that the target list has the same size and address fields are correctly mapped
        assertEquals(2, targetList.getTargetPerson().getAddresses().size());

        // Verify the full mapping for both addresses
        TargetAddress targetAddress1 = targetList.getTargetPerson().getAddresses().get(0);
        assertEquals("CityA", targetAddress1.getTargetCity());
        assertEquals("StateA", targetAddress1.getTargetState());
        assertEquals("11111", targetAddress1.getTargetZip());
        assertEquals("CountryA", targetAddress1.getTargetCountry());
        System.out.println("\n\nAddress 1: " + targetAddress1.getTargetCity());
        System.out.println("State 1: " + targetAddress1.getTargetState());
        System.out.println("Target Zip: " + targetAddress1.getTargetZip());
        System.out.println("Target Country: " + targetAddress1.getTargetCountry());

        TargetAddress targetAddress2 = targetList.getTargetPerson().getAddresses().get(1);
        assertEquals("CityB", targetAddress2.getTargetCity());
        assertEquals("StateB", targetAddress2.getTargetState());
        assertEquals("22222", targetAddress2.getTargetZip());
        assertEquals("CountryB", targetAddress2.getTargetCountry());
        System.out.println("\n\nAddress 2: " + targetAddress2.getTargetCity());
        System.out.println("State 2: " + targetAddress2.getTargetState());
        System.out.println("Target Zip: " + targetAddress2.getTargetZip());
        System.out.println("Target Country: " + targetAddress2.getTargetCountry());
    }
}
