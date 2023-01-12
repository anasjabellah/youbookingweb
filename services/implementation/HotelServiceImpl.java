package com.example.youbookingweb.services.implementation;

import com.example.youbookingweb.entities.Hotel;
import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.repositories.HotelRepository;
import com.example.youbookingweb.repositories.UserRepository;
import com.example.youbookingweb.services.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {


    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(UserRepository userRepository, HotelRepository hotelRepository) {
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }


    @Override
    public Hotel addHotel(Hotel hotel, Long idManager) {
        User user = userRepository.findById(idManager).orElse(null);
        if(hotel.getAddress() != null && hotel.getCity() != null && hotel.getName() != null){
                hotel.setManager(user);
                hotelRepository.save(hotel);
        }
        return hotel;
    }

    @Override
    public List<Hotel> GetAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(long id) {
        return hotelRepository.findById(id);
    }


    public Hotel findByName(String NameHotel) {
        return null ; // hotelRepository.findByName(NameHotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel , Long id) {
        Hotel hotel1 = hotelRepository.findById(id).orElse(null);
        hotel1.setName(hotel.getName());
        hotel1.setAddress(hotel.getAddress());
        hotel1.setCity(hotel.getCity());
        hotelRepository.save(hotel1);

        return hotel1;
    }

    @Override
    public Boolean DeleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        hotelRepository.delete(hotel);
        return Boolean.TRUE;
    }
}
