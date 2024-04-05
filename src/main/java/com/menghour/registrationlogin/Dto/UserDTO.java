package com.menghour.registrationlogin.Dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.menghour.registrationlogin.config.customconstraint.ValidDateTimePattern;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

	 private Integer id;
	 @NotBlank(message = "User firstName is not Blank")
	 private String firstName;
	 
	 @NotBlank(message = "User lastName is not Blank")
	 private String lastName;
	 
	 @NotBlank(message =  "User gender is not null")
	 @Pattern(regexp="M|m|F|f",message = "gender contain Charater M,m,F,f")
	 private String gender;
	 
	 //@JsonIgnore
	 @Pattern(regexp="^\\+?[\\d\\s?]+",message = "invalid Phone number entered ")
	 private String phoneNumber ;
	 
	 @ValidDateTimePattern // must add create (@RequestBody @Valid  UserDTO userDTO)
	 private String inputDate;
	 
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	 private LocalDateTime createDate;
	 
}
