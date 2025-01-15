import java.util.Scanner;

class Student Gradebook{
    String name;
    String studentId;
    double[] grades;  // Array to hold grades for different subjects
    String[] subjects; // Array to hold subject names

    // Constructor
    public Student(String name, String studentId, int numSubjects) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new double[numSubjects];
        this.subjects = new String[numSubjects];
    }

    // Method to add grades for each subject
    public void addSubjectGrades(String subject, double grade, int subjectIndex) {
        this.subjects[subjectIndex] = subject;
        this.grades[subjectIndex] = grade;
    }

    // Method to calculate the average grade
    public double calculateAverage() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.length;
    }

    // Method to return the student's details and grades
    public String toString() {
        StringBuilder details = new StringBuilder("Student: " + name + ", ID: " + studentId + "\n");
        for (int i = 0; i < grades.length; i++) {
            details.append(subjects[i] + ": " + grades[i] + "\n");
        }
        details.append("Average Grade: " + calculateAverage());
        return details.toString();
    }
}

public class Gradebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] gradebook = new Student[10]; // Array to hold up to 10 students
        int studentCount = 0;

        while (true) {
            System.out.println("Student Gradebook");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                if (studentCount < 10) {
                    // Add a new student
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's ID: ");
                    String studentId = scanner.nextLine();

                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    // Create a new student object
                    Student student = new Student(name, studentId, numSubjects);

                    // Enter grades for each subject
                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter subject name: ");
                        String subject = scanner.nextLine();
                        System.out.print("Enter grade for " + subject + ": ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        student.addSubjectGrades(subject, grade, i);
                    }

                    // Add the student to the gradebook
                    gradebook[studentCount] = student;
                    studentCount++;
                } else {
                    System.out.println("Gradebook is full!");
                }
            } else if (choice == 2) {
                // View all students
                if (studentCount == 0) {
                    System.out.println("No students in the gradebook.");
                } else {
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println(gradebook[i]);
                        System.out.println();
                    }
                }
            } else if (choice == 3) {
                // Exit
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}