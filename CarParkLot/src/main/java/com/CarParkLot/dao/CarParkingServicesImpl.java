package com.CarParkLot.dao;

import java.util.ArrayList;
import java.util.List;

import com.CarParkLot.model.Car;
import com.CarParkLot.model.Car_ParkingSlot;
import com.CarParkLot.model.ParkingSlot;

public class CarParkingServicesImpl implements CarParkingServices {   
	 static List<ParkingSlot>parkingSlotList=new ArrayList<ParkingSlot>();
	 static List<Car_ParkingSlot>Car_parkingSlotList=new ArrayList<Car_ParkingSlot>();
		public  void createParkingSlot(int capacity) {
			// TODO Auto-generated method stub
			  for(int i=0;i<capacity;i++)
			  {
				  ParkingSlot slot=new ParkingSlot();
				  slot.setParkingSlot_no(i);
				  parkingSlotList.add(slot);
			  }
    }
		public List<ParkingSlot> getAllPrkingSlot() {
			// TODO Auto-generated method stub
			return parkingSlotList;
		}
		public String parkCar(Car car, ParkingSlot slot) {
			// TODO Auto-generated method stub
			Car_ParkingSlot parkingSlot=new Car_ParkingSlot();
			parkingSlot.setCar(car);
			parkingSlot.setSlot(slot);
			Car_parkingSlotList.add(parkingSlot);
			return car.getCar_no()+" Car Park In "+slot.getParkingSlot_no();
		}
		public List<Car_ParkingSlot> getParkingStatus() {
			// TODO Auto-generated method stub
			return Car_parkingSlotList;
		}
}
