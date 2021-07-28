package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.servise.UserService;
import com.userservice.valueobject.ResponseTempleteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTempleteView getUserByIdwithDepartment(@PathVariable("id") Long userId)
    {
        return userService.getUserByIdwithDepartment(userId);
    }
}
