package be.continuum;

import be.continuum.data.Address;
import be.continuum.data.Car;
import be.continuum.data.User;

public class Main {

    public static void main(final String[] args) {
        Car car = new Car();
        car.setBrand("VW");
        car.setModel("Golf");
        car.setPollutionCo2(114);

        Address address = new Address();
        address.setNumber(1337);
        address.setStreet("Street");

        User user = new User();
        user.setSurname("Jan");
        user.setName("Dockx");
        user.setAddress(address);
        user.setCar(car);

        System.out.println(String.format("Hello, %s!", user));
    }

}
