package Exam;

import java.util.ArrayList;
import java.util.Scanner;

class Exam {
    String subject;
    String date;

    Exam(String subject, String date) {
        this.subject = subject;
        this.date = date;
    }


    static ArrayList<Exam> exams = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- EXAM SCHEDULER ---");
            System.out.println("1. Add Exam");
            System.out.println("2. View Timetable");
            System.out.println("3. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addExam();
                case 2 -> viewExams();
                case 3 -> System.out.println("Scheduler closed.");
                default -> System.out.println("Invalid option");
            }
        } while (choice != 3);
    }

    static void addExam() {
        System.out.print("Subject: ");
        String subject = sc.nextLine();

        System.out.print("Date (DD/MM): ");
        String date = sc.nextLine();

        for (Exam e : exams) {
            if (e.date.equals(date)) {
                System.out.println("Date already booked!");
                return;
            }
        }

        exams.add(new Exam(subject, date));
        System.out.println("Exam scheduled.");
    }

    static void viewExams() {
        if (exams.isEmpty()) {
            System.out.println("No exams scheduled.");
            return;
        }

        for (Exam e : exams) {
            System.out.println(e.subject + " on " + e.date);
        }
    }
}

