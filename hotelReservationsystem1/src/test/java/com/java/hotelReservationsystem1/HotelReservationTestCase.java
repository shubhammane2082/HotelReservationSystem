package com.java.hotelReservationsystem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationTestCase {
	Hotel hotel=new Hotel();
	HotelMain hotelmain=new HotelMain();
	
	@Test
	public void test() 
	{
		String HotelName="vikas";
		hotel.setHotelName(HotelName);
		int price=200;
		hotel.setPrice(price);
		assertEquals(HotelName, hotel.getHotelName());
		assertEquals(price, hotel.getPrice());
	}
}
