package com.himal.malla.himal.ServiceImpl;

import com.himal.malla.himal.Enity.User;
import com.himal.malla.himal.Repository.UserRepo;
import com.himal.malla.himal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    public List<User> saveAll(List<User> userList) {
        return userRepo.saveAll(userList);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User updateUser(User user) {
        User existingUser = userRepo.findById(user.getUserId()).orElse(null);
        existingUser.setName(user.getName());
        return userRepo.save(existingUser);
    }

    public String deleteUser(int userId) {
        userRepo.deleteById(userId);
        return "user is deleted "+userId;
    }
}
