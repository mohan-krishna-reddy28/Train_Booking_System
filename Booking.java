import java.util.ArrayList;

public class Booking {
    private int lowerSeats = 2, middleSeats = 2, upperSeats = 2, racSeats = 2, waitingSeats = 2;
    private final ArrayList<Passenger> passengers = new ArrayList<>();

    public void book(Passenger passenger) {
        String preferred = passenger.getBirthPreference();

        if (passenger instanceof SeniorPassenger) {
            preferred = "lower";
        }

        String assigned = assignSeat(preferred);
        if (assigned.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }
        passenger.setAssignedSeat(assigned);
        passengers.add(passenger);

        System.out.println("Booked Successfully: " + assigned);
    }

    public void cancel() {
        if (passengers.isEmpty()) {
            System.out.println("No bookings to cancel.");
            return;
        }

        Passenger last = passengers.remove(passengers.size() - 1);
        String pref = last.getBirthPreference();

        if (pref.contains("lower")) lowerSeats++;
        else if (pref.contains("middle")) middleSeats++;
        else if (pref.contains("upper")) upperSeats++;
        else if (pref.contains("rac")) racSeats++;
        else if (pref.contains("waiting")) waitingSeats++;

        System.out.println("Last booking cancelled successfully.");
    }

    private String assignSeat(String preference) {
        if (preference.equals("lower")) {
            if(lowerSeats > 0){
                lowerSeats--;
                return "Lower Berth";
            }
            else if(middleSeats > 0){
                middleSeats--;
                return "Middle Berth";
            }
            else if(upperSeats > 0){
                upperSeats--;
                return "Upper Berth";
            }
        }
        else if (preference.equals("middle")) {
            if(middleSeats > 0){
                middleSeats--;
                return "Middle Berth";
            }
            else if(lowerSeats > 0){
                lowerSeats--;
                return "Lower Berth";
            }
            else if(upperSeats > 0){
                upperSeats--;
                return "Upper Berth";
            }
        } 
        else if (preference.equals("upper")) {
            if(upperSeats > 0){
                upperSeats--;
                return "Upper Berth";
            }
            else if(middleSeats > 0){
                middleSeats--;
                return "Middle Berth";
            }
            else if(lowerSeats > 0){
                lowerSeats--;
                return "Lower Berth";
            }
        } 
        else if (waitingSeats > 0) {
            waitingSeats--;
            return "Waiting List";
        } 
        else if (racSeats > 0) {
            racSeats--;
            return "RAC";
        }
        return "";
    }

    public void printPassengerDetails() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers booked yet.");
            return;
        }
        for (Passenger p : passengers) {
            p.displayDetails();
        }
    }

    public void seatsAvailable() {
        System.out.println("Available seats:");
        System.out.println("Lower: " + lowerSeats);
        System.out.println("Middle: " + middleSeats);
        System.out.println("Upper: " + upperSeats);
        System.out.println("RAC: " + racSeats);
        System.out.println("Waiting List: " + waitingSeats);
    }
}
