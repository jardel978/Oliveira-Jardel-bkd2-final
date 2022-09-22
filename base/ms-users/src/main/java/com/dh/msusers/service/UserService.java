package com.dh.msusers.service;

import com.dh.msusers.model.User;
import com.dh.msusers.repository.IClaimFeignRepository;
import com.dh.msusers.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository userRepository;
    private IClaimFeignRepository claimFeignRepository;

    public UserService(IUserRepository userRepository, IClaimFeignRepository claimFeignRepository) {
        this.userRepository = userRepository;
        this.claimFeignRepository = claimFeignRepository;
    }

    public User findUser(String userId) {
        User user = userRepository.findById(userId);
        user.setClaims(claimFeignRepository.getClaims(user.getId()));
        return user;
    }

}
