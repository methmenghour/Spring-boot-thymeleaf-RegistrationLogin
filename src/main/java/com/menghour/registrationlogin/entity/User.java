package com.menghour.registrationlogin.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tblUser")
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "USER_ID")
	 private Integer id;
	 
	 @Column(name = "FIRST_NAME")
	 private String firstName;
	 
	 @Column(name = "LAST_NAME")
	 private String lastName;
	 
	 @Column(name = "GENDER",length =1)
	 private Character gender;
	 
	 
	 @Column(name = "PHONE_NO")
	 private String phoneNumber ;
	 
	 @Column(name = "INPUT_DATE")
     private LocalDateTime inputDate;
	 
	 
	 
}
