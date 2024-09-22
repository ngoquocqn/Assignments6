package ver_3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonList {

    private ArrayList<Person> personList = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        String dobStr = scanner.nextLine();
        System.out.print("Enter GPA: ");
        float gpa = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
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
        personList.add(student);
        System.out.println("Student added successfully!");
    }

    public void addTeacher() {
        System.out.print("Enter teacher ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter teacher name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        String dobStr = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter teaching subject: ");
        String teachingSubject = scanner.nextLine();

        Date dob;
        try {
            dob = sdf.parse(dobStr);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }
        Teacher teacher = new Teacher(id, fullName, dob, department, teachingSubject);
        personList.add(teacher);
        System.out.println("Teacher added successfully!");
    }

    public void updatePerson(String id) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Using a traditional for loop
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);  // Get the current Person object
            if (person.getId().equals(id)) {
                if (person instanceof Student) {
                    // Update Student details
                    Student updateStudent = (Student) person;
                    System.out.println("Update student details:");

                    System.out.print("Enter new name: ");
                    updateStudent.setFullName(sc.nextLine());

                    System.out.print("Enter new major: ");
                    updateStudent.setMajor(sc.nextLine());

                    System.out.print("Enter new GPA: ");
                    updateStudent.setGpa(Float.parseFloat(sc.nextLine()));

                    System.out.print("Enter new date of birth (yyyy-MM-dd): ");
                    String dobStr = sc.nextLine();
                    try {
                        updateStudent.setDateOfBirth(sdf.parse(dobStr));
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }

                    System.out.println("Student details updated successfully!");

                } else if (person instanceof Teacher) {
                    // Update Teacher details
                    Teacher updateTeacher = (Teacher) person;
                    System.out.println("Update teacher details:");

                    System.out.print("Enter new name: ");
                    updateTeacher.setFullName(sc.nextLine());

                    System.out.print("Enter new department: ");
                    updateTeacher.setDepartment(sc.nextLine());

                    System.out.print("Enter new teaching subject: ");
                    updateTeacher.setTeachingSubject(sc.nextLine());

                    System.out.print("Enter new date of birth (yyyy-MM-dd): ");
                    String dobStr = sc.nextLine();
                    try {
                        updateTeacher.setDateOfBirth(sdf.parse(dobStr));
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }

                    System.out.println("Teacher details updated successfully!");
                }
                return;
            }
        }

        System.out.println("Person with this ID not found.");
    }

    public void deletePersonById(String id) {

        Person personToDelete = findPersonById(id);
        if (personToDelete == null) {
            System.out.println("Person not found.");
        } else {
            personList.remove(personToDelete);
            System.out.println("Person deleted successfully.");
        }
    }

    public void findPersonById() {
        System.out.print("Enter the ID of the person to find: ");
        String id = scanner.nextLine();
        Person foundPerson = findPersonById(id);
        if (foundPerson == null) {
            System.out.println("Person not found.");
        } else {
            foundPerson.displayInfo();
        }
    }

    public void displayEveryone() {
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).displayInfo();
        }
    }

    public void findTopStudent() {
        Student topStudent = null;
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
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

    public void findTeacherByDepartment() {
        System.out.print("Enter the department to search: ");
        String department = scanner.nextLine();
        Teacher foundTeacher = findTeacherByDepartment(department);
        if (foundTeacher == null) {
            System.out.println("No teacher found in that department.");
        } else {
            foundTeacher.displayInfo();
        }
    }

    private Person findPersonById(String id) {
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    private Teacher findTeacherByDepartment(String department) {
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    return teacher;
                }
            }
        }
        return null;
    }

}
