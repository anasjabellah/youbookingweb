package com.example.youbookingweb.services;

import com.example.youbookingweb.entities.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    Room AddRoom(Room room , Long id);
    Optional<Room> findByid(Long id);
    List<Room> GetAllRoom();
    Boolean Delete(Long id);
    Room updateRoom(Room room , Long id);
    void optionRoom(Long id);

    List<Room> findByHotelId(Long id);

}
