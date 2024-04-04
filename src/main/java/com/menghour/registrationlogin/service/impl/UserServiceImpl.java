package com.menghour.registrationlogin.service.impl;

import org.springframework.stereotype.Service;

import com.menghour.registrationlogin.entity.User;
import com.menghour.registrationlogin.repository.UserRepository;
import com.menghour.registrationlogin.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

}
