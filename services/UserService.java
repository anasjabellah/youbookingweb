package com.example.youbookingweb.services;

import com.example.youbookingweb.entities.Role;
import com.example.youbookingweb.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    // add user in data
    void AddUser(User user);

    // list user
    List<User> GetAllUser();

    // get user by email
    Optional<User> findByEmail(String Email);

    // get user by id
    Optional<User> findById(long id);

    // update user
    void updateUser(User user , Long id);

    void  AccepterReservation(Long id);


    // delet User
    Boolean DeleteUser(long id);

    void addUserRool(Long userId , Role role);

    Boolean isBanned(Long id);

    List<User> findAllByBanned(boolean banned);

}
