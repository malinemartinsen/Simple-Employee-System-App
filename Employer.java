
public class Employer {
    // Field(s)
    private Employee[] employees;

    // Constructor
    public Employer(Employee[] employees) {
        this.employees = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            this.employees[i] = new Employee(employees[i]);
        }
    }

    // Setter
    public void setEmployee(Employee employee, int index) {
        this.employees[index] = new Employee(employee);
    }

    // Getter
    public Employee getEmployee(int index) {
        return new Employee(this.employees[index]);
    }

    // Action: Clock in employee
    public String clockIn(String name, int index) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] != null) {
                continue;
            } else if(this.employees[i].getName().equals(name)) {
                return "\nYou are checked in!";
            }
        }
        return "\nThe employee you are currently searching for does not exist.";
    }

    // Action: Clock out employee
    public void whenClockOut(int index) {
        this.employees[index].leaveWork();
        this.employees[index] = null;
    }

    public void whenClockIn(int index) {
        this.employees[index].findDesk();
        this.employees[index] = this.employees[index];
    }
       

    // Action: Search for employee
    public int search(String name, int employeeID) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] == null) {
                continue;
            } else if (this.employees[i].getName().equalsIgnoreCase(name) && this.employees[i].getEmployeeID() == employeeID){
                System.out.println("\nThank you for verifying " + this.employees[i].getName());
                System.out.println("\nHere is the employee database");  
                System.out.println("Please enter your password for access: ");
                return i;
            }   
        } 
        return 404;
    }

    // Action: Clock Out employee
    public int clockOut(int employeeID) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] == null) {
                continue;
            } else if (this.employees[i].getEmployeeID() == employeeID){
                System.out.println("\nThank you for verifying, " + this.employees[i].getName() + " \n");   
                System.out.println("If you want to check out, please type 'yes': ");
                return i;
            }   
        } 
        return 404;
    }

    // Action: Clock out employee
    public int clockIn(int employeeID) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] == null) {
                continue;
            } else if (this.employees[i].getEmployeeID() == employeeID){
                System.out.println("\nThank you for verifying, " + this.employees[i].getName() + " \n");   
                System.out.println("If you want to check in, please type 'yes': ");
                return i;
            }   
        } 
        return 404;
    }

    // toString method
    public String toString() {
        // Temporary string that will be updated
        String temp = "";
    
        // Loop to run through the whole employees-field
        for (int i = 0; i < this.employees.length; i++) {
            temp += "Desk: " + i + "\n";
                
            if(this.employees[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.employees[i].toString() + "\n";
            }
        }
        return temp;
    }

}