package com.keyo.entities;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
private String ratingId;
private String userId;
private String hotelId;
private Integer rate;
private String feedback;


private Hotel hotels;
}
