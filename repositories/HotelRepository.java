package com.example.youbookingweb.repositories;

import com.example.youbookingweb.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Hotel findByName(String Email);
}
