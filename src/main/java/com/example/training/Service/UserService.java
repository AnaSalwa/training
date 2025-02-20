package com.example.training.Service;


import com.example.training.Model.User;
import com.example.training.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(User user){
        return userRepository.save(user);

    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id ){
        return userRepository.findById(id) ;
    }
}
