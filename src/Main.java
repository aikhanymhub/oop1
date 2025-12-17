import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Список для хранения всех автомобилей
    private List<Vehicle> inventory = new ArrayList<>();

    // Конструктор для заполнения списка тестовыми данными
    public Main() {
        inventory.add(new Vehicle("V001", "Toyota", "Camry", 50.0, true));
        inventory.add(new Vehicle("V002", "Honda", "CRV", 65.0, true));
        inventory.add(new Vehicle("V003", "Mercedes", "C-Class", 120.0, true));
        inventory.add(new Vehicle("V004", "Lada", "Granta", 25.0, true));
    }

    // 1. Метод для отображения доступных автомобилей
    public void displayAvailableVehicles() {
        System.out.println("------------------------------------------");
        System.out.println("AVAILABLE CARS:");
        System.out.println("ID | Brand | Model | Price per day");
        System.out.println("------------------------------------------");
        for (Vehicle vehicle : inventory) {
            if (vehicle.isAvailable()) {
                System.out.printf("%s | %s | %s | %.2f$\n",
                        vehicle.getVehicleId(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getPricePerDay());
            }
        }
        System.out.println("------------------------------------------");
    }

    // 2. Метод для аренды автомобиля
    public void rentVehicle(String vehicleId, int rentalDays) {
        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId) && vehicle.isAvailable()) {
                selectedVehicle = vehicle;
                break; // Нашли нужный автомобиль
            }
        }

        if (selectedVehicle != null) {
            double totalCost = selectedVehicle.getPricePerDay() * rentalDays;

            // Сеттер используется для изменения статуса доступности
            selectedVehicle.setAvailable(false);

            System.out.printf("\nSuccess! You rented %s %s for %d days.\n",
                    selectedVehicle.getBrand(), selectedVehicle.getModel(), rentalDays);
            System.out.printf("Total rental cost: %.2f$\n\n", totalCost);
        } else {
            System.out.println("\n Error: Vehicle with this ID not found or unavailable.\n\n");
        }
    }

    // 3. Метод для возврата автомобиля
    public void returnVehicle(String vehicleId) {
        Vehicle rentedVehicle = null;
        for (Vehicle vehicle : inventory) {
            // Ищем по ID, и проверяем, что он *не* доступен (т.е. арендован)
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId) && !vehicle.isAvailable()) {
                rentedVehicle = vehicle;
                break;
            }
        }

        if (rentedVehicle != null) {
            // Сеттер используется для изменения статуса доступности обратно
            rentedVehicle.setAvailable(true);
            System.out.printf("\nSuccess! The vehicle %s %s has been returned.\n\n",
                    rentedVehicle.getBrand(), rentedVehicle.getModel());
        } else {
            System.out.println("\nError: A vehicle with this ID has not been rented, or the ID is incorrect.\n");
        }
    }

    public static void main(String[] args) {
        Main rentalSystem = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Vehicle Rental System1 =====");
            System.out.println("1. View available cars");
            System.out.println("2. Rent a car");
            System.out.println("3. Return a car");
            System.out.println("4. Exit");
            System.out.print("Choose an action: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    rentalSystem.displayAvailableVehicles();
                    break;
                case 2:
                    System.out.print("Enter Vehicle ID to rent: ");
                    String rentId = scanner.nextLine();
                    System.out.print("How many days? ");
                    int rentDays = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    rentalSystem.rentVehicle(rentId, rentDays);
                    break;
                case 3:
                    System.out.print("Enter Vehicle ID to return: ");
                    String returnId = scanner.nextLine();
                    rentalSystem.returnVehicle(returnId);
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}