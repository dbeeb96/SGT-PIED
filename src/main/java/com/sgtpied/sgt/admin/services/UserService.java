package com.sgtpied.sgt.admin.services;

import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
    private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	//Get All Users
	public List<User> findAll(){
		return userRepository.findAll();
	}	
	
	//Get User By Id
	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}	
	

	
	//Update User
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
//Supprimer un utilisateur
	public void deleteById(Integer id) {
		userRepository.deleteById(id);

	}
}
