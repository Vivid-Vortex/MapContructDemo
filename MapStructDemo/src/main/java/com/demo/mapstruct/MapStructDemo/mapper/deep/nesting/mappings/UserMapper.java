package com.demo.mapstruct.MapStructDemo.mapper.deep.nesting.mappings;

import com.demo.mapstruct.MapStructDemo.source.dto.deep.nesting.mapping.*;
import com.demo.mapstruct.MapStructDemo.target.dto.deep.nesting.mappings.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//    // This is essentially mapping medium at channelSourceToChannelTarget, which is the last mapping in the order of mapping.
//
//    /**
//     * Pros:
//     * Below are the advantage of below apprach is:
//     * No extra methods needed → Everything is mapped inline.
//     * Concise & efficient → No extra method calls.
//     */
//    @Mapping(target = "person", source = "person")
//    UserTarget userSourceToUserTarget(UserSource userSource);
//    @Mapping(target = "contact", source = "contact")
//    PersonTarget personSourceToPersonTarget(PersonSource personSource);
//    @Mapping(target = "communicationChannel", source = "communicationChannel")
//    ContactTarget contactSourceToContactTarget(ContactSource contactSource);
//    @Mapping(target = "channel", source = "channel")
//    CommunicationChannelTarget communicationChannelSourceToCommunicationChannelTarget(CommunicationChannelSource source);
//    @Mapping(target = "medium", source = "medium")
//    ChannelTarget channelSourceToChannelTarget(ChannelSource source);
//
//    // No need to explicitly call mapMediumEnum method in channelSourceToChannelTarget method, using @Named or expression.
//    // ChannelSourceToChannelTarget method will automatically pick mapMediumEnum,
//    // since source and target type of of mapMediumEnum is same as source and target type of channelSourceToChannelTarget
//    // Note: If you pass extra argument to mapMediumEnum, then it will not be picked by channelSourceToChannelTarget method,
//    // Since source and target type of mapMediumEnum will not match with source and target type of channelSourceToChannelTarget.
//    // This is true even if you pass String mediumDetail as second argument, which is the second attribute of ChannelSource and ChannelTarget.
//    default MediumEnumTarget mapMediumEnum(MediumEnum source) {
//        return source != null ? MediumEnumTarget.valueOf(source.name()) : null;
//    }

    // You can either map each and every step as above or just provide the start and end mapping (and leave every in between mappings (as done above) for mapConstruct to handle).
    // You can uncomment the above map and see the comparison yourself.
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserTarget userSourceToUserTarget(UserSource userSource);

    @Mapping(source = "medium", target = "medium")
    @Mapping(source = "mediumDetail", target = "mediumDetail")
    ChannelTarget channelSourceToChannelTarget(ChannelSource source);

    //    // No need to explicitly call mapMediumEnum method in channelSourceToChannelTarget method, using @Named or expression.
//    // ChannelSourceToChannelTarget method will automatically pick mapMediumEnum,
//    // since source and target type of of mapMediumEnum is same as source and target type of channelSourceToChannelTarget
//    // Note: If you pass extra argument to mapMediumEnum, then it will not be picked by channelSourceToChannelTarget method,
//    // Since source and target type of mapMediumEnum will not match with source and target type of channelSourceToChannelTarget.
//    // This is true even if you pass String mediumDetail as second argument, which is the second attribute of ChannelSource and ChannelTarget.
    default MediumEnumTarget mapMediumEnum(MediumEnum source) {
        return source != null ? MediumEnumTarget.valueOf(source.name()) : null;
    }
}