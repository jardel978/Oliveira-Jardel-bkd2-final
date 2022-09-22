package com.dh.msusers.repository;

import com.dh.msusers.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements IUserRepository{
  @Override
  public User findById(String id) {
    return new User(id,"John","12345678","john.doe@mail.com",null);
  }
}
