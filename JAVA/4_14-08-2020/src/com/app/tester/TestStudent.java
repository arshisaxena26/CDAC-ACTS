/* Q2--Continued
2.5 Write a TestStudent class in tester package
	Prompt user for class size(how many students ?)
	Create suitable array.

Menu 

1. Admit new Student
	I/P student details (name,email,age)
	If there is a space , accept n store student details.
	Otherwise give error message : class capacity full!!!

2. Assign scores (quiz , test assignment all out of 100)
	I/P student's roll no & 3 scores
	O/P In case of success : scores added & GPA computed!
	In case of failure : invalid student id.

3. Display details of topper

4. Exit
*/

package com.app.tester;

import java.util.Scanner;

import com.cdac.core.Student;

public class TestStudent {
	public static void main(String[] args) {
		System.out.println("How many Student?");

		Scanner sc = new Scanner(System.in);
		Student[] students = new Student[sc.nextInt()];

		boolean exit = false;
		int counter = 0;

		while (!exit) {
			System.out.println("-----OPTIONS------");
			System.out.println("1.Admit new Student");
			System.out.println("2.Assign scores");
			System.out.println("3.Display details of topper");
			System.out.println("4.EXIT");

			switch (sc.nextInt()) {
			case 1:
				if (students[students.length - 1] != null)
					System.out.println("Class Capacity Full");
				
				else {
					System.out.println("Enter Student's Name,Email and Age");
				
					for (int i = 0; i < students.length; i++) {
						if (students[i] == null) {
							sc.nextLine();
							students[i] = new Student(sc.nextLine(), sc.next(), sc.nextInt());
							counter++;
							break;
						}
					}
				}
				break;

			case 2:
				if (counter == 0)
					System.out.println("No Students Admitted");
				
				else {
					int flag = 0;
				
					System.out.println("Enter Student RollNo, Quiz,Test and Assignment Marks");
					
					int rollNo = sc.nextInt();
					
					for (int i = 0; i < students.length; i++) {
						if (students[i].getID() == rollNo) {
							students[i].computeGPA(sc.nextInt(), sc.nextInt(), sc.nextInt());
							System.out.println("Scores Added and GPA Computed");
							flag = 1;
							break;
						}
					}

					if (flag == 0)
						System.out.println("Invalid ID");
				}
				break;

			case 3:
				if (counter == 0)
					System.out.println("No Students Admitted");
				
				else {
					double max = students[0].getGPA();
					int index = 0;
				
					for (int i = 0; i < students.length; i++) {
						if (students[i] != null) {
							if (max < students[i].getGPA()) {
								max = students[i].getGPA();
								index = i;
							}
						}
					}
					System.out.println("TOPPER IS");
					System.out.println(students[index].fetchDetails());
				}
				break;

			case 4:
				System.out.println("GOODBYE!");
				exit = true;
				break;

			default:
				System.out.println("Wrong Input.Try Again!");
				break;
			}
		}
		sc.close();
	}
}
