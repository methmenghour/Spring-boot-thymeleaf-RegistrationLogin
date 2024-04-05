package com.menghour.registrationlogin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.menghour.registrationlogin.entity.User;

public interface UserService {
	User create(User user);
	User getById(Integer id);
	User update(Integer id, User UserUpdate);
	void  delete(Integer id);
	Page findAll(Pageable pageable);
	Page findByFirstName(String keyword, Pageable pageable);

}
