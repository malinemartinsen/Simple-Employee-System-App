import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // String with standard work days:
        String[] workDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Employees
        Employee[] employees = new Employee[] {
            new Employee("Patrick", "Manager", 'M', 27, 8441, 47.5, new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}),
            new Employee("Manouck", "Assistant Manager", 'F', 24, 8399, 32.0, new String[] {"Monday", "Tuesday", "Wednesday", "Thursday"}),
            new Employee("Henrik", "Senior Software Engineer", 'M', 26, 1287, 40.0, workDays),
            new Employee("Stephen", "Developer", 'M', 26, 7635, 36.0, workDays),
            new Employee("Gabriele", "Consultalt", 'F', 21, 4587, 24.5, new String[] {"Monday", "Tuesday", "Thursday"}),
            new Employee("Lucija", "Consultant", 'F', 21, 3367, 24.0, new String[] {"Wednesday", "Friday", "Saturday"}),
        };

        // Employer object
        Employer employer = new Employer(employees);

        //Setting the employees
        for (int i = 0; i < employees.length; i++) {
            employer.setEmployee(employees[i], i);
        }

        // User interaction
        System.out.println("\n *** M. M. Studios Developement *** ");
        System.out.println("\nWelcome to M. M. Studios Employee System!");
        System.out.println("\nPlease type 'employee search', 'check in' or 'check out':\n");
        String enter = scan.nextLine();

        // Search
        if (enter.equalsIgnoreCase("employee search")){
            System.out.println("\nDue to privacy reasons, we would need to ask you a few security questions:\n");
            System.out.println("Please fill in your name: ");
            String name = scan.nextLine();

            System.out.println("\nPlease fill in your employee ID: ");
            int employeeID = scan.nextInt();

            int index = employer.search(name, employeeID);
            
            switch (index) {
                case 404: System.out.println("\nI'm sorry, the search has no results. Please try again.");
                break;

                default: scan.nextLine();
                String decision = scan.nextLine();
                    if(decision.equalsIgnoreCase("password")) {
                        System.out.println(employer);
                        System.out.println("Thank you for using our system!\n\n");
                    }
            }

        //Clock out
        } else if (enter.equalsIgnoreCase("check out")){
            System.out.println("\nPlease fill your employee ID in: ");
            int employeeID = scan.nextInt();
            int index = employer.clockOut(employeeID);
            
            
            switch(index) {
                case 404: System.out.println("\nI'm sorry, the search has no results. Please try again.");
            break;

            default: scan.nextLine();
            String decision = scan.nextLine();
                if (decision.equalsIgnoreCase("yes")) {
                employer.whenClockOut(index);
                }
            }

        //Clock in
        } else if (enter.equalsIgnoreCase("check in")){
            System.out.println("\nPlease fill your employee ID in: ");
            int employeeID = scan.nextInt();
            int index = employer.clockIn(employeeID);
            
            
            switch(index) {
                case 404: System.out.println("\nI'm sorry, the search has no results. Please try again.");
            break;

            default: scan.nextLine();
            String decision = scan.nextLine();
                if (decision.equalsIgnoreCase("yes")) {
                employer.whenClockIn(index);
                }
            }
        } else {
            System.out.println("I'm sorry, the search has no results.\n");
        }
        scan.close();
    }
}