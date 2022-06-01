package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository urepo;
	
	@Override
	public boolean createUser(User user) {
		return urepo.save(user) != null ? true : false;
	}

	@Override
	public boolean updateUser(User user) {
		return urepo.save(user) != null ? true : false;
	}

	@Override
	public User findUserByName(String username) {
		Optional<User> user = urepo.findAll()
				.stream()
				.filter(u -> (u.getUsername().equals(username)))
				.findFirst();
		return user.isPresent() ? user.get() : null;
	}
	

	@Override
	public boolean userLogOut(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserById(int id) {
		User tempUser = urepo.findById(id).get();
		return tempUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = urepo.findAll();
		return allUsers;
	}

	@Override
	public boolean deleteUser(User user) {
		urepo.delete(user);
		return true;
	}
}
