package com.java.hotelReservationsystem1;

import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FindcheapestHotelforRewardCustomerUsingStream 
{
	public static void FindcheapestHotelforRewardCustomerUsingStream1(Scanner sc, List<Hotel> hotelList)
	{
		 String startDatestr,endDatestr;
		 LocalDate startDate,endDate;
		 System.out.println("Enter the start date in (yyyy-mm-dd) : ");
		 startDatestr = sc.next();
		 startDate = LocalDate.parse(startDatestr, DateTimeFormatter.ISO_DATE);
	     System.out.println("Enter the end date in (yyyy-mm-dd) : ");
		 endDatestr = sc.next();
		 endDate = LocalDate.parse(endDatestr, DateTimeFormatter.ISO_DATE);
		 
		 long countBydays=ChronoUnit.DAYS.between(startDate, endDate);
		 
		Optional<Hotel> bestratedHotel = hotelList.stream().reduce((h1,h2)-> 
		{
			double totalRate1=hotelList.stream().mapToDouble(hotel1 -> countBydays * h1.getRewardweekEnd()).sum();
			double totalRate2=hotelList.stream().mapToDouble(hotel2 -> countBydays * h2.getRewardweekEnd()).sum();
			
			if(h1.getHotel_rating() >= h2.getHotel_rating() || (h1.getHotel_rating() == h2.getHotel_rating() && totalRate1<totalRate2))
				return h1;
			else
				return h2;
		});
		
		bestratedHotel.ifPresent(h1 -> {
			double cheapestHotel=countBydays * h1.getRewardweekEnd();
			System.out.println("Hotel Name is : "+h1.getHotelName()+". Hotel Rating is : "+h1.getHotel_rating()+". Cheapest Hotel is : "+cheapestHotel);
		});
		
	}
}
