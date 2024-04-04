package com.menghour.registrationlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.menghour.registrationlogin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<Integer> {

}
