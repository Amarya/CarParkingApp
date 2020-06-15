package com.CarParkLot;

import java.util.List;
import java.util.Scanner;

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
				   int capacity=sc.nextInt();
				   servicesImpl.createParkingSlot(capacity);
				break;
				case 2:
					 System.out.println("---Park Car---");
					  System.out.println("Enter Car Number");
					  String car_no=sc.next();
					  String car_color=sc.next();
					  Car car=new Car();
					  car.setCar_no(car_no);
					  car.setCar_color(car_color);
					  
					  ParkingSlot slot=new ParkingSlot();
					  slot.setParkingSlot_no(2);
					  String status=servicesImpl.parkCar(car, slot);
					  System.out.println(status);
				break;
				case 3:
					 System.out.println("---Status of Parking---");
					 List<ParkingSlot>slotList=servicesImpl.getAllPrkingSlot();
					 System.out.println("---Slots Details---");
					 for(ParkingSlot parkingSlot:slotList)
						 System.out.println("SLOT:"+parkingSlot.getParkingSlot_no());
					    System.out.println("---Parking Status---");
					    List<Car_ParkingSlot>car_slotLsat=servicesImpl.getParkingStatus();
					    for(Car_ParkingSlot parkingSlot:car_slotLsat)
					    	System.out.println(parkingSlot.getCar().getCar_no()+" "+parkingSlot.getSlot().getParkingSlot_no());
					break;
				case 4:
					 System.out.println("---UnPark Car---");
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
