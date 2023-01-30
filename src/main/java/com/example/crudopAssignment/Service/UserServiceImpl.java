package com.example.crudopAssignment.Service;

import com.example.crudopAssignment.Entity.User;
import com.example.crudopAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer saveUser(User user) {
        return userRepository.save(user).getUid();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Integer uid) {
        return userRepository.findById(uid).get();
    }

    @Override
    public void deleteUser(Integer uid) {
        userRepository.deleteById(uid);
    }
}
