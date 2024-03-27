package com.java.hotelReservationsystem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class HotelReservationTestCase {
	Hotel hotel=new Hotel();
	HotelMain hotelmain=new HotelMain();
	//1 test case
	@Test
	public void AddHotelTestCase() 
	{	
		String HotelName="Lukewood";
		hotel.setHotelName(HotelName);
		int price=200;
		hotel.setPrice(price);
		assertEquals(HotelName, hotel.getHotelName());
		assertEquals(price, hotel.getPrice());
	}
	
	//2nd Test case
	@Test
	public void calculateHotelrateTestCase() 
	{
		Hotel hotel1=new Hotel();
		Hotel hotel2=new Hotel();
		
		String hotelName1="Lukewoood";
		int price1=100;
		hotel1.setHotelName(hotelName1);
		hotel1.setPrice(price1);
		
		String hotelName2="David";
		int price2=200;
		hotel2.setHotelName(hotelName2);
		hotel2.setPrice(price2);
		
		List<Hotel> hotelList=new ArrayList<Hotel>();
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		
		LocalDate startDate=LocalDate.of(2024, 3, 1);
		LocalDate endDate=LocalDate.of(2024, 4, 2);
		
		long countDays = ChronoUnit.DAYS.between(startDate, endDate);
		long expectLowestcost=countDays * hotel1.getPrice();
		
		 assertEquals(hotelName1, hotel1.getHotelName());
		 assertEquals(expectLowestcost, hotel1.getPrice() * countDays);
	}
	
	@Test
	public void AddWeekPricesTestCase() 
	{	
		String HotelName="Lukewood";
		int weekDayprice=110;
		int weekEndprice=90;
		int price=200;
		hotel.setHotelName(HotelName);
		hotel.setPrice(price);
		hotel.setWeekDayprice(weekDayprice);
		hotel.setWeekEndprice(weekEndprice);
		assertEquals(HotelName, hotel.getHotelName());
		assertEquals(price, hotel.getPrice());
		assertEquals(weekEndprice, hotel.getWeekEndprice());
		assertEquals(weekDayprice, hotel.getWeekDayprice());
	}
}
