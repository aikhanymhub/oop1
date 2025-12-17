import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalService service = new RentalService();

        // 1. Создаем одного конкретного клиента через латинское 'Customer'
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);

        while (true) {
            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. View available cars");
            System.out.println("2. Rent a car");
            System.out.println("3. Return a car");
            System.out.println("4. Exit");
            System.out.print("Choose an action: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    service.displayAvailableVehicles();
                    break;
                case 2:
                    System.out.print("Enter Vehicle ID to rent: ");
                    String rentId = scanner.nextLine();
                    System.out.print("How many days? ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    // Передаем переменную 'customer' (с маленькой буквы)
                    service.rentVehicle(Сustomer, rentId, days);
                    break;
                case 3:
                    // Используем ту же переменную 'customer'
                    service.returnVehicle(Сustomer);
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}