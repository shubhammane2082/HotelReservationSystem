package com.java.hotelReservationsystem1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class HotelMain {
	static List<Hotel> hotelList=new ArrayList<Hotel>();
	static Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args) throws HotelException 
	{
		HotelMain hotelmain=new HotelMain();
		System.out.println("Welcome to Hotel Reservation System..."+"\n");
	     int choice;
	     
	     do {
	    	 System.out.println("0.Exit\n1.add Hotel\n2.cheapest hotel rate for time period\n3.Hotel List\n4.find hotel rates for weekend\n"
	    	 		+ "5.find the hotels with cheapest hotel best rating\n6.find best rating hotels\n7.find best rating hotel for Reward customer\n"
	    	 		+ "8.find Best Rating for Reward Customer"
	    	 		+ " \n");
	    	 System.out.println("Enter your choice : ");
	    	 choice=sc.nextInt();
	    	 
	    	 switch(choice)
	    	 {
	    	    case 0 :
	    	    	System.out.println("Exiting the Application...\n");
	    	    	break;
	    	    
	    	    case 1: 
	    	    	AddHotel.addHotel(sc,hotelList);
	    	    	break;
	    	    	
	    	    case 2 :
	    	    	CalculateHotelRate.calculateHotelrate(sc,hotelList);
	    	    	break;
	    	    	
	    	    case 3: 
	    	    	GetList.getAlllist(hotelList);
	    	    	break;
	    	    
	    	    case 4:
	    	    	CalculateHotelRateforWeekEnd.calculateHotelrateforweekEnd(sc, hotelList);
	    	    	break;
	    	    	
	    	    case 5: 	
	    	    	calculateHotelwihtbestrating.calculateHotelwihtbestRating(sc, hotelList);
	    	    	break;
	    	    	
	    	    case 6:
	    	    	FindBestedRatedHotel.findBestRatedhotel(sc,hotelList);
	    	    	break;
	    	    	
	    	    case 7 :
	    	    	FindcheapestHotelforRewardCustomer.findcheapestHotelforRewardCustomer(sc,hotelList);
	    	    	break;
	    	    
	    	    case 8:
	    	    	 FindcheapestHotelforRewardCustomerUsingStream.FindcheapestHotelforRewardCustomerUsingStream1(sc,hotelList);
	    	    	 break;
	    	    	
	    	    default :
	    	    	System.out.println("Invalid Choice...");
	    	    	break;
	    	 }
	     }while(choice!=0);
	     
	}
}
