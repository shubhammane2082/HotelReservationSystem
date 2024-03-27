package com.java.hotelReservationsystem1;

public class Hotel 
{
	private String hotelName;
	private int weekDayprice;
	private int weekEndprice;
	
	
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekDayprice=" + weekDayprice + ", weekEndprice=" + weekEndprice
				+ "]";
	}
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
	
	
	
	
}
