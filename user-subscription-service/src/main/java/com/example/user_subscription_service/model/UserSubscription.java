package com.example.user_subscription_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
@Table(name = "user_subscriptions")
public class UserSubscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "duration")
  private Long duration;

  @Column(name = "endDate")
  private LocalDate endDate;

  @Column(name = "isActive")
  private Boolean isActive;

  @Column(name = "startDate")
  private LocalDate startDate;

  @Column(name = "subscriptionId", nullable = false)
  private Long subscriptionId;

  @Column(name = "userId", nullable = false)
  private Long userId;
}
