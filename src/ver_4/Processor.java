package ver_4;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find a teacher by department");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    personList.addStudent();
                    break;
                case 2:
                    personList.addTeacher();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    String idToUpdate = scanner.nextLine();
                    personList.updatePerson(idToUpdate);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String idToDelete = scanner.nextLine();
                    personList.deletePersonById(idToDelete);
                    break;

                case 5:
                    personList.displayEveryone();
                    break;
                case 6:
                    personList.findTopStudent();
                    break;
                case 7:
                    personList.findTeacherByDepartment();
                    break;
                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
