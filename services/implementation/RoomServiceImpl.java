package com.example.youbookingweb.services.implementation;

import com.example.youbookingweb.entities.Hotel;
import com.example.youbookingweb.entities.Room;
import com.example.youbookingweb.repositories.HotelRepository;
import com.example.youbookingweb.repositories.RoomRepository;
import com.example.youbookingweb.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private  final HotelRepository hotelRepository;
    @Autowired
    private final RoomRepository roomRepository;

    public RoomServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;}

    @Override
    public Room AddRoom(Room room , Long id ) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);

        room.setHotel(hotel);
        roomRepository.save(room);
        return room;
    }

    @Override
    public Optional<Room> findByid(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Room> GetAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Boolean Delete(Long id) {
        roomRepository.deleteById(id);
        return true;
    }

    @Override
    public Room updateRoom(Room room ,  Long id) {
        Room room1 = roomRepository.findById(id).orElse(null);
        room1.setNumberRoom(room.getNumberRoom());
        room1.setCapacity(room.getCapacity());
        room1.setOption(room.getOption());
        room1.setPrice(room.getPrice());
        return roomRepository.save(room1);

    }

    @Override
    public void optionRoom(Long id) {}

    @Override
    public List<Room> findByHotelId(Long id) {
        return roomRepository.findByHotelId(id);
    }
}
