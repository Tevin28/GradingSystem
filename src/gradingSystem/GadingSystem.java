package gradingSystem;

import java.util.*;

public class GadingSystem {
	private String name;
	private int mark;
	private char grade;
	
	public GadingSystem(String name, int mark) {
		this.name = name;
        
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        } else {
            this.mark = -1; // Indicate an invalid mark
        }
        
        this.calculateGrade();
	}
	
	
	public String getName() {
		return name; 
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMark() {
		return mark;
	}


	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public char getGrade() {
		return grade;
	}
	
	private void calculateGrade() {
        if (this.mark < 0) {
            this.grade = '?'; // Invalid mark
        } else if (this.mark < 40) {
            this.grade = 'F';
        } else if (this.mark < 55) {
            this.grade = 'D';
        } else if (this.mark < 70) {
            this.grade = 'C';
        } else if (this.mark < 85) {
            this.grade = 'B';
        } else { // 85 to 100
            this.grade = 'A';
        }
    }
	
	public String getGradeDescription() {
        switch (this.grade) {
            case 'A':
                return "Excellent";
            case 'B':
                return "Good";
            case 'C':
                return "Satisfactory";
            case 'D':
                return "Pass";
            case 'F':
                return "Fail";
            default:
                return "Invalid Mark/Grade";
        }
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--- Welcome to the Student GadingSystem ---");
		 
		while (true) {
	        System.out.println("\nEnter student name (or type 'quit' to exit):");
	        String currentName = scanner.nextLine();
	
            // Check for exit condition (using break)
            if (currentName.trim().equalsIgnoreCase("quit")) {
                break; 
            }

            if (currentName.trim().isEmpty()) {
                System.err.println("Name cannot be empty. Try again please!");
                continue; 
            }

            int currentMark = -1; // Initialize with an invalid value
            boolean validMarkEntered = false;
            while (!validMarkEntered) {
                System.out.println("Enter mark for " + currentName + " (0-100):");
                try {
                    currentMark = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    if (currentMark >= 0 && currentMark <= 100) {
                        validMarkEntered = true; 
                    } else {
                        System.err.println("The mark must be between 0 and 100. Please enter mark again.");
                        // Loop continues to re-prompt
                    }
                } catch (Exception e) { 
                    System.err.println("Error: Invalid input. Please enter a whole number for the mark.");
                    scanner.nextLine();
                    // Loop continues to re-prompt
                }
            }

            GadingSystem studentRecord = new GadingSystem(currentName, currentMark);

            System.out.println("\n--- Result ---");
            System.out.println("Student: " + studentRecord.getName() +
                               ", Mark: " + studentRecord.getMark() +
                               ", Grade: " + studentRecord.getGrade() +
                               " (" + studentRecord.getGradeDescription() + ")");
            System.out.println("--------------");

        }

        System.out.println("\n--- GadingSystem finished. ---");
        scanner.close(); // Close the scanner resource

	}


}
