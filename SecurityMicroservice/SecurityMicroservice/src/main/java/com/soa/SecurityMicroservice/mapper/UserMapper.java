package com.soa.SecurityMicroservice.mapper;

import com.soa.SecurityMicroservice.domain.User;
import com.soa.model.RegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper
public interface UserMapper {

    @Mapping(target = "password", source = "password")
    User map(RegisterRequestDto registerRequestDto, UUID id, String password);
}
