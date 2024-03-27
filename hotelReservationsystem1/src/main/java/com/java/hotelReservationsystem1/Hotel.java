package com.java.hotelReservationsystem1;

public class Hotel 
{
	private String hotelName;
	private int price;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", price=" + price + "]";
	}
	
	
}
