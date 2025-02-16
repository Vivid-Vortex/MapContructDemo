package com.demo.mapstruct.MapStructDemo.mapper.deep.nesting.mappings;

import com.demo.mapstruct.MapStructDemo.source.dto.deep.nesting.mapping.*;
import com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings.ChannelTarget;
import com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings.MediumEnumTarget;
import com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings.UserTarget;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperDeeplyNestedTest {

    private final UserMapper mapper = UserMapper.INSTANCE;

    @Test
    void testMapping() {
        // Setup sample data
        ChannelSource channelSource = new ChannelSource();
        channelSource.setMedium(MediumEnum.EMAIL);
        channelSource.setMediumDetail("test@example.com");

        CommunicationChannelSource commSource = new CommunicationChannelSource();
        commSource.setChannel(channelSource);

        ContactSource contactSource = new ContactSource();
        contactSource.setCommunicationChannel(List.of(commSource));

        PersonSource personSource = new PersonSource();
        personSource.setContact(contactSource);

        UserSource userSource = new UserSource();
        userSource.setPerson(personSource);

        // Perform mapping
        UserTarget userTarget = mapper.userSourceToUserTarget(userSource);

        // Assertions
        assertNotNull(userTarget);
        assertNotNull(userTarget.getPerson());
        assertNotNull(userTarget.getPerson().getContact());
        assertNotNull(userTarget.getPerson().getContact().getCommunicationChannel());
        assertFalse(userTarget.getPerson().getContact().getCommunicationChannel().isEmpty());

        ChannelTarget channelTarget = userTarget.getPerson().getContact().getCommunicationChannel().get(0).getChannel();
        assertNotNull(channelTarget);
        assertEquals(MediumEnumTarget.EMAIL, channelTarget.getMedium());
        assertEquals("test@example.com", channelTarget.getMediumDetail());
    }
}
