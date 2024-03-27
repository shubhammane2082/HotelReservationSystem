package com.java.hotelReservationsystem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelMain {
	static List<Hotel> hotelList=new ArrayList<Hotel>();
	static Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args) 
	{
		HotelMain hotelmain=new HotelMain();
		System.out.println("Welcome to Hotel Reservation System...");
	     int choice;
	     
	     do {
	    	 System.out.println("0.Exit 1.add Hotel");
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
	    	    	
	    	    default :
	    	    	System.out.println("Invalid Choice...");
	    	    	break;
	    	 }
	     }while(choice!=0);
	}
	public void addHotel() 
	{
		Hotel hotel=new Hotel();
		System.out.println("Enter the hotel name : ");
		String hotelName=sc.next();
		hotel.setHotelName(hotelName);
		
		System.out.println("Enter the Dish Price : ");
		int price=sc.nextInt();
		if(price > 0)
		hotel.setPrice(price);
		else {
			System.out.println("Price is not negative...");
		     return;
		}
		
		hotelList.add(hotel);
		System.out.println(hotelList);
	}

}
