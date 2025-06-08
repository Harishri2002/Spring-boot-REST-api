package com.springapi.learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class User {
        @Id
        @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
        private Long id;
        private String name;
}