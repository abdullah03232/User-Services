package com.learn.micro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel {
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelAbout;
}
