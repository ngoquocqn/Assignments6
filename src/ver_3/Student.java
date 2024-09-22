package ver_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person implements IPerson {

    private float gpa;
    private String major;

    // Constructor
    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    // Getters and setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addStudent() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter student ID: ");
//        String id = scanner.nextLine();
//        System.out.print("Enter full name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter date of birth (yyyy-MM-dd): ");
//        String dobStr = scanner.nextLine();
//        //Date dateOfBirth = Date.valueOf(dobStr);  // You would need to handle exceptions
//        System.out.print("Enter GPA: ");
//        float gpa = scanner.nextFloat();
//        scanner.nextLine();  // Consume newline
//        System.out.print("Enter major: ");
//        String major = scanner.nextLine();
    }

    // Update student information
    public void updateStudent() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Update full name (current: " + fullName + "): ");
//        String newName = scanner.nextLine();
//        if (!newName.trim().isEmpty()) {
//            this.fullName = newName;
//        }
//        
//        System.out.print("Update GPA (current: " + gpa + "): ");
//        String newGpa = scanner.nextLine();
//        if (!newGpa.trim().isEmpty()) {
//            this.gpa = Float.parseFloat(newGpa);
//        }
//
//        System.out.print("Update major (current: " + major + "): ");
//        String newMajor = scanner.nextLine();
//        if (!newMajor.trim().isEmpty()) {
//            this.major = newMajor;
//        }
    }
    
    

    // Implementing the displayInfo method from IPerson
    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
}
