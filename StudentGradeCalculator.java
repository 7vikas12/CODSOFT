import java.util.*;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter no of subjects");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input marks with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.println("Enter marks for subject " + (i + 1));
                int marks = sc.nextInt();
                if (marks >= 0 && marks <= 100) {
                    arr[i] = marks;
                    break;
                } else {
                    System.out.println("Invalid input! Marks should be between 0 and 100. Try again.");
                }
            }
        }

        int total = 0;
        for (int marks : arr) {
            total += marks;
        }

        double average = (double) total / n;

        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + total + " out of "+(n*100) );
        System.out.println("Average Percentage: " + average + "%" +" out of 100%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
