package com.sanad.authentication.services;

import java.util.Optional;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sanad.authentication.models.LoginUser;
import com.sanad.authentication.models.User;
import com.sanad.authentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {

		if (!Pattern.matches("^[a-zA-Z]+$", newUser.getUserName())) {
			result.rejectValue("userName", "Unique", "Username should only contain letters!");
		}

		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Password do not match!");
		}

		Optional<User> checkUser = userRepo.findByEmail(newUser.getEmail());
		if (checkUser.isPresent()) {
			result.rejectValue("email", "Matches", "A user with this email already exists!");
		}

		if (result.hasErrors()) {
			return null;
		}

		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		userRepo.save(newUser);
		return newUser;
	}

	public User login(LoginUser newLoginObject, BindingResult result) {

		Optional<User> u = userRepo.findByEmail(newLoginObject.getEmail());

		if (!u.isPresent()) {

			result.rejectValue("email", "Matches", "Invalid Email or Password!");
		} else if (!BCrypt.checkpw(newLoginObject.getPassword(), u.get().getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Email or Password!");
		}

		if (result.hasErrors()) {
			return null;
		}

		return u.get();

	}

	public User findUserByEmail(String email) {
		Optional<User> u = userRepo.findByEmail(email);
		if (u.isPresent()) {
			User user = u.get();
			return user;
		} else {
			return null;
		}

	}

	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);
		if (u.isPresent()) {
			User user = u.get();
			return user;
		} else {
			return null;
		}

	}

	public void deleteUser(Long id) {
		User user = this.findUserById(id);
		userRepo.delete(user);

	}

}