package com.project.pac.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.user.definition.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	public UserModel findByUserNameAndPassword(String userName, String password);

	public UserModel findByUserName(String userName);
	
	public Optional<UserModel> findById(Long id);
}
