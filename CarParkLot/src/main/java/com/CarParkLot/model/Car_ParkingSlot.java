package com.CarParkLot.model;

public class Car_ParkingSlot {
    private Car car;
    private ParkingSlot slot;
    private int parkTime;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public ParkingSlot getSlot() {
		return slot;
	}
	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
	}
	public int getParkTime() {
		return parkTime;
	}
	public void setParkTime(int parkTime) {
		this.parkTime = parkTime;
	}
	
    
}
