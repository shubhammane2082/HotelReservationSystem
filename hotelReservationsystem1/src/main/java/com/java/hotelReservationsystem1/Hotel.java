package com.java.hotelReservationsystem1;

public class Hotel 
{
	private String hotelName;
	private int weekDayprice;
	private int weekEndprice;
	private double hotel_rating;
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getWeekDayprice() {
		return weekDayprice;
	}
	public void setWeekDayprice(int weekDayprice) {
		this.weekDayprice = weekDayprice;
	}
	public int getWeekEndprice() {
		return weekEndprice;
	}
	public void setWeekEndprice(int weekEndprice) {
		this.weekEndprice = weekEndprice;
	}
	public double getHotel_rating() {
		return hotel_rating;
	}
	public void setHotel_rating(double hotel_rating) {
		this.hotel_rating = hotel_rating;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekDayprice=" + weekDayprice + ", weekEndprice=" + weekEndprice
				+ ", hotel_rating=" + hotel_rating + "]";
	}
}
