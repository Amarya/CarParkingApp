package com.CarParkLot;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.CarParkLot.dao.CarParkingServicesImpl;
import com.CarParkLot.model.Car;
import com.CarParkLot.model.Car_ParkingSlot;
import com.CarParkLot.model.ParkingSlot;

public class CarParkManager {
    static CarParkingServicesImpl servicesImpl;
   static{
	   servicesImpl=new CarParkingServicesImpl();
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		adminMenu();
         
	}

	private static void adminMenu() {
		// TODO Auto-generated method stub
		 /**************************************/
		System.out.println("Enter Your Choice");
        Scanner sc=new Scanner(System.in);
        int ch=0;
        int capacity=0;
        String car_no;
        while(true)
        {
       	     System.out.println();
             System.out.println("1. Create a Parking Slot");             
             System.out.println("2. Park Car");
             System.out.println("3. Status of Parking");
             System.out.println("4. UnPark Car");         
             System.out.println("0. Exit Program");
             ch=sc.nextInt();
             
             switch (ch) {
			    case 1:
				   System.out.println("---Create a Parking Slot---");
				   System.out.println("Enter capacity to Create Parking Slot");
				    capacity=sc.nextInt();
				   servicesImpl.createParkingSlot(capacity);
				break;
				case 2:
					try{
					 System.out.println("---Park Car---");
					 Set<Integer>availableSlots=servicesImpl.getAvailableSlots();
					 if(availableSlots.isEmpty())
						 System.out.println("Sorry Parking Full Plz Wait");
					 else
					 System.out.println("Available Slots");
					 int time=java.time.LocalTime.now().getHour();
					 for(Integer i:availableSlots)
					 {
						 System.out.println(i);
					 }
					 TreeSet<Integer>availableSlotsSet=new TreeSet<Integer>(availableSlots);
					 int entrySlotNo=availableSlotsSet.pollFirst();
					 System.out.println("entrySlotNo:"+entrySlotNo);
					  System.out.println("Enter Car Number");
					   car_no=sc.next();
					  System.out.println("Enter Car Color");
					  String car_color=sc.next();
					  Car car=new Car();
					  car.setCar_no(car_no);
					  car.setCar_color(car_color);
					  
					  ParkingSlot slot=new ParkingSlot();
					  slot.setParkingSlot_no(entrySlotNo);
					  String status=servicesImpl.parkCar(car, slot,time);
					  System.out.println(status);
					}catch (Exception e) {
						// TODO: handle exception
						//System.out.println(e);
					}
				break;
				case 3:
					 System.out.println("---Status of Parking---");
					 List<ParkingSlot>slotList=servicesImpl.getAllPrkingSlot();
					 System.out.println("---Slots Details---");
					 for(ParkingSlot parkingSlot:slotList)
						 System.out.println("SLOT:"+parkingSlot.getParkingSlot_no());
					    System.out.println("---Parking Status---");
					    List<Car_ParkingSlot>car_slotLsat=servicesImpl.getParkingStatus();
					    System.out.println("CAR NO"+"\t"+"SLOT NO"+"\t"+"Park Time");
					    for(Car_ParkingSlot parkingSlot:car_slotLsat)
					    System.out.println(parkingSlot.getCar().getCar_no()+"\t"+parkingSlot.getSlot().getParkingSlot_no()+"\t"+parkingSlot.getParkTime());
					    System.out.println("Available Slots");
					    Set<Integer>availableSlots=servicesImpl.getAvailableSlots();
						 if(availableSlots.isEmpty())
							 System.out.println("Sorry Parking Full Plz Wait");
						 else
						 for(Integer i:availableSlots)
						 {
							 System.out.println(i);
						 }
					    break;
				case 4:
					 try{
					 System.out.println("---UnPark Car---");
					 System.out.println("Enter car Number to UnPark");
					 car_no=sc.next();
					 Car_ParkingSlot car_ParkingSlot=servicesImpl.unParkCarDetail(car_no);
					 if(car_ParkingSlot==null)
					 {
						 System.out.println("Car Not Avilable");
					 }
					 else
					 {
					 System.out.println("--Car Detail--");
					 System.out.println("CAR NO:"+car_ParkingSlot.getCar().getCar_no());
					 System.out.println("CAR COLOR:"+car_ParkingSlot.getCar().getCar_color());
					 System.out.println("SLOT NO:"+car_ParkingSlot.getSlot().getParkingSlot_no());
					 System.out.println("PARKING TIME:"+car_ParkingSlot.getParkTime());
					 int cHrs=java.time.LocalTime.now().getHour();
					 int pHrs=car_ParkingSlot.getParkTime();
					 if(cHrs==pHrs)
						 System.out.println("PARKING CHARGES:"+10+"$");
					 else
						 System.out.println("PARKING CHARGES:"+((cHrs-pHrs)*10)+"$");
					 servicesImpl.unParkCar(car_no);
					    System.out.println("CAR NO "+car_ParkingSlot.getCar().getCar_no()+" Unpark");
					 }
					 }catch (Exception e) {
							// TODO: handle exception
						 //System.out.println(e);
						}
					break;
				case 0:
					 System.out.println("---Exit---");
					  System.exit(0);
					break;
			default:
				 System.err.println("\nYou have entered an invalid option!");
                System.out.println();
                adminMenu();
                break;
			}
        }//
		/****************************************/
	}
}
