package com.example.user_subscription_service.service;

import com.example.user_subscription_service.model.UserSubscription;
import com.example.user_subscription_service.repository.UserSubscriptionRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserSubscriptionService implements UserSubscriptionServiceInterface {

  @Autowired
  private UserSubscriptionRepository userSubscriptionRepository;

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public final UserSubscription subscribe(UserSubscription userSubscription) {
    userSubscription.setStartDate(LocalDate.now());
    userSubscription.setEndDate(LocalDate.now().plusDays(30));
    userSubscription.setIsActive(true);

    kafkaTemplate.send("subscription_events", "User " + userSubscription.getUserId() + " "
        + "subscribed to " +
        userSubscription.getSubscriptionId());
    return userSubscriptionRepository.save(userSubscription);
  }

  @Override
  public List<UserSubscription> getUserSubscriptions(Long userId) {
    return userSubscriptionRepository.findByUserId(userId);
  }
}
