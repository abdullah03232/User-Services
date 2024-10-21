package com.learn.micro.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class Users {
@Id
private String userId;
private String userName;
@Column(name = "email")
private String userEmail;
@Column(name = "address")
private String userAddress;
@Column(name = "mobile")
private String userMobile;

@Transient
private List<Rating> rating = new ArrayList<>();





}
