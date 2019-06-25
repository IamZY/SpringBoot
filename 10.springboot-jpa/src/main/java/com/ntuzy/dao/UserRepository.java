package com.ntuzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntuzy.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
