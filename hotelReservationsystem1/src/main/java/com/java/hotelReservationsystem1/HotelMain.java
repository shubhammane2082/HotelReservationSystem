package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelMain {
	static List<Hotel> hotelList=new ArrayList<Hotel>();
	static Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args) 
	{
		HotelMain hotelmain=new HotelMain();
		System.out.println("Welcome to Hotel Reservation System..."+"\n");
	     int choice;
	     
	     do {
	    	 System.out.println("0.Exit 1.add Hotel 2.cheapest hotel rate for time period 3.Hotel List 4.find hotel rates for weekend "
	    	 		+ "5.find the hotels with cheapest hotel best rate 6.find best rated hotels"
	    	 		+ " \n");
	    	 System.out.println("Enter your choice : ");
	    	 choice=sc.nextInt();
	    	 
	    	 switch(choice)
	    	 {
	    	    case 0 :
	    	    	System.out.println("Exiting the Application...");
	    	    	break;
	    	    
	    	    case 1: 
	    	    	hotelmain.addHotel();
	    	    	break;
	    	    	
	    	    case 2 :
	    	    	System.out.println("Enter the start date in (yyyy-mm-dd) : ");
	    	    	String startDatestr=sc.next();
	    	    	LocalDate startDate=LocalDate.parse(startDatestr, DateTimeFormatter.ISO_DATE);
	    	    	
	    	    	System.out.println("Enter the end date in (yyyy-mm-dd) : ");
	    	    	String endDatestr=sc.next();
	    	    	LocalDate endDate=LocalDate.parse(endDatestr, DateTimeFormatter.ISO_DATE);
	    	    	
	    	    	hotelmain.calculateHotelrate(startDate, endDate,hotelList);
	    	    	break;
	    	    	
	    	    case 3: 
	    	    	hotelmain.getAlllist();
	    	    	break;
	    	    
	    	    case 4:
	    	    	hotelmain.calculateHotelrateforweekEnd(hotelList);
	    	    	break;
	    	    	
	    	    case 5: 	
	    	    	hotelmain.calculateHotelwihtbestrating(hotelList);
	    	    	break;
	    	    	
	    	    case 6:
	    	    	hotelmain.findBestRatedhotel(hotelList);
	    	    	break;
	    	    	
	    	    default :
	    	    	System.out.println("Invalid Choice...");
	    	    	break;
	    	 }
	     }while(choice!=0);
	}
	
	public void findBestRatedhotel(List<Hotel> hotelList)
	{
		 System.out.println("Enter the start date in (yyyy-mm-dd) : ");
		 String startDatestr2 = sc.next();
		 LocalDate startDate2 = LocalDate.parse(startDatestr2, DateTimeFormatter.ISO_DATE);

		  System.out.println("Enter the end date in (yyyy-mm-dd) : ");
		  String endDatestr2 = sc.next();
		  LocalDate endDate2 = LocalDate.parse(endDatestr2, DateTimeFormatter.ISO_DATE);
		
		  Hotel bestRatedHotel = null;
		  for (Hotel hotel : hotelList) {
		     if (bestRatedHotel == null || hotel.getHotel_rating() > bestRatedHotel.getHotel_rating()) {
		                bestRatedHotel = hotel;
		            }
		        }

		        System.out.println("Best-rated hotel for " + startDate2 + " to " + endDate2 + ": " +
		                bestRatedHotel.getHotelName() + ", Rating: " + bestRatedHotel.getHotel_rating());
	}
		
	private void calculateHotelwihtbestrating(List<Hotel> hotelList) {
	    System.out.println("Enter the start date in (yyyy-mm-dd) : ");
	    String startDatestr2 = sc.next();
	    LocalDate startDate2 = LocalDate.parse(startDatestr2, DateTimeFormatter.ISO_DATE);

	    System.out.println("Enter the end date in (yyyy-mm-dd) : ");
	    String endDatestr2 = sc.next();
	    LocalDate endDate2 = LocalDate.parse(endDatestr2, DateTimeFormatter.ISO_DATE);
	    
	    long countDays=ChronoUnit.DAYS.between(startDate2, endDate2);
	    Hotel cheapestHotel = hotelList.get(0);
	    Hotel bestRatedHotel = null;

	    for (Hotel hotel : hotelList) {
	        if (hotel.getHotel_rating() >= 4) {
	            if (bestRatedHotel==null || hotel.getHotel_rating() > bestRatedHotel.getHotel_rating()) {
	                bestRatedHotel = hotel;
	            }
	        }
	        if (hotel.getWeekDayprice() < cheapestHotel.getWeekDayprice()) {
	            cheapestHotel = hotel;
	        }
	    }

	    if (bestRatedHotel != null) {
	        System.out.println("Best rate hotel name is: " + bestRatedHotel.getHotelName() +". Rating: " + bestRatedHotel.getHotel_rating() +". Total Rates: " + bestRatedHotel.getWeekDayprice()*countDays);
	    }
	}
	
	private void calculateHotelrateforweekEnd(List<Hotel> hotelList) 
	{
		System.out.println("Enter the start date in (yyyy-mm-dd) : ");
    	String startDatestr1=sc.next();
    	LocalDate startDate1=LocalDate.parse(startDatestr1, DateTimeFormatter.ISO_DATE);
    	
    	System.out.println("Enter the end date in (yyyy-mm-dd) : ");
    	String endDatestr1=sc.next();
    	LocalDate endDate1=LocalDate.parse(endDatestr1, DateTimeFormatter.ISO_DATE);
		Hotel cheapestHotel=new Hotel();
		long countBydays=ChronoUnit.DAYS.between(startDate1, endDate1);
		long lowestCost = Long.MAX_VALUE;
		
		for(int i=0;i<hotelList.size();i++)
		{
			Hotel hotel=hotelList.get(i);
			long totlacostforWeekend=countBydays * hotel.getWeekEndprice();
			
			if(totlacostforWeekend < lowestCost)
			{
				lowestCost=totlacostforWeekend;
				cheapestHotel=hotel;
			}
		}
		 System.out.println("\n"+"Cheapest Hotel Name for Weekend is  : " + cheapestHotel.getHotelName() + " and price of hotel is : " + lowestCost);
	}
	public void calculateHotelrate(LocalDate startDate, LocalDate endDate, List<Hotel> hotelList) {
	    Hotel cheapestHotel = hotelList.get(0);
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
	    System.out.println("Cheapest Hotel Name is: " + cheapestHotel.getHotelName() + ".Hotel price is: " + lowestCost +".Hotel rating is : "+cheapestHotel.getHotel_rating());
	}

	private void getAlllist() 
	{
		for (int i = 0; i < hotelList.size(); i++) 
		{
			Hotel hotel=hotelList.get(i);
			System.out.println("Hotel name is : "+hotel.getHotelName());
			System.out.println("Hotel price for week Day is : "+hotel.getWeekDayprice());
			System.out.println("Hotel price for week end is : "+hotel.getWeekEndprice());
			System.out.println("-----------------------------------------");
		}
	}
	public void addHotel() 
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
		hotel.setWeekEndprice(regularweekDayprice);
		
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
		System.out.println(hotelList);
		System.out.println("Hotel added Sucessfully...");
	}

}
