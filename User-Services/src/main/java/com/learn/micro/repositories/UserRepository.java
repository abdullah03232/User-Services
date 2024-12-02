package com.learn.micro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.micro.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}
