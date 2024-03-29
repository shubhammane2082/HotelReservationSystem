package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class CalculateHotelRate 
{
	public static void calculateHotelrate(Scanner sc,List<Hotel> hotelList) {
		System.out.println("Enter the start date in (yyyy-mm-dd) : ");
    	String startDatestr=sc.next();
    	LocalDate startDate=LocalDate.parse(startDatestr, DateTimeFormatter.ISO_DATE);
    	
    	System.out.println("Enter the end date in (yyyy-mm-dd) : ");
    	String endDatestr=sc.next();
    	LocalDate endDate=LocalDate.parse(endDatestr, DateTimeFormatter.ISO_DATE);
	    Hotel cheapestHotel = hotelList.get(0);
	    long lowestCost = Long.MAX_VALUE;
	    long countDays = ChronoUnit.DAYS.between(startDate, endDate);
	    
	    for (int i = 0; i < hotelList.size(); i++) 
	    {
	        Hotel hotel = hotelList.get(i);
	        long totalCost = countDays * hotel.getWeekDayprice();
	        if (totalCost < lowestCost) {
	            lowestCost = totalCost;
	            cheapestHotel = hotel;
	        }
	    }
	    System.out.println("Cheapest Hotel Name is: " + cheapestHotel.getHotelName() + ".Hotel price is: " + lowestCost +".Hotel rating is : "+cheapestHotel.getHotel_rating());
	}
}
