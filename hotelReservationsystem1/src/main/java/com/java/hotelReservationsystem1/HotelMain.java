package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
	    	 System.out.println("0.Exit 1.add Hotel 2.cheapest hotel rate for time period 3.Hotel List \n");
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
	    	    default :
	    	    	System.out.println("Invalid Choice...");
	    	    	break;
	    	 }
	     }while(choice!=0);
	}
	public void calculateHotelrate(LocalDate startDate, LocalDate endDate, List<Hotel> hotelList) {
	    Hotel cheapestHotel = hotelList.get(0);
	    long lowestCost = Long.MAX_VALUE;
	    long countDays = ChronoUnit.DAYS.between(startDate, endDate);

	    for (int i = 0; i < hotelList.size(); i++) {
	        Hotel hotel = hotelList.get(i);
	        long totalCost = countDays * hotel.getPrice();
	        if (totalCost < lowestCost) {
	            lowestCost = totalCost;
	            cheapestHotel = hotel;
	        }
	    }

	    System.out.println("Cheapest Hotel Name is: " + cheapestHotel.getHotelName() + " and price is: " + lowestCost);
	}

	private void getAlllist() 
	{
		for (int i = 0; i < hotelList.size(); i++) 
		{
			Hotel hotel=hotelList.get(i);
			System.out.println("Hotel name is : "+hotel.getHotelName());
			System.out.println("Hotel Dish price is : "+hotel.getPrice());
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
		
		System.out.println("Enter the Dish price : ");
		int price=sc.nextInt();
		hotel.setPrice(price);
		
		System.out.println("Enter the Price for week Day is : ");
		int weekDayprice=sc.nextInt();
		hotel.setWeekDayprice(weekDayprice);
		
		System.out.println("Enter the price for week End is : ");
		int weekEndprice=sc.nextInt();
		hotel.setWeekEndprice(weekEndprice);
		
		hotelList.add(hotel);
		System.out.println(hotelList);
		System.out.println("Hotel added Sucessfully...");
	}

}
