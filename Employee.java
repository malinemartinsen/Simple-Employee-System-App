import java.util.Arrays;

public class Employee {
    // fields
    private String name;
    private String position;
    private char gender;
    private int age;
    private int employeeID; 
    private double hoursPerWeek;
    private String[] workDays;

    // Constructor
    public Employee(String name, String position, char gender, int age, int employeeID, double hoursPerWeek, String[] workDays) {
        this.name = name;
        this.position = position;
        this.gender = gender;
        this.age = age;
        this.employeeID = employeeID;
        this.hoursPerWeek = hoursPerWeek;
        this.workDays = Arrays.copyOf(workDays, workDays.length);
    }

    // Copy constructor
    public Employee (Employee source) {
        this.name = source.name;
        this.position = source.position;
        this.gender = source.gender;
        this.age = source.age;
        this.employeeID = source.employeeID;
        this.hoursPerWeek = source.hoursPerWeek;
        this.workDays = Arrays.copyOf(source.workDays, source.workDays.length);
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public int getAge() {
        return age;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public double getHoursPerWeek() {
        return hoursPerWeek;
    }
    public char getGender() {
        return gender;
    }
    public String[] getWorkDays() {
        return Arrays.copyOf(this.workDays, this.workDays.length);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setWorkDays(String[] workDays) {
        this.workDays = Arrays.copyOf(workDays, workDays.length);
    }

    // Action: Leave work
    public void leaveWork() {
        System.out.println("\nGood job today, " + this.name + "! I wish you a great evening.");
        System.out.println("Please exit through the left door by the reception.\n");
    }

    // Action: Find office desk
    public void findDesk() {
        System.out.println("\nReady to work, " + this.name + "?");
        System.out.println("Hope you'll get a nice workday!\n");
    }

    // toString
    public String toString() {
        return  "Name: " + this.name + ".\n"
            +   "Titel: " + this.position + ".\n"
            +   "Gender: " + this.gender + ".\n"
            +   "Age: " + this.age + ".\n"
            +   "Employee ID: " + this.employeeID + ".\n"
            +   "Hours per week: " + this.hoursPerWeek + ".\n"
            +   "Work days: " + Arrays.toString(workDays) + ".\n";
    }
}