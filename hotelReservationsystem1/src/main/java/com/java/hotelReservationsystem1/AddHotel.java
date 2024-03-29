package com.java.hotelReservationsystem1;

import java.util.List;
import java.util.Scanner;

public class AddHotel 
{
	public static void addHotel(Scanner sc,List<Hotel> hotelList) 
	{
		Hotel hotel=new Hotel();
		System.out.println("Enter the hotel name : ");
		String hotelName=sc.next();
		hotel.setHotelName(hotelName);
		
		System.out.println("Enter the Price for Regular week Day is : ");
		int regularweekDayprice=sc.nextInt();
		hotel.setWeekDayprice(regularweekDayprice);
		
		System.out.println("Enter the price for Regular week End is : ");
		int regularweekEndprice=sc.nextInt();
		hotel.setWeekEndprice(regularweekEndprice);
		
		System.out.println("Enter the rating for hotel : ");
		double rating=sc.nextDouble();
		hotel.setHotel_rating(rating);
		
		System.out.println("Enter the Price for Reward weekDay is : ");
		int rewardweekDayprice=sc.nextInt();
		hotel.setRewardweekDay(rewardweekDayprice);
		
		System.out.println("Enter the price for Regular week End is : ");
		int rewardweekEndprice=sc.nextInt();
		hotel.setRewardweekEnd(rewardweekEndprice);
		
		hotelList.add(hotel);
		System.out.println("Hotel added Sucessfully...");
	}
}
