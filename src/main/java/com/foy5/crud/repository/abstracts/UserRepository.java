package com.foy5.crud.repository.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foy5.crud.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
