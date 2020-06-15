package com.CarParkLot.dao;

import java.util.List;

import com.CarParkLot.model.Car;
import com.CarParkLot.model.Car_ParkingSlot;
import com.CarParkLot.model.ParkingSlot;

public interface CarParkingServices {
	void createParkingSlot(int capacity);
    List<ParkingSlot> getAllPrkingSlot();
    String parkCar(Car car,ParkingSlot slot);
    List<Car_ParkingSlot> getParkingStatus();
	
}
