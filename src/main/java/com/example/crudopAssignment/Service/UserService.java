package com.example.crudopAssignment.Service;

import com.example.crudopAssignment.Entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.*;

public interface UserService {
    public Integer saveUser(User user);

    public List<User> getAllUsers();
    public User getUserById(Integer uid);

    public void deleteUser(Integer uid);
}
