public class SeniorPassenger extends Passenger {
    public SeniorPassenger(String name, int age, String gender) {
        super(name, age, gender, "lower"); // force lower berth
    }

    @Override
    public void displayDetails() {
        System.out.print("Senior Citizen - ");
        super.displayDetails();
    }
}
