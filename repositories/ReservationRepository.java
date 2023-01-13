package com.example.youbookingweb.repositories;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ReservationRepository extends JpaRepository<Reservation , Long> {
    List<Reservation>  getReservationByClient(User user);
}
