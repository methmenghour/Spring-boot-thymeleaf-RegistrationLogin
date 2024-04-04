package com.menghour.registrationlogin.Dto;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.menghour.registrationlogin.config.customconstraint.ValidDateTimePattern;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class UserDTO {

	 private Integer id;
	 	 
	 private String firstName;
	 
	 private String lastName;
	 
	 private Character gender;
	 
	 //@JsonIgnore
	 private String phoneNumber ;
	 
	 @ValidDateTimePattern // must add create (@RequestBody @Valid  UserDTO userDTO)
	 private String inputDate;
	 
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	 private LocalDateTime createDate;
	 
}
