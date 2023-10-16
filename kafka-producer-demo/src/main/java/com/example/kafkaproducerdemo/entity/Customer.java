package com.example.kafkaproducerdemo.entity;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String contactNumber;
}
