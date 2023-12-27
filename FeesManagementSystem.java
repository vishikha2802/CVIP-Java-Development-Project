package java_examples;

import java.util.ArrayList; 
import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double feePaid;
    double totalFee;

    public Student(String studentName, int rollNumber, double totalFee) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.feePaid = 0;
        this.totalFee = totalFee;
    }
}

class FeesManagementSystem {
    ArrayList<Student> students;

    public FeesManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void recordFeePayment(int rollNumber, double amount) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                double remainingFee = student.totalFee - student.feePaid;
                if (amount <= remainingFee) {
                    student.feePaid += amount;
                    System.out.println("Payment recorded successfully.");
                } else {
                    System.out.println("Invalid payment amount. Amount exceeds remaining fee.");
                }
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayFeeDetails(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                System.out.println("Student Name: " + student.studentName);
                System.out.println("Roll Number: " + student.rollNumber);
                System.out.println("Total Fee: " + student.totalFee);
                System.out.println("Fee Paid: " + student.feePaid);
                System.out.println("Remaining Fee: " + (student.totalFee - student.feePaid));
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeesManagementSystem feesManagementSystem = new FeesManagementSystem();

        // Adding sample students
        feesManagementSystem.addStudent(new Student("John Doe", 101, 5000));
        feesManagementSystem.addStudent(new Student("Jane Smith", 102, 6000));

        int choice;
        do {
            System.out.println("\nFees Management System Menu:");
            System.out.println("1. Record Fee Payment");
            System.out.println("2. Display Fee Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter Payment Amount: ");
                    double paymentAmount = scanner.nextDouble();
                    feesManagementSystem.recordFeePayment(rollNumber, paymentAmount);
                    break;

                case 2:
                    System.out.print("Enter Roll Number: ");
                    int displayRollNumber = scanner.nextInt();
                    feesManagementSystem.displayFeeDetails(displayRollNumber);
                    break;

                case 3:
                    System.out.println("Exiting Fees Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 3);

        scanner.close();
    }
}

