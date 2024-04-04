package com.menghour.registrationlogin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.menghour.registrationlogin.Dto.UserDTO;
import com.menghour.registrationlogin.entity.User;
import com.menghour.registrationlogin.mapper.UserMapper;
import com.menghour.registrationlogin.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService; 
	@PostMapping
	public ResponseEntity<?> create (@RequestBody @Valid  UserDTO userDTO){
		User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
	         user = userService.create(user);
		return ResponseEntity.ok(UserMapper.INSTANCE.userToUserDTO(user));
	}
}
