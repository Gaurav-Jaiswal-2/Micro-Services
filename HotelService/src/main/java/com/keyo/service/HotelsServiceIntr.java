package com.keyo.service;

import java.util.List;

import com.keyo.entities.Hotels;

public interface HotelsServiceIntr {
public String createHotels(Hotels hotels);
public Hotels getHotelByHotelId(String hotelId);
public List<Hotels> getAllhotels();
}
