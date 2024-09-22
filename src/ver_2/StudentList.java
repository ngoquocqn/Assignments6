package ver_2;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentList {

    private ArrayList<Student> studentList;

    // Constructor
    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    // Getter và Setter
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter student id: ");
        String id = sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        String dobStr = sc.nextLine();

        Date dateOfBirth;
        try {
            dateOfBirth = sdf.parse(dobStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.print("Enter GPA: ");
        float gpa = sc.nextFloat();
        sc.nextLine(); // Consume newline
        System.out.print("Enter major: ");
        String major = sc.nextLine();

        // Create and add a new student
        Student student = new Student(gpa, major, id, name, dateOfBirth);
        studentList.add(student);
        System.out.println("Student has been successfully added!");
    }

    public void updateStudentById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID: ");
        String id = sc.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                System.out.println("Update Student. ");
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
            }
        }
    }

    public void deleteStudentById(String id) {
        Person delId = findStudentById(id);
        if (delId == null) {
            System.out.println("Person not found.");
        } else {
            studentList.remove(delId);
            System.out.println("Person deleted successfully.");
        }
    }

    public Student findStudentById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).displayInfo();
        }
    }

    public void findTopStudent() {
        Student topStudent = null;
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }

        if (topStudent != null) {
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
    }

    public ArrayList<Student> findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.isScholarship()) {
                scholarshipStudents.add(student);
                student.displayInfo();
            }
        }
        return scholarshipStudents;
    }

    public double calculateTuitionOfAllStudents() {
        double totalTuition = 0;
        for (int i = 0; i < studentList.size(); i++) {
            totalTuition += studentList.get(i).getTuition();
        }
        return totalTuition;
    }

}
