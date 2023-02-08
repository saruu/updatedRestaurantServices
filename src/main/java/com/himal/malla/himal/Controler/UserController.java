package com.himal.malla.himal.Controler;

import com.himal.malla.himal.Enity.User;
import com.himal.malla.himal.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
     }

    @PostMapping("/saveAll")
    public List<User> saveAll(@RequestBody List<User> userList){
        return userService.saveAll(userList);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/userId/{userId}")
    public User findUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }
}
