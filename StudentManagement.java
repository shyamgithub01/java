import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int age;
    String grade;

    Student(String name, int age, String grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return name + " | Age: " + age + " | Grade: " + grade;
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Search Student\n4. Delete Student\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        System.out.println("Program exited.");
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        students.add(new Student(name, age, grade));
        System.out.println("Student added!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("Student List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + s);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();
        boolean removed = students.removeIf(s -> s.name.equalsIgnoreCase(name));
        if (removed) System.out.println("Student removed.");
        else System.out.println("Student not found.");
    }
}
