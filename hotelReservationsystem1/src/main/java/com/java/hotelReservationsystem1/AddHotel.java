package com.java.hotelReservationsystem1;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddHotel 
{
	static Hotel hotel=new Hotel();
	static HotelReservationRegex hotelReservationRegex=new HotelReservationRegex();
	public static void addHotel(Scanner sc,List<Hotel> hotelList) 
	{
		System.out.println("Enter the hotel name : ");
		String hotelName=sc.next();
		boolean result1=hotelReservationRegex.validfirstName(hotel,hotelName);
		
		if(!result1)
			return;
		
		System.out.println("Enter the Price for Regular week Day is : ");
		int regularweekDayprice=sc.nextInt();
		boolean result2=hotelReservationRegex.regularweekDayprice(hotel,regularweekDayprice);
		
		if(!result2)
			return;
		
		System.out.println("Enter the price for Regular week End is : ");
		int regularweekEndprice=sc.nextInt();
		boolean result3=hotelReservationRegex.regularweekEndprice(hotel, regularweekEndprice);
		
		if(!result3)
			return;
		
		System.out.println("Enter the rating for hotel : ");
		double rating=sc.nextDouble();
		boolean result6=hotelReservationRegex.hotelrating(hotel, rating);
		
		if(!result6)
			return;
		
		System.out.println("Enter the Price for Reward weekDay is : ");
		int rewardweekDayprice=sc.nextInt();
        boolean result4=hotelReservationRegex.regularweekDayprice(hotel, rewardweekDayprice);
		
		if(!result4)
			return;
		
		System.out.println("Enter the price for Regular week End is : ");
		int rewardweekEndprice=sc.nextInt();
		 boolean result5=hotelReservationRegex.regularweekEndprice(hotel, rewardweekEndprice);
			
			if(!result5)
				return;
			
		hotelList.add(hotel);
		System.out.println("Hotel added Sucessfully...");
	}
}
