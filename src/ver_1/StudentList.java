package ver_1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentList {

    ArrayList<Student> studentList;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    // Add a new student
    public void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String fullName = scanner.nextLine();
        System.out.print("nter date of birth (yyyy-MM-dd): ");
        String dobStr = scanner.nextLine();
        System.out.print("Enter GPA: ");
        float gpa = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();

        Date dob;
        try {
            dob = sdf.parse(dobStr);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }
        Student student = new Student(id, fullName, dob, gpa, major);
        studentList.add(student);
        System.out.println("Student has been successfully added!");
    }

    public void updateStudentById(String id) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                System.out.println("Update Student.");
                Student updateStudent = studentList.get(i);
                System.out.println("Enter full name: ");
                updateStudent.setFullName(sc.nextLine());
                System.out.println("Enter major: ");
                updateStudent.setMajor(sc.nextLine());
                System.out.println("Enter GPA: ");
                updateStudent.setGpa(Float.parseFloat(sc.nextLine()));
                System.out.println("Enter date of birth (yyyy-MM-dd): ");
                String dobStr = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    updateStudent.setDateOfBirth(sdf.parse(dobStr));
                } catch (Exception e) {
                    System.out.println("Wrong format");
                }
                studentList.set(i, updateStudent);
                System.out.println("Student information updated successfully!");
            }
        }
    }
    // Delete a student by ID

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    // Find student by ID
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : studentList) {
            System.out.println("Display all students");
            student.displayInfo();
            System.out.println("-----------");
        }
    }

    // Find the student with the highest GPA
    public void findTopStudent() {
        Student topStudent = null;
        for (int i = 0; i < studentList.size(); i++) {
            Person person = studentList.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }

        if (topStudent != null) {
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
    }

}
