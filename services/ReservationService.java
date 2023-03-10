package com.example.youbookingweb.services;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.Room;
import com.example.youbookingweb.entities.User;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface ReservationService {


    // add user in data
    Reservation addReservation(Reservation reservation);
    // list user
   List<Reservation> getAllReservation();

   List<Reservation> GetAllByUser(Long id);
    Optional<Reservation> findById(Long id);
    // delet User
   Boolean DeleteReservation(long id);
}
