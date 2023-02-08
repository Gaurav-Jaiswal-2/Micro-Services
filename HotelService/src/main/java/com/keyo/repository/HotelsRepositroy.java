package com.keyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyo.entities.Hotels;

@Repository
public interface HotelsRepositroy extends JpaRepository<Hotels, String> {

}
