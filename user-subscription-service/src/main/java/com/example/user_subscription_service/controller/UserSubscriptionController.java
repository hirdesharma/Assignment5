package com.example.user_subscription_service.controller;

import com.example.user_subscription_service.model.UserSubscription;
import com.example.user_subscription_service.repository.UserSubscriptionRepository;
import com.example.user_subscription_service.service.UserSubscriptionServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-subscriptions")
public class UserSubscriptionController implements UserSubscriptionControllerInterface {

  @Autowired
  private UserSubscriptionRepository userSubscriptionRepository;
  @Autowired
  private UserSubscriptionServiceInterface userSubscriptionService;

  @Override
  @PostMapping("/subscribe")
  @ResponseStatus(HttpStatus.OK)
  public final UserSubscription subscribe(@RequestBody final UserSubscription userSubscription) {
    final Long userId = userSubscription.getUserId();
    final Long subscriptionId = userSubscription.getSubscriptionId();
    return userSubscriptionService.subscribe(userSubscription);
  }

  @Override
  @GetMapping("/user/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public List<UserSubscription> getUserSubscriptions(@PathVariable Long userId) {
    return userSubscriptionService.getUserSubscriptions(userId);
  }
}
