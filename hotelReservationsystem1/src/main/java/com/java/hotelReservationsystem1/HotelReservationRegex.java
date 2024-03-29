package com.java.hotelReservationsystem1;

import java.util.regex.Pattern;

public class HotelReservationRegex 
{
	public boolean validfirstName(Hotel hotel,String hotelName)
	{
          String regexpatternhotelName="^[A-Z]{1}[a-zA-Z0-9]{5,}$";
		
		if(Pattern.matches(regexpatternhotelName, hotelName))
		{
			hotel.setHotelName(hotelName);
			return true;
		}
		else {
			System.out.println("Please Enter Valid Hotel Name...\n");
			return false;
		}
	}
	
	public boolean regularweekDayprice(Hotel hotel,int regularweekDayprice)
	{
		if(regularweekDayprice >= 0)
		{
			hotel.setWeekDayprice(regularweekDayprice);
			return true;
		}
		else {
				System.out.println("You have to enter positive weekDay price...");
				return false;
		}
	}
	
	public boolean regularweekEndprice(Hotel hotel,int regularweekEndprice)
	{
		if(regularweekEndprice >= 0)
		{
			hotel.setWeekDayprice(regularweekEndprice);
			return true;
		}
		else {
				System.out.println("You have to enter positive weekDay price...");
				return false;
		}
	}
	
	public boolean hotelrating(Hotel hotel,double rating)
	{
		if(rating >= 0)
		{
			hotel.setHotel_rating(rating);
			return true;
		}
		else {
			System.out.println("You Can Enter Only Positive Rating or Zero...");
			return false;
		}
	}
}
