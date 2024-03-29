package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class calculateHotelwihtbestrating 
{
	public static void calculateHotelwihtbestRating(Scanner sc,List<Hotel> hotelList) {
	    System.out.println("Enter the start date in (yyyy-mm-dd) : ");
	    String startDatestr2 = sc.next();
	    LocalDate startDate2 = LocalDate.parse(startDatestr2, DateTimeFormatter.ISO_DATE);

	    System.out.println("Enter the end date in (yyyy-mm-dd) : ");
	    String endDatestr2 = sc.next();
	    LocalDate endDate2 = LocalDate.parse(endDatestr2, DateTimeFormatter.ISO_DATE);
	    
	    long countDays=ChronoUnit.DAYS.between(startDate2, endDate2);
	    Hotel cheapestHotel = hotelList.get(0);
	    Hotel bestRatedHotel = null;

	    for (Hotel hotel : hotelList) {
	        if (hotel.getHotel_rating() >= 4) {
	            if (bestRatedHotel==null || hotel.getHotel_rating() > bestRatedHotel.getHotel_rating()) {
	                bestRatedHotel = hotel;
	            }
	        }
	        if (hotel.getWeekDayprice() < cheapestHotel.getWeekDayprice()) {
	            cheapestHotel = hotel;
	        }
	    }

	    if (bestRatedHotel != null) {
	        System.out.println("Best rate hotel name is: " + bestRatedHotel.getHotelName() +". Rating: " + bestRatedHotel.getHotel_rating() +". Total Rates: " + bestRatedHotel.getWeekDayprice()*countDays);
	    }
	}
}
