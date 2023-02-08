package com.himal.malla.himal.Service;

import com.himal.malla.himal.Enity.User;

import java.util.List;

public interface UserService {

    public User save(User user);

    public List<User> saveAll(List<User> userList);

    public List<User> getUsers();

    public User getUserById(Integer userId);

    public User updateUser(User user) ;

    public String deleteUser(int userId) ;
}
