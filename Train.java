import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Booking booking = new Booking();

        while (true) {
            System.out.println("\n--- Welcome to RAILBOOKING :) ---");
            System.out.println("1. Book  2. Cancel  3. Passenger Details  4. Seats Available  5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Gender: ");
                    String gender = sc.next();
                    System.out.print("Enter Berth Preference (lower/middle/upper): ");
                    String birth = sc.next();

                    Passenger p;
                    if (age >= 60)
                        p = new SeniorPassenger(name, age, gender);
                    else
                        p = new Passenger(name, age, gender, birth);

                    if (age <= 5)
                        System.out.println("Passenger is under-aged. No ticket needed.");
                    else
                        booking.book(p);
                    break;

                case 2:
                    System.out.print("Are you sure to cancel? (yes/no): ");
                    String confirm = sc.next();
                    if (confirm.equalsIgnoreCase("yes")) booking.cancel();
                    else System.out.println("Cancellation aborted.");
                    break;

                case 3:
                    booking.printPassengerDetails();
                    break;

                case 4:
                    booking.seatsAvailable();
                    break;

                case 5:
                    System.out.println("Thank you for using RailBooking :)");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
