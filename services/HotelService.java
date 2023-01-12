package com.example.youbookingweb.services;

import com.example.youbookingweb.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    Hotel addHotel(Hotel hotel , Long idManager);
    List<Hotel> GetAllHotels();

    Optional<Hotel> findById(long id);
   // Hotel findByName(String NameHotel);
    Hotel updateHotel(Hotel hotel , Long id);
    Boolean DeleteHotel(Long id);

}
