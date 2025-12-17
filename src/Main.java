import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalService service = new RentalService();

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
            scanner.nextLine(); // буферді тазалау

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
                    service.rentVehicle(customer, rentId, days);
                    break;
                case 3:
                    service.returnVehicle(customer);
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
