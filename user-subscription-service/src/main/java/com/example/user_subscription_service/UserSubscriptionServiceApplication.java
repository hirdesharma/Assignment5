package com.example.user_subscription_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UserSubscriptionServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserSubscriptionServiceApplication.class, args);
  }
}
