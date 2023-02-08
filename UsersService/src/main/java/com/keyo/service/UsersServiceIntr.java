package com.keyo.service;

import java.util.List;

import com.keyo.entities.Users;

public interface UsersServiceIntr {
public String saveUser(Users user);
public Users getUsers(String usersId);
public List<Users> getAllUsers();

}
