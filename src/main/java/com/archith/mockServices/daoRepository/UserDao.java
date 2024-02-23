package com.archith.mockServices.daoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.archith.mockServices.model.User;
import com.archith.mockServices.to.UserTo;

import jakarta.transaction.Transactional;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public User getUsertoAuthenticate(UserTo userTo);

	public User findByEmail(String userEmail);

}
