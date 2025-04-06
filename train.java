import java.util.Scanner;

public class train {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        booking booking=new booking();
        while(true){
            System.out.println("Welcome to RAILBOOKING :)");
            System.out.println("1.Book 2.cancel 3.printpassengerdetails 4.seatsavailable 5.Exit");
            System.out.print("Enter the choice below: ");
            int num=sc.nextInt();

            switch (num){
                case 1:
                    System.out.print("enter the passenger name:");
                    String name=sc.next();
                    System.out.print("enter age: ");
                    int age= sc.nextInt();
                    System.out.print("enter gender: ");
                    String gender=sc.next();
                    System.out.print("enter the prefered birth: ");
                    String birthprefered=sc.next();

                    if (age<=5) {
                        System.out.println("passenger is under aged");
                    }
                    booking.book(name,age,gender,birthprefered);
                    break;
                case 2:
                    System.out.print("Are you sure to cancel(yes/no) :");
                    String s=sc.next();
                    if(s.equals("yes"))
                        booking.cancel();
                    else System.out.println("TERMINATED.");
                    break;
                case 3:
                    booking.printpassengerdetails();
                    break;
                case 4:
                    booking.seatsavailable();
                    break;
                default:
                    System.out.println("THANK YOU FOR VISITING OUR WEBSITE :)");
                    System.exit(0);
            }
        }

    }
}