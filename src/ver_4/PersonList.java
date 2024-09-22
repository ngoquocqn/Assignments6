package ver_4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonList {

    private ArrayList<Person> personList;
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public PersonList() {
        personList = new ArrayList<>();
    }

    public void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter date of birth (yyyy-MM-dd): ");
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
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person.getId().equals(id)) {
                if (person instanceof Student) {
                    Student updateStudent = (Student) person;
                    System.out.println("Update student details.");

                    System.out.print("Enter new name: ");
                    updateStudent.setFullName(scanner.nextLine());

                    System.out.print("Enter new major: ");
                    updateStudent.setMajor(scanner.nextLine());

                    System.out.print("Enter new GPA: ");
                    updateStudent.setGpa(Float.parseFloat(scanner.nextLine()));

                    System.out.print("Enter new date of birth (yyyy-MM-dd): ");
                    String dobStr = scanner.nextLine();
                    try {
                        updateStudent.setDateOfBirth(sdf.parse(dobStr));
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }

                    System.out.println("Student details updated successfully!");

                } else if (person instanceof Teacher) {
                    Teacher updateTeacher = (Teacher) person;
                    System.out.println("Update teacher details.");

                    System.out.print("Enter new name: ");
                    updateTeacher.setFullName(scanner.nextLine());

                    System.out.print("Enter new department: ");
                    updateTeacher.setDepartment(scanner.nextLine());

                    System.out.print("Enter new teaching subject: ");
                    updateTeacher.setTeachingSubject(scanner.nextLine());

                    System.out.print("Enter new date of birth (yyyy-MM-dd): ");
                    String dobStr = scanner.nextLine();
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

    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
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

    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }

        //return topStudent;
        if (topStudent != null) {
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
        return topStudent;
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
