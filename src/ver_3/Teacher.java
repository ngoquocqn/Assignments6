package ver_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teacher extends Person implements IPerson{
    private String department;
    private String teachingSubject;

    // Constructor
    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    // Getters and setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    public void addTeacher() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter teacher ID: ");
//        String id = scanner.nextLine();
//        
//        System.out.print("Enter full name: ");
//        String fullName = scanner.nextLine();
//        
//        System.out.print("Enter date of birth (yyyy-MM-dd): ");
//        String dobStr = scanner.nextLine();
//        //Date dateOfBirth = Date.valueOf(dobStr); // Handle date input
//        
//        System.out.print("Enter department: ");
//        String department = scanner.nextLine();
//        
//        System.out.print("Enter teaching subject: ");
//        String subject = scanner.nextLine();
    }

    // Update teacher method
    public void updateTeacher() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Update full name (current: " + fullName + "): ");
//        String newName = scanner.nextLine();
//        if (!newName.trim().isEmpty()) {
//            this.fullName = newName;
//        }
//
//        System.out.print("Update department (current: " + department + "): ");
//        String newDepartment = scanner.nextLine();
//        if (!newDepartment.trim().isEmpty()) {
//            this.department = newDepartment;
//        }
//
//        System.out.print("Update teaching subject (current: " + teachingSubject + "): ");
//        String newSubject = scanner.nextLine();
//        if (!newSubject.trim().isEmpty()) {
//            this.teachingSubject = newSubject;
//        }
    }
    // Implementing the displayInfo method from IPerson
    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("Teacher ID: " + getId());
        System.out.println("FullName: " + getFullName());
        System.out.println("DateOfBirth: "+ sdf.format(getDateOfBirth()));
        System.out.println("Department: "+ department);
        System.out.println("Subject: "+ teachingSubject);
        
    }
}
