package com.demo.mapstruct.MapStructDemo.mapper;

import com.demo.mapstruct.MapStructDemo.source.dto.SourceAddress;
import com.demo.mapstruct.MapStructDemo.source.dto.SourceList_Type_2;
import com.demo.mapstruct.MapStructDemo.source.dto.SourcePerson;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetAddress;
import com.demo.mapstruct.MapStructDemo.target.dto.TargetList_Type_2;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ListToListMapper_Type_3Test {
    private final ListToListMapper_Type_3 mapper = Mappers.getMapper(ListToListMapper_Type_3.class);

    @Test
    void testSourceListToTargetList_withValidData() {
        // Prepare test data
        SourceAddress sourceAddress1 = new SourceAddress();
        sourceAddress1.setSourceStreet("Street 1");
        sourceAddress1.setSourceCity("City 1");
        sourceAddress1.setSourceState("State 1");
        sourceAddress1.setSourceZip("12345");
        sourceAddress1.setSourceCountry("Country 1");

        SourceAddress sourceAddress2 = new SourceAddress();
        sourceAddress2.setSourceStreet("Street 2");
        sourceAddress2.setSourceCity(null); // Should default to "Unknown"
        sourceAddress2.setSourceState("State 2");
        sourceAddress2.setSourceZip("67890");
        sourceAddress2.setSourceCountry("Country 2");

        SourcePerson sourcePerson = new SourcePerson();
        sourcePerson.setAddresses(List.of(sourceAddress1, sourceAddress2));

        SourceList_Type_2 sourceList = new SourceList_Type_2();
        sourceList.setSourcePerson(sourcePerson);

        // Perform mapping
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Verify results
        assertThat(targetList).isNotNull();
        assertThat(targetList.getTargetPerson()).isNotNull();
        List<TargetAddress> targetAddresses = targetList.getTargetPerson().getAddresses();
        assertThat(targetAddresses).hasSize(2);

        TargetAddress targetAddress1 = targetAddresses.get(0);
        assertThat(targetAddress1.getTargetStreet()).isEqualTo("Street 1");
        assertThat(targetAddress1.getTargetCity()).isEqualTo("City 1");
        assertThat(targetAddress1.getTargetState()).isEqualTo("State 1");
        assertThat(targetAddress1.getTargetZip()).isEqualTo("12345");
        assertThat(targetAddress1.getTargetCountry()).isEqualTo("Country 1");

        TargetAddress targetAddress2 = targetAddresses.get(1);
        assertThat(targetAddress2.getTargetStreet()).isEqualTo("Street 2");
        assertThat(targetAddress2.getTargetCity()).isEqualTo("Unknown");
        assertThat(targetAddress2.getTargetState()).isEqualTo("State 2");
        assertThat(targetAddress2.getTargetZip()).isEqualTo("67890");
        assertThat(targetAddress2.getTargetCountry()).isEqualTo("Country 2");
    }

    @Test
    void testSourceListToTargetList_withEmptyAddressList() {
        // Prepare test data
        SourcePerson sourcePerson = new SourcePerson();
        sourcePerson.setAddresses(List.of()); // Empty list

        SourceList_Type_2 sourceList = new SourceList_Type_2();
        sourceList.setSourcePerson(sourcePerson);

        // Perform mapping
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Verify results
        assertThat(targetList).isNotNull();
        assertThat(targetList.getTargetPerson()).isNotNull();
        assertThat(targetList.getTargetPerson().getAddresses()).isEmpty();
    }

    @Test
    void testSourceListToTargetList_withNullSourcePerson() {
        // Prepare test data
        SourceList_Type_2 sourceList = new SourceList_Type_2();
        SourcePerson sourcePerson = new SourcePerson();
        sourcePerson.setAddresses(null);
        sourceList.setSourcePerson(sourcePerson);

        // Perform mapping
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(sourceList);

        // Verify results
        assertThat(targetList).isNotNull();
        assertThat(targetList.getTargetPerson()).isNotNull();
        assertThat(targetList.getTargetPerson().getAddresses()).isEmpty();
    }

    @Test
    void testSourceListToTargetList_withNullSourceList() {
        // Perform mapping
        TargetList_Type_2 targetList = mapper.sourceListToTargetList(null);

        // Verify results
        assertThat(targetList).isNull();
    }
}
