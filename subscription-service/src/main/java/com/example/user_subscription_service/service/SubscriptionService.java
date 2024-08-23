package com.example.user_subscription_service.service;

import com.example.user_subscription_service.model.Subscription;
import com.example.user_subscription_service.repository.SubscriptionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService implements SubscriptionServiceInterface {

  @Autowired
  private SubscriptionRepository subscriptionRepository;

  @Override
  public final Subscription addSubscription(final Subscription subscription) {
    return subscriptionRepository.save(subscription);
  }

  @Override
  public final List<Subscription> getAllSubscriptions() {
    return subscriptionRepository.findAll();
  }
}
