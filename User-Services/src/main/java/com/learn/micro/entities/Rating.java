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
public class Rating {
	private String ratingid;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
