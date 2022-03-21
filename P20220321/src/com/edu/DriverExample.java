package com.edu;

public class DriverExample {
    public static void main(String[] args) {

	Vehicle v1 = new Vehicle();
	v1 = new Taxi();
	v1 = new Bus();

	Driver driver = new Driver();
	driver.drive(v1); // 매개변수의 다형성.

	Vehicle vehicle = new Vehicle();
	Taxi taxi = new Taxi();
	Bus bus = new Bus();

	System.out.println("Vehicle 최고속력: " + vehicle.getMaxSpeed());
	System.out.println("Taxi 최고속력: " + taxi.getMaxSpeed());
	System.out.println("Bus 최고속력: " + bus.getMaxSpeed());

	Vehicle[] vehicles = new Vehicle[3];
	vehicles[0] = vehicle;
	vehicles[1] = taxi;
	vehicles[2] = bus;

	// 속도가 제일 빨느 탈것의 정렬해서 vehicles[0] = taxi, vehicles[1] = bus, vehicles[2] =
	// vehicle
	vehicleArrSpeedSort(vehicles);

	System.out.println("가장 빠른 것> "+vehicles[0].toString());
	System.out.println("가장 느린 것> "+vehicles[2].toString());
    }

    public static void vehicleArrSpeedSort(Vehicle[] vehicles) {
	for (int i = 0; i < vehicles.length - 1; i++) {
	    for (int j = i; j < vehicles.length; j++) {
		if (vehicles[i].getMaxSpeed() < vehicles[j].getMaxSpeed()) {
		    Vehicle tempV = vehicles[i];
		    vehicles[i] = vehicles[j];
		    vehicles[j] = tempV;
		}
	    }
	}

    }
    
}
