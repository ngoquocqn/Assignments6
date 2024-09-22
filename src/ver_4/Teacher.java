/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver_4;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.SimpleDoc;

public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

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

    @Override
    public void addPerson() {
        // Implementation for adding a teacher
        System.out.println("Adding a new teacher: " + getFullName());
    }

    @Override
    public void updatePerson(String id) {
        if (getId().equals(id)) {
            System.out.println("Updating teacher information for: " + getFullName());
            // Update teacher information logic here (e.g., change Department, Teaching Subject, etc.)
        } else {
            System.out.println("Teacher with ID " + id + " not found.");
        }
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Teacher ID: " + getId());
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("Department: " + department);
        System.out.println("Teaching Subject: " + teachingSubject);
    }
}
