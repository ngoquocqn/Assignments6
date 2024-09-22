package ver_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.AEADBadTagException;

public class Student extends Person implements IPerson {

    private float gpa;
    private String major;
    private double tuition;
    private boolean scholarship;

    public Student() {
    }
    
    // Constructor
    public Student(float gpa, String major, String id, String fullName, Date dateOfBirth) {    
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.scholarship = (gpa >= 9); 
        this.tuition = calculateTuition(); // Set tuition during initialization
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.scholarship = (gpa >= 9);  // Reevaluate scholarship eligibility
        this.tuition = calculateTuition();  // Recalculate tuition when GPA changes
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    // Calculate Tuition
    public double calculateTuition() {
        double baseTuition = 10000000; // 10,000,000
        if (gpa >= 9) {
            return baseTuition * 0.5; // 50% reduction for scholarship
        } else {
            return baseTuition;  // Full tuition if no scholarship
        }
    }

    // Implement displayInfo from Person
    @Override
    public void displayInfo() {
        String formattedTuition = String.format("%,.0f", tuition);  // Format tuition without scientific notation
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + sdf.format(getDateOfBirth()));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Tuition: " + formattedTuition);  // Use the stored tuition value
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }
}
