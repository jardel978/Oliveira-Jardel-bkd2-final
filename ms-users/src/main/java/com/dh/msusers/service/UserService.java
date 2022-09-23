package com.dh.msusers.service;

import com.dh.msusers.model.User;
import com.dh.msusers.repository.IBillsFeignRepository;
import com.dh.msusers.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBillsFeignRepository billsFeignRepository;

    public User findBillByUserId(String userId) {
        User user = userRepository.findById(userId);
        user.setBills(billsFeignRepository.getBills(user.getId()));
        return user;
    }

}
