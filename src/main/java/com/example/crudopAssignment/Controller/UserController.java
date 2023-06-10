package com.example.crudopAssignment.Controller;

import com.example.crudopAssignment.Entity.User;
import com.example.crudopAssignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userDetails")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        Integer id = userService.saveUser(user);
        return new ResponseEntity<String>("User with '"+id+"'  has been saved", HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getAllUserDetails(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@PathVariable("uid") Integer uid){
        User user = userService.getUserById(uid);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{uid}")
    public ResponseEntity<String> updateUser(@PathVariable("uid") Integer uid, @RequestBody User newUser){
        User user = userService.getUserById(uid);
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getFirstName());
        user.setEmail(newUser.getEmail());
        user.setAge(newUser.getAge());
        Integer id = userService.saveUser(user);

        return new ResponseEntity<String>("User with '"+id+"' has been updated", HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable("uid") Integer uid){
     userService.deleteUser(uid);
     return new ResponseEntity<String>("User with '"+uid+"' has been deleted0", HttpStatus.OK);
    }
}
