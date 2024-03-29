package com.java.hotelReservationsystem1;

import java.util.List;

public class GetList 
{
	public static void getAlllist(List<Hotel> hotelList) 
	{
		for (int i = 0; i < hotelList.size(); i++) 
		{
			Hotel hotel=hotelList.get(i);
			System.out.println("Hotel name is : "+hotel.getHotelName());
			System.out.println("Hotel price for week Day is : "+hotel.getWeekDayprice());
			System.out.println("Hotel price for week end is : "+hotel.getWeekEndprice());
			System.out.println("Hotel Price for Reward Customer Week Day is : "+hotel.getRewardweekDay());
			System.out.println("Hotel Price for Reward Customer Week Day is : "+hotel.getRewardweekEnd());
			System.out.println("-----------------------------------------");
	   }
	}
	
}
