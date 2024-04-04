package com.menghour.registrationlogin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.menghour.registrationlogin.Dto.UserDTO;
import com.menghour.registrationlogin.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    
 	@Mapping(target = "id", ignore = true)
    UserDTO createUserDTOWithoutId(User user);
}