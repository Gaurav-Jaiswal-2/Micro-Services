package com.keyo.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.keyo.entities.Hotel;


@FeignClient(name = "HOTEL-SERVICE")
public interface IHotelService {

	@GetMapping("hotels/hotel/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);
}
