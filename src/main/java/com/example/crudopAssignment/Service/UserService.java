package com.example.crudopAssignment.Service;

import com.example.crudopAssignment.Entity.User;
import java.util.*;

public interface UserService {
    public Integer saveUser(User user);

    public List<User> getAllUsers();
    public User getUserById(Integer uid);

    public void deleteUser(Integer uid);
}
