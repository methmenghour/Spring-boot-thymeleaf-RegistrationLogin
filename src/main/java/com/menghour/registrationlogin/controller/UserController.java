package com.menghour.registrationlogin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.menghour.registrationlogin.Dto.UserDTO;
import com.menghour.registrationlogin.entity.User;
import com.menghour.registrationlogin.mapper.UserMapper;
import com.menghour.registrationlogin.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService; 
	
	@PostMapping("/user/save")
	public String saveUser (@Valid UserDTO userDTO){
		
		User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
		user=userService.create(user);
		
		return "redirect:/users";
	}
	
	 @GetMapping("/user/new")
	public String addUser (Model model){
		 UserDTO userDTO = new UserDTO();
		 
		 model.addAttribute("userDTO", userDTO);
		 model.addAttribute("pageTitle", "Create new User");
		 
		 return "user_form";
	}
	 
	@GetMapping("/user/update/{id}")
	public String  update(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
		
		User user = userService.getById(id);
		UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
		
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("pageTitle", "Update user Id : " + id);
		
	    return "user_form";	

	}
	@GetMapping("/user/delete/{id}")
	public String delete(@PathVariable("id") Integer userId,RedirectAttributes redirectAttributes){
		userService.delete(userId);
		
	    redirectAttributes.addFlashAttribute("message", "The User with id=" + userId + " has been deleted successfully!");
	
	    return "redirect:/users";
	}
	
	@GetMapping("/users")
	public String getAll(Model model,@RequestParam(required = false) String keyword,
		                @RequestParam(defaultValue = "1") int page,
		                @RequestParam(defaultValue = "3") int size)
	{
		List<UserDTO> userDTOs= new ArrayList<>();
		Pageable paging = PageRequest.of(page - 1, size);

	    Page<User> pageUsers;
	    if(keyword==null) {
	    	  pageUsers = userService.findAll(paging); 
	    }else {
	    	  pageUsers = userService.findByFirstName(keyword,paging);
	    }	     

	    userDTOs = pageUsers.getContent()
	    		    .stream()
	                .map(user ->  UserMapper.INSTANCE.userToUserDTO(user))
	                .collect(Collectors.toList());
	    model.addAttribute("userDTOs",userDTOs);
	    model.addAttribute("currentPage", pageUsers.getNumber() + 1);
	    model.addAttribute("totalItems", pageUsers.getTotalElements());
	    model.addAttribute("totalPages", pageUsers.getTotalPages());
	    model.addAttribute("pageSize", size);
	     
	    return "users";

	}

}
