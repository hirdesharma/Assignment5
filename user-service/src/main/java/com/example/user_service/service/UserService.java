package com.example.user_service.service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

  @Autowired
  private UserRepository userRepository;

  @Override
  public final User registerUser(final User user) {
    return userRepository.save(user);
  }

  @Override
  public final User authenticate(final String email, final String password) {
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found"));
    if (user.getPassword().equals(password)) {
      return user;
    } else {
      throw new RuntimeException("Invalid credentials");
    }
  }
}
