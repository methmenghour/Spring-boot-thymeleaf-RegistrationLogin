package com.menghour.registrationlogin.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.menghour.registrationlogin.entity.User;
import com.menghour.registrationlogin.exception.ApiException;
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

	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND,String.format("User with id= %d not found",id)));
	}

	@Override
	public User update(Integer id, User userUpdate) {
		User user=getById(id);
		
		user.setFirstName(userUpdate.getFirstName());
		user.setLastName(userUpdate.getLastName());
		user.setGender(userUpdate.getGender());
		user.setPhoneNumber(userUpdate.getPhoneNumber());
		user.setInputDate(userUpdate.getInputDate());
		user.setCreateDate(userUpdate.getCreateDate());
		
		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {
		User user=getById(id);
		userRepository.deleteById(user.getId());
		
	}

	@Override
	public Page findAll(Pageable pageable) {		
		return userRepository.findAll(pageable);
	}

	@Override
	public Page findByFirstName(String keyword, Pageable pageable) {
		
		return userRepository.findByFirstNameContainingIgnoreCase(keyword,pageable);
	}

}
