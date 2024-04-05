package com.menghour.registrationlogin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/user/new")
	public ResponseEntity<?> create (@RequestBody @Valid  UserDTO userDTO){
		User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
	         user = userService.create(user);
		return ResponseEntity.ok(UserMapper.INSTANCE.userToUserDTO(user));
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<?>getOneStudent(@PathVariable Integer id){	
		
		return ResponseEntity.ok(userService.getById(id));
	}
	@PutMapping("/user/update/{id}")
	public ResponseEntity<?>  update(@PathVariable("id") Integer userId, @RequestBody @Valid  UserDTO userDTO){
		User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
		return ResponseEntity.ok(userService.update(userId,user));

	}
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer userId){
		userService.delete(userId);
		return ResponseEntity.ok("Delete User Successfully");
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getAll(@RequestParam(required = false) String keyword,
		      @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size){
		
		List<User> users = new ArrayList<>();
	    Pageable paging = PageRequest.of(page - 1, size);

	      Page<User> pageUsers;
	      if(keyword==null) {
	    	  pageUsers = userService.findAll(paging); 
	      }else {
	    	  pageUsers = userService.findByFirstName(keyword,paging);
	      }	     
	      
	      users = pageUsers.getContent();

		return ResponseEntity.ok(users);
	}

}
