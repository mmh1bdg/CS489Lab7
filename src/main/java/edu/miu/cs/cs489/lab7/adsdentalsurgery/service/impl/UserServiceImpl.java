package edu.miu.cs.cs489.lab7.adsdentalsurgery.service.impl;

import edu.miu.cs.cs489.lab7.adsdentalsurgery.model.User;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.repository.UserRepository;
import edu.miu.cs.cs489.lab7.adsdentalsurgery.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
