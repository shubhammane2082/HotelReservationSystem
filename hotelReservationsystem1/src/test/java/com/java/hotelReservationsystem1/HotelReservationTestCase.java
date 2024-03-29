package com.java.hotelReservationsystem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	//5th Test Case
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
	
	//6th case
	@Test
	public void calculateHotelwihtbestratingTestcase() 
	{
		Hotel hotel1=new Hotel();
		Hotel hotel2=new Hotel();
		List<Hotel> hotelList=new ArrayList<>();
		
		hotel1.setHotelName("Lukewood");
		hotel1.setWeekDayprice(110);
		hotel1.setWeekEndprice(90);
		hotel1.setHotel_rating(3.0);
		
		hotel2.setHotelName("Bridgewood");
		hotel2.setWeekDayprice(200);
		hotel2.setWeekEndprice(50);
		hotel2.setHotel_rating(4.0);
		
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		
		LocalDate startDate=LocalDate.of(2000, 8, 20);
		LocalDate endDate=LocalDate.of(2000, 9, 20);
		
		long countDays=ChronoUnit.DAYS.between(startDate, endDate);
		Hotel cheapestHotel = hotelList.get(0);
        Hotel bestRatedHotel = null;
        
        for (Hotel hotel : hotelList) 
        {
            if (hotel.getHotel_rating() >= 4) {
                if (bestRatedHotel == null || hotel.getHotel_rating() > bestRatedHotel.getHotel_rating()) {
                    bestRatedHotel = hotel;
                }
            }
            if (hotel.getWeekDayprice() < cheapestHotel.getWeekDayprice()) {
                cheapestHotel = hotel;
            }
        }
        
        assertEquals("Bridgewood", bestRatedHotel.getHotelName());
        assertEquals(4.0, bestRatedHotel.getHotel_rating(),0.001);
        assertEquals(200.0 * countDays, bestRatedHotel.getWeekDayprice() * countDays, 0.001);
     }
	
	//7 th Test case
	@Test
	public void findBestRateghotelTestcase() 
	{
		Hotel hotel1=new Hotel();
		Hotel hotel2=new Hotel();
		Hotel hotel3=new Hotel();
		List<Hotel> hotelList=new ArrayList<>();
		
		hotel1.setHotelName("Lukewood");
		hotel1.setWeekDayprice(110);
		hotel1.setWeekEndprice(90);
		hotel1.setHotel_rating(3.0);
		
		hotel2.setHotelName("Bridgewood");
		hotel2.setWeekDayprice(150);
		hotel2.setWeekEndprice(50);
		hotel2.setHotel_rating(4.0);
		
		hotel3.setHotelName("Riverwood");
		hotel3.setWeekDayprice(220);
		hotel3.setWeekEndprice(150);
		hotel3.setHotel_rating(5.0);
		
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		
		assertEquals("Riverwood", hotel3.getHotelName());
		assertEquals(5.0, hotel3.getHotel_rating(),0.001);
	}
	
	//8th Test case
	@Test
	public void checkRewardweekDayEndTestCase() 
	{
		List<Hotel> hotelList=new ArrayList<>();
		
		Hotel hotel=new Hotel();
		
		hotel.setHotelName("Lukewood");
		hotel.setWeekDayprice(110);
		hotel.setWeekEndprice(90);
		hotel.setHotel_rating(3.0);
		hotel.setRewardweekDay(80);
		hotel.setRewardweekEnd(80);
		
		hotelList.add(hotel);
		
		assertEquals("Lukewood", hotel.getHotelName());
		assertEquals(110, hotel.getWeekDayprice());
		assertEquals(90, hotel.getWeekEndprice());
		assertEquals(3.0, hotel.getHotel_rating(),0.1);
		assertEquals(80, hotel.getRewardweekDay());
		assertEquals(80, hotel.getRewardweekEnd());
	}
	
	    //9th Test Case
		@Test
		public void findcheapestHotelforRewardCustomerTestcase() 
		{
			Hotel hotel1=new Hotel();
			Hotel hotel2=new Hotel();
			Hotel hotel3=new Hotel();
			List<Hotel> hotelList=new ArrayList<>();
			
			hotel1.setHotelName("Lukewood");
			hotel1.setWeekDayprice(110);
			hotel1.setWeekEndprice(90);
			hotel1.setHotel_rating(3.0);
			hotel1.setRewardweekEnd(80);
			
			hotel2.setHotelName("Bridgewood");
			hotel2.setWeekDayprice(150);
			hotel2.setWeekEndprice(50);
			hotel2.setHotel_rating(4.0);
			hotel2.setRewardweekEnd(40);
			
			hotelList.add(hotel1);
			hotelList.add(hotel2);
			
			LocalDate startDate2 = LocalDate.of(2020, 9, 11);
	        LocalDate endDate2 = LocalDate.of(2020, 9, 12);
	        
			Hotel bestRatedHotel=hotelList.get(0);
			  double cheapestRate=Double.MAX_VALUE;
			  long countDays=ChronoUnit.DAYS.between(startDate2, endDate2);
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
			 assertEquals("Bridgewood", bestRatedHotel.getHotelName());
			 assertEquals(4.0, bestRatedHotel.getHotel_rating(),0.1);
			 assertEquals(40.0,cheapestRate,0.1);
		}
		
		//10th Test case
		@Test
		public void FindcheapestHotelforRewardCustomerUsingStreamTestCase()
		{
			LocalDate startDate = LocalDate.of(2020, 9, 11);
	        LocalDate endDate = LocalDate.of(2020, 9, 12);
	        
	        Hotel hotel1=new Hotel();
			Hotel hotel2=new Hotel();
			List<Hotel> hotelList=new ArrayList<>();
			
			hotel1.setHotelName("Lukewood");
			hotel1.setWeekDayprice(110);
			hotel1.setWeekEndprice(90);
			hotel1.setHotel_rating(3.0);
			hotel1.setRewardweekEnd(80);
			
			hotel2.setHotelName("Bridgewood");
			hotel2.setWeekDayprice(150);
			hotel2.setWeekEndprice(50);
			hotel2.setHotel_rating(4.0);
			hotel2.setRewardweekEnd(40);
			
			hotelList.add(hotel1);
			hotelList.add(hotel2);
			
			long countBydays=ChronoUnit.DAYS.between(startDate, endDate);
			
			Optional<Hotel> bestratedHotel = hotelList.stream().reduce((h1,h2)-> 
			{
				double totalRate1=hotelList.stream().mapToDouble(hotel3 -> countBydays * h1.getRewardweekEnd()).sum();
				double totalRate2=hotelList.stream().mapToDouble(hotel -> countBydays * h2.getRewardweekEnd()).sum();
				
				if(h1.getHotel_rating() >= h2.getHotel_rating() || (h1.getHotel_rating() == h2.getHotel_rating() && totalRate1<totalRate2))
					return h1;
				else
					return h2;
			});
			
			bestratedHotel.ifPresent(h1 -> {
				double cheapestHotel=countBydays * h1.getRewardweekEnd();
				assertEquals("Bridgewood", h1.getHotelName());
				assertEquals(4.0, h1.getHotel_rating(),0.01);
				assertEquals(40.0, cheapestHotel,0.1);
			});
		}
}
