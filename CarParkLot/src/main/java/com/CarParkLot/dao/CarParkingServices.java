package com.CarParkLot.dao;

import java.util.List;
import java.util.Set;

import com.CarParkLot.model.Car;
import com.CarParkLot.model.Car_ParkingSlot;
import com.CarParkLot.model.ParkingSlot;

public interface CarParkingServices {
	String createParkingSlot(int capacity);
    List<ParkingSlot> getAllPrkingSlot();
    String parkCar(Car car,ParkingSlot slot,int time);
    List<Car_ParkingSlot> getParkingStatus();
	Set<Integer>getAvailableSlots();
	void unParkCar(String car_no);
	Car_ParkingSlot unParkCarDetail(String car_no);
}
