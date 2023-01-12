package com.example.youbookingweb.services;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.Room;
import com.example.youbookingweb.entities.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {


    // add user in data
    void AddReservation(Reservation reservation , Long userId , Long roomId);

    // list user
   List<Reservation> getAllReservation();
    //get user by email
    Optional<Reservation> findById(Long id);

    // get user by id
   // Optional<User> findById(long id);

    // update user
    //void updateUser(User user);


    // delet User
   Boolean DeleteReservation(long id);
}
