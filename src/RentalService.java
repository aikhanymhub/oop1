public class RentalService {
    private Vehicle car1;
    private Vehicle car2;

    public RentalService() {
        car1 = new Vehicle("V001", "Toyota", "Camry", 50);
        car2 = new Vehicle("V002", "Honda", "CRV", 65);
    }

    public void displayAvailableVehicles() {
        System.out.println("Available cars:");
        if (car1.isAvailable())
            System.out.println(car1.getVehicleId() + " | " + car1.getBrand() + " | " + car1.getModel() + " | $" + car1.getPricePerDay());
        if (car2.isAvailable())
            System.out.println(car2.getVehicleId() + " | " + car2.getBrand() + " | " + car2.getModel() + " | $" + car2.getPricePerDay());
    }

    public void rentVehicle(Customer customer, String id, int days) {
        if (car1.getVehicleId().equals(id) && car1.isAvailable()) {
            car1.setAvailable(false);
            customer.rentVehicle(car1);
            System.out.println(customer.getName() + " rented " + car1.getBrand() + " for " + days + " days. Total: $" + (car1.getPricePerDay() * days));
        } else if (car2.getVehicleId().equals(id) && car2.isAvailable()) {
            car2.setAvailable(false);
            customer.rentVehicle(car2);
            System.out.println(customer.getName() + " rented " + car2.getBrand() + " for " + days + " days. Total: $" + (car2.getPricePerDay() * days));
        } else {
            System.out.println("Car not available or ID incorrect.");
        }
    }

    public void returnVehicle(Customer customer) {
        Vehicle rented = customer.getRentedVehicle();
        if (rented != null) {
            rented.setAvailable(true);
            System.out.println("Car " + rented.getBrand() + " returned.");
            customer.returnVehicle();
        } else {
            System.out.println("No car to return.");
        }
    }
}
