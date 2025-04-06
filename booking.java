import java.util.ArrayList;

public class booking {


    int lowerseats=2;
    int middleseat=2;
    int upperseats=2;
    int racseats=2;
    int waitingseats=2;
    ArrayList<Integer> passengerage=new ArrayList<>();
    ArrayList<String> passengername=new ArrayList<>();
    ArrayList<String> passengergender=new ArrayList<>();
    ArrayList<String> passengerbirth=new ArrayList<>();
    
    public void book(String name,int age,String gender,String birthprefered){
        if(age>=60 && lowerseats>0) birthprefered="lower";
        String sutaiblebirth=checkbirth(birthprefered);
        if(sutaiblebirth.isEmpty()){
            System.out.println("No tickets are available :(");
            return;
        }
        addpassengerdetails(name,age,gender,sutaiblebirth);
        System.out.println("Booked Successfully");
    }

    public void cancel(){
        if(passengername.isEmpty()) System.out.println("no passenger are booked to remove.");
        if(passengerbirth.getLast().contains("L")) lowerseats++;
        else if(passengerbirth.getLast().contains("M")) middleseat++;
        else if(passengerbirth.getLast().contains("L")) upperseats++;
        else if(passengerbirth.getLast().contains("rac")) racseats++;
        else if(passengerbirth.getLast().contains("waiting list")) waitingseats++;
        romovedetails();
        
    }

    private void romovedetails() {
        passengerage.removeLast();
        passengerbirth.removeLast();
        passengergender.removeLast();
        passengername.removeLast();
    }


    public void printpassengerdetails() {
        for(int i=0;i<passengername.size();i++){
            System.out.println("passenger name: "+passengername.get(i)+" "+"passenger age: "+passengerage.get(i)+" "+"passenger gender: "+passengergender.get(i)+" "+"passenger status: "+passengerbirth.get(i));
        }
    }


    public void seatsavailable() {
        System.out.println("Lower seats: "+lowerseats);
        System.out.println("Middle seats: "+middleseat);
        System.out.println("Upper seats: "+upperseats);
        System.out.println("RAC seats: "+racseats);
        System.out.println("Waiting seats: "+waitingseats);
    }



    public void addpassengerdetails(String name,int age,String gender,String birthprefered){
        passengername.add(name);
        passengerage.add(age);
        passengergender.add(gender);
        passengerbirth.add(birthprefered);
    }
    private String checkbirth(String birthprefered) {
        String seat="";
        if(birthprefered.equals("lower") && lowerseats>0){
            seat= lowerseats +"L";
            lowerseats--;
        }
        else if (birthprefered.equals("middle") && middleseat>0){
            seat=middleseat+"M";
            middleseat--;
        }
        else if(birthprefered.equals("upper") && upperseats>0){
            upperseats--;
        }
        else if(racseats>0){
            seat="rac";
            racseats--;
        }
        else if(waitingseats>0){
            seat="waiting list";
            waitingseats--;
        }
        return seat;
    }
}
