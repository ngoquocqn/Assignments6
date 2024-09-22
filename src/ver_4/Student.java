package ver_4;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

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

    @Override
    public void addPerson() {
        // Implementation for adding a student
        System.out.println("Adding a new student: " + getFullName());
    }

    @Override
    public void updatePerson(String id) {
        if (getId().equals(id)) {
            System.out.println("Updating student information for: " + getFullName());
            // Update student information logic here (e.g., change GPA, Major, etc.)
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

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
