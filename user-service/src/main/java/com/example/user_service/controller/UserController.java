package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController implements UserControllerInterface {

  @Autowired
  private UserService userService;

  @Override
  @PostMapping("/register")
  @ResponseStatus(HttpStatus.OK)
  public final User register(@RequestBody final User user) {
    return userService.registerUser(user);
  }

  @Override
  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  public final User login(@RequestBody final User user) {
    return userService.authenticate(user.getEmail(), user.getPassword());
  }
}
