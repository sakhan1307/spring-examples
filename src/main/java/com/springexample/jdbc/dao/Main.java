package com.springexample.jdbc.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-beans.xml");

        	 // You may test various parts of the system by uncommenting the following code
                VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
//                Vehicle newVehicle = new Vehicle("TEM0004", "Brown", 4, 4);
//                vehicleDao.insert(newVehicle);

//               VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
//              Vehicle vehicle = vehicleDao.findByVehicleNo("TEM0001");
//              System.out.println("Vehicle No: " + vehicle.getVehicleNo());
//             System.out.println("Color: " + vehicle.getColor());
//               System.out.println("Wheel: " + vehicle.getWheel());
//              System.out.println("Seat: " + vehicle.getSeat());

                //VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
//                Vehicle vehicle1 = new Vehicle("TEM0002", "Blue", 4, 4);
//                Vehicle vehicle2 = new Vehicle("TEM0003", "Black", 4, 6);
//                vehicleDao.insertBatch(
//                        Arrays.asList(new Vehicle[] { vehicle1, vehicle2 }));

               // VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
                List<Vehicle> vehicles = vehicleDao.findAll();
                for (Vehicle vehicle : vehicles) {
                    System.out.println("Vehicle No: " + vehicle.getVehicleNo());
                    System.out.println("Color: " + vehicle.getColor());
                    System.out.println("Wheel: " + vehicle.getWheel());
                    System.out.println("Seat: " + vehicle.getSeat());
                }

        //        VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
                int count = vehicleDao.countAll();
                System.out.println("Vehicle Count: " + count);
                String color = vehicleDao.getColor("TEM0001");
                System.out.println("Color for [TEM0001]: " + color);
    
        //       
       // VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
//        Vehicle vehicle = new Vehicle("TEM0003", "Green", 4, 4);
//        vehicleDao.update(vehicle);
              
//             Vehicle vehicle = vehicleDao.findByVehicleNo("TEM0004");
//             System.out.println("Vehicle No: " + vehicle.getVehicleNo());
//             vehicleDao.delete(vehicle);
    }
}
