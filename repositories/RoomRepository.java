package com.example.youbookingweb.repositories;

import com.example.youbookingweb.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room , Long> {

    List<Room> findByHotelId(Long id);
}
