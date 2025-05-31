public class User {
    protected String name;
    protected int age;
    protected String gender;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayDetails() {
        System.out.print("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}

