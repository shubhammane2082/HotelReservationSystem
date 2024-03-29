package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class CalculateHotelRateforWeekEnd 
{
	public static void calculateHotelrateforweekEnd(Scanner sc,List<Hotel> hotelList) 
	{
		System.out.println("Enter the start date in (yyyy-mm-dd) : ");
    	String startDatestr1=sc.next();
    	LocalDate startDate1=LocalDate.parse(startDatestr1, DateTimeFormatter.ISO_DATE);
    	
    	System.out.println("Enter the end date in (yyyy-mm-dd) : ");
    	String endDatestr1=sc.next();
    	LocalDate endDate1=LocalDate.parse(endDatestr1, DateTimeFormatter.ISO_DATE);
		Hotel cheapestHotel=new Hotel();
		long countBydays=ChronoUnit.DAYS.between(startDate1, endDate1);
		long lowestCost = Long.MAX_VALUE;
		
		for(int i=0;i<hotelList.size();i++)
		{
			Hotel hotel=hotelList.get(i);
			long totlacostforWeekend=countBydays * hotel.getWeekEndprice();
			
			if(totlacostforWeekend < lowestCost)
			{
				lowestCost=totlacostforWeekend;
				cheapestHotel=hotel;
			}
		}
		 System.out.println("\n"+"Cheapest Hotel Name for Weekend is  : " + cheapestHotel.getHotelName() + " and price of hotel is : " + lowestCost);
	}
}
