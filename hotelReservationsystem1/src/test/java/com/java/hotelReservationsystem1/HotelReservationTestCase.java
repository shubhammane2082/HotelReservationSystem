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
		hotel.setWeekDayprice(price);
		assertEquals(HotelName, hotel.getHotelName());
		assertEquals(price, hotel.getWeekDayprice());
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
		hotel1.setWeekDayprice(price1);
		
		String hotelName2="David";
		int price2=200;
		hotel2.setHotelName(hotelName2);
		hotel2.setWeekDayprice(price2);
		
		List<Hotel> hotelList=new ArrayList<Hotel>();
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		
		LocalDate startDate=LocalDate.of(2024, 3, 1);
		LocalDate endDate=LocalDate.of(2024, 4, 2);
		
		long countDays = ChronoUnit.DAYS.between(startDate, endDate);
		long expectLowestcost=countDays * hotel1.getWeekDayprice();
		
		 assertEquals(hotelName1, hotel1.getHotelName());
		 assertEquals(expectLowestcost, hotel1.getWeekDayprice() * countDays);
	}
	
	//3rd Test case
	@Test
	public void AddWeekPricesTestCase() 
	{	
		String HotelName="Lukewood";
		int weekDayprice=110;
		int weekEndprice=90;
		
		hotel.setHotelName(HotelName);
		hotel.setWeekDayprice(weekDayprice);
		hotel.setWeekEndprice(weekEndprice);
		
		assertEquals(HotelName, hotel.getHotelName());
		assertEquals(weekEndprice, hotel.getWeekEndprice());
		assertEquals(weekDayprice, hotel.getWeekDayprice());
	}
	
	//4th Test case
	@Test
	public void calculateHotelrateforweekEndTestcase() 
	{
		LocalDate startDate=LocalDate.of(2000, 8, 20);
		LocalDate endDate=LocalDate.of(2000, 9, 20);
		
		List<Hotel> hotelList = new ArrayList<>();
		
		Hotel hotel1=new Hotel();
		Hotel hotel2=new Hotel();
		
		hotel1.setHotelName("Lukewood");
		hotel1.setWeekDayprice(110);
		hotel1.setWeekEndprice(90);
		
		hotel2.setHotelName("Bridgewood");
		hotel2.setWeekDayprice(150);
		hotel2.setWeekEndprice(50);
		
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		
		Hotel cheapestHotel = new Hotel();
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
	    assertEquals("Lukewood", cheapestHotel.getHotelName());
	    assertEquals(3410, lowestCost);
	}
	
	@Test
	public void addRatingtestcase() 
	{
		String HotelName1="Lukewood";
		int weekDayprice1=110;
		int weekEndprice1=90;
		double hotelRating1=3.0;
		
		hotel.setHotelName(HotelName1);
		hotel.setWeekDayprice(weekDayprice1);
		hotel.setWeekEndprice(weekEndprice1);
		hotel.setHotel_rating(hotelRating1);
	}
	
	
	
	
}
