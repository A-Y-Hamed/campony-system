package com.myproject.company.services;

import com.myproject.company.entity.User;
import com.myproject.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        Optional<User> login = userRepository.findByUsername(username);


        if (login.isPresent()) {
            User user = login.get();

            return user.getPassword().equals(password);
        }


        return false;
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }
}
