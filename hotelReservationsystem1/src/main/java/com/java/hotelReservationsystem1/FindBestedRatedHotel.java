package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class FindBestedRatedHotel 
{
	public static void findBestRatedhotel(Scanner sc,List<Hotel> hotelList)
	{
		 System.out.println("Enter the start date in (yyyy-mm-dd) : ");
		 String startDatestr2 = sc.next();
		 LocalDate startDate2 = LocalDate.parse(startDatestr2, DateTimeFormatter.ISO_DATE);

		  System.out.println("Enter the end date in (yyyy-mm-dd) : ");
		  String endDatestr2 = sc.next();
		  LocalDate endDate2 = LocalDate.parse(endDatestr2, DateTimeFormatter.ISO_DATE);
		
		  Hotel bestRatedHotel = null;
		  for (Hotel hotel : hotelList) {
		     if (bestRatedHotel == null || hotel.getHotel_rating() > bestRatedHotel.getHotel_rating()) {
		                bestRatedHotel = hotel;
		            }
		        }

		        System.out.println("Best-rated hotel for " + startDate2 + " to " + endDate2 + ": " +
		                bestRatedHotel.getHotelName() + ", Rating: " + bestRatedHotel.getHotel_rating());
	}
}
