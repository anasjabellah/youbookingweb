package com.example.youbookingweb.repositories;

import com.example.youbookingweb.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room , Long> {

    List<Room> findByHotelId(Long id);
}
