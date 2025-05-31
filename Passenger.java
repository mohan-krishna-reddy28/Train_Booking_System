public class Passenger extends User {
    protected String birthPreference;
    private String assignedSeat;

    public Passenger(String name, int age, String gender, String birthPreference) {
        super(name, age, gender);
        this.birthPreference = birthPreference;
    }

    public String getBirthPreference() {
        return birthPreference;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Berth Preference: " + birthPreference);
        System.out.println(", Assigned Breth: "+assignedSeat);
    }

    public void setAssignedSeat(String seat) {
        this.assignedSeat = seat;
    }

    public String getAssignedSeat() {
        return assignedSeat;
    }

}
