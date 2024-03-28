package com.java.hotelReservationsystem1;

public class Hotel 
{
	private String hotelName;
	private int weekDayprice;
	private int weekEndprice;
	private double hotel_rating;
	private int RewardweekDay;
	private int RewardweekEnd;
	
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
	public int getRewardweekDay() {
		return RewardweekDay;
	}
	public void setRewardweekDay(int rewardweekDay) {
		RewardweekDay = rewardweekDay;
	}
	public int getRewardweekEnd() {
		return RewardweekEnd;
	}
	public void setRewardweekEnd(int rewardweekEnd) {
		RewardweekEnd = rewardweekEnd;
	}
	
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekDayprice=" + weekDayprice + ", weekEndprice=" + weekEndprice
				+ ", hotel_rating=" + hotel_rating + ", RewardweekDay=" + RewardweekDay + ", RewardweekEnd="
				+ RewardweekEnd + "]";
	}
}
	
	
