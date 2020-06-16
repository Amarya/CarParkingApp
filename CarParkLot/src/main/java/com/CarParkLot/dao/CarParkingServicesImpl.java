package com.CarParkLot.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.CarParkLot.model.Car;
import com.CarParkLot.model.Car_ParkingSlot;
import com.CarParkLot.model.ParkingSlot;

public class CarParkingServicesImpl implements CarParkingServices {   
	 static List<ParkingSlot>parkingSlotList=new ArrayList<ParkingSlot>();
	 static List<Car_ParkingSlot>car_parkingSlotList=new ArrayList<Car_ParkingSlot>();
	 
	 /********************create new slot***************/
		public  String createParkingSlot(int capacity) {
			// TODO Auto-generated method stub
			  for(int i=0;i<capacity;i++)
			  {
				  ParkingSlot slot=new ParkingSlot();
				  slot.setParkingSlot_no(i);
				  parkingSlotList.add(slot);
			  }
			  return "parking slot created";
    }
		/************************get All Parking slot detail***********************/
		public List<ParkingSlot> getAllPrkingSlot() {
			// TODO Auto-generated method stub
			return parkingSlotList;
		}
		/********************Park car inside Parking with Slot*************************/
		public String parkCar(Car car, ParkingSlot slot,int time) {
			// TODO Auto-generated method stub
			Car_ParkingSlot parkingSlot=new Car_ParkingSlot();
			parkingSlot.setCar(car);
			parkingSlot.setSlot(slot);
			parkingSlot.setParkTime(time);
			car_parkingSlotList.add(parkingSlot);
			return car.getCar_no()+" Car Park In Slot "+slot.getParkingSlot_no();
		}
		/*******************get current status of parking********************/
		public List<Car_ParkingSlot> getParkingStatus() {
			// TODO Auto-generated method stub
			return car_parkingSlotList;
		}
	/************************get Available slots*****************************/
		public Set<Integer> getAvailableSlots() {
			// TODO Auto-generated method stub
			Set<Integer>available_slot_List=new HashSet<Integer>();
			if(car_parkingSlotList.isEmpty()){
				System.out.println("All SLOTS ARE AVAILABLE");
				for(ParkingSlot slot:parkingSlotList)
					available_slot_List.add(slot.getParkingSlot_no());
			}
			else{
				try{
				List<ParkingSlot>dummyList=new ArrayList<ParkingSlot>();
				for(Car_ParkingSlot obj:car_parkingSlotList)
					dummyList.add(obj.getSlot());
				for(ParkingSlot slot:parkingSlotList)
				{
					int f=0;
					for(ParkingSlot dummy:dummyList)
					{
						if(dummy.getParkingSlot_no()==slot.getParkingSlot_no())
						{
							f=1;
							break;
						}
					}
					if(f==0)
						available_slot_List.add(slot.getParkingSlot_no());
					
				}
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
			return available_slot_List;
		}
		/**************unPark Car********************/
	public void unParkCar(String car_no) {
		// TODO Auto-generated method stub
		try{
		  int c=0;
		 for(Car_ParkingSlot car_ParkingSlot:car_parkingSlotList)
		 {
			 
			 if(car_ParkingSlot.getCar().getCar_no().equals(car_no))
			 {
				 car_parkingSlotList.remove(c);
				 break;
			 }
			 c++;
		 }
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	/**************unPark Car Detail********************/
	public Car_ParkingSlot unParkCarDetail(String car_no) {
		// TODO Auto-generated method stub
		 int c=0;
		try{
		 
		 for(Car_ParkingSlot car_ParkingSlot:car_parkingSlotList)
		 {
			 
			 if(car_ParkingSlot.getCar().getCar_no().equals(car_no))
			 {
				 break;
			 }
			 c++;
		 }
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return car_parkingSlotList.get(c);
	}
}
