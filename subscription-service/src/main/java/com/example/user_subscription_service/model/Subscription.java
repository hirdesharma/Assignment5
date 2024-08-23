package com.example.user_subscription_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "subscriptions")
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "duration")
  private Integer duration; // in days

  @Column(name = "name")
  private String name;

  @Column(name = "isRenewable")
  private Boolean isRenewable;

  @Column(name = "price")
  private Double price;
}
