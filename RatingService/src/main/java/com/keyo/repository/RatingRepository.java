package com.keyo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyo.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{
  public List<Rating> findByUserId(String userId);
  public List<Rating> findByHotelId(String hotelId);
}
