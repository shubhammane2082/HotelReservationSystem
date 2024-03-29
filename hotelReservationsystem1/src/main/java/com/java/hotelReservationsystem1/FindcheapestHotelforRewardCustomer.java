package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class FindcheapestHotelforRewardCustomer {
	
	public static void findcheapestHotelforRewardCustomer(Scanner sc, List<Hotel> hotelList) throws HotelException 
	{
		 String startDatestr = null,endDatestr = null;
		 LocalDate startDate = null,endDate = null;
		try 
		{
			 System.out.println("Enter the start date in (yyyy-mm-dd) : ");
			 startDatestr = sc.next();
			 startDate = LocalDate.parse(startDatestr, DateTimeFormatter.ISO_DATE);

		     System.out.println("Enter the end date in (yyyy-mm-dd) : ");
			 endDatestr = sc.next();
			 endDate = LocalDate.parse(endDatestr, DateTimeFormatter.ISO_DATE);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Date Format...Please enter valid date in format 'yyyy-mm-dd'");
			return;
		}
		 Hotel bestRatedHotel=hotelList.get(0);
		 double cheapestRate=Double.MAX_VALUE;
		 long countDays=ChronoUnit.DAYS.between(startDate, endDate);
		 
			  for(int i=0;i<hotelList.size();i++)
			  {
				  Hotel hotel=hotelList.get(i);
				  double totalRate=countDays * hotel.getRewardweekEnd();
				  
				  if(hotel.getHotel_rating() >= bestRatedHotel.getHotel_rating() || (hotel.getHotel_rating() == bestRatedHotel.getHotel_rating() && totalRate < cheapestRate))
				  {
					  bestRatedHotel=hotel;
					  cheapestRate=totalRate;
				  }
			  }
			  System.out.println("Best Rated hotel for : "+startDatestr+" to "+endDatestr+"is : "+bestRatedHotel.getHotelName()+" Rating : "+bestRatedHotel.getHotel_rating()+
					  " and Total Rates is : "+cheapestRate);
		}
}

