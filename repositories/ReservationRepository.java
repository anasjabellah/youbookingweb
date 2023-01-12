package com.example.youbookingweb.repositories;

import com.example.youbookingweb.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {
}
