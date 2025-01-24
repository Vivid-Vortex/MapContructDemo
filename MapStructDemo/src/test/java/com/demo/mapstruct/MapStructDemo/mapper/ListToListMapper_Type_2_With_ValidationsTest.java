package com.demo.mapstruct.MapStructDemo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_2;
import com.demo.mapstruct.MapStructDemo.source.dto.SourcePerson;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_2;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListToListMapper_Type_2_With_ValidationsTest {

    private final ListToListMapper_Type_2_With_Validations mapper = Mappers.getMapper(ListToListMapper_Type_2_With_Validations.class);

    @Test
    public void testSourceListToTargetList_withEmptyList() {
        // Given a SourceList with an empty addresses list
        SourceList_Type_2 sourceList = new SourceList_Type_2();
        SourcePerson sourcePerson = new SourcePerson();
        sourcePerson.setAddresses(Collections.emptyList()); // Empty list
        sourceList.setSourcePerson(sourcePerson);

        // When the mapping happens
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Then assert that the targetPerson's addresses list is also empty
        assertNotNull(targetList);
        assertNotNull(targetList.getTargetPerson());
        assertNotNull(targetList.getTargetPerson().getAddresses());
        assertTrue(targetList.getTargetPerson().getAddresses().isEmpty());
        System.out.println("TargetList with Empty Addresses: " + targetList);
    }

    @Test
    public void testSourceListToTargetList_withNullList() {
        // Given a SourceList with a null addresses list
        SourceList_Type_2 sourceList = new SourceList_Type_2();
        SourcePerson sourcePerson = new SourcePerson();
        sourcePerson.setAddresses(null); // Null list
        sourceList.setSourcePerson(sourcePerson);

        // When the mapping happens
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Then assert that the targetPerson's addresses list is also empty
        assertNotNull(targetList);
        assertNotNull(targetList.getTargetPerson());
        assertNull(targetList.getTargetPerson().getAddresses());
//        assertTrue(targetList.getTargetPerson().getAddresses().isEmpty());
        System.out.println("TargetList with Null Addresses: " + targetList);
    }

    @Test
    public void testSourceListToTargetList_withValidAddresses() {
        // Given a SourceList with some valid addresses
        SourceList_Type_2 sourceList = new SourceList_Type_2();
        SourcePerson sourcePerson = new SourcePerson();
        List<SourceAddress> sourceAddresses = new ArrayList<>();
        SourceAddress sourceAddress = new SourceAddress();
        sourceAddress.setSourceStreet("123 Main St");
        sourceAddress.setSourceCity("Springfield");
        sourceAddress.setSourceState("IL");
        sourceAddress.setSourceZip("62701");
        sourceAddress.setSourceCountry("USA");
        sourceAddresses.add(sourceAddress);
        sourcePerson.setAddresses(sourceAddresses);
        sourceList.setSourcePerson(sourcePerson);

        // When the mapping happens
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Then assert that the addresses list is correctly mapped
        assertNotNull(targetList);
        assertNotNull(targetList.getTargetPerson());
        assertFalse(targetList.getTargetPerson().getAddresses().isEmpty());
        assertEquals("123 Main St", targetList.getTargetPerson().getAddresses().get(0).getTargetStreet());
        assertEquals("Springfield", targetList.getTargetPerson().getAddresses().get(0).getTargetCity());
        assertEquals("IL", targetList.getTargetPerson().getAddresses().get(0).getTargetState());
        assertEquals("62701", targetList.getTargetPerson().getAddresses().get(0).getTargetZip());
        assertEquals("USA", targetList.getTargetPerson().getAddresses().get(0).getTargetCountry());
        System.out.println("TargetList with Valid Addresses: " + targetList);
    }

    @Test
    public void testSourceListToTargetList_withEmptyFields() {
        // Given a SourceList with some addresses containing empty fields
        SourceList_Type_2 sourceList = new SourceList_Type_2();
        SourcePerson sourcePerson = new SourcePerson();
        List<SourceAddress> sourceAddresses = new ArrayList<>();
        SourceAddress sourceAddress = new SourceAddress();
        sourceAddress.setSourceStreet(""); // Empty street
        sourceAddress.setSourceCity(""); // Empty city
        sourceAddress.setSourceState(""); // Empty state
        sourceAddress.setSourceZip(""); // Empty zip
        sourceAddress.setSourceCountry(""); // Empty country
        sourceAddresses.add(sourceAddress);
        sourcePerson.setAddresses(sourceAddresses);
        sourceList.setSourcePerson(sourcePerson);

        // When the mapping happens
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Then assert that empty fields are handled properly
        assertNotNull(targetList);
        assertNotNull(targetList.getTargetPerson());
        assertFalse(targetList.getTargetPerson().getAddresses().isEmpty());
        assertEquals("Unknown", targetList.getTargetPerson().getAddresses().get(0).getTargetStreet());
        assertEquals("Unknown", targetList.getTargetPerson().getAddresses().get(0).getTargetCity());
        assertEquals("Unknown", targetList.getTargetPerson().getAddresses().get(0).getTargetState());
        assertEquals("Unknown", targetList.getTargetPerson().getAddresses().get(0).getTargetZip());
        assertEquals("Unknown", targetList.getTargetPerson().getAddresses().get(0).getTargetCountry());
        System.out.println("TargetList with Empty Fields: " + targetList);
    }
}
