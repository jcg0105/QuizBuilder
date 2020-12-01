/* file: Project/QuizBuilderAJAK.java */
import java.util.*;
import java.io.*; 
import java.util.Scanner;

/* 

*/  
class QuizBuilder {
	//public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	
		ReadQuestionCSV try1 = new ReadQuestionCSV();//an instance of the ReadQuestionCSV() class
		try1.process_the_CSV();//the process_the_CSV() function within the ReadQuestionCSV() class
		
		/*
		// MENU
		// we need to swap out the cases with our own stuff
		do{
			System.out.println("Menu.");
			System.out.println("1 = Instructions");
			System.out.println("2 = Try math quiz");
			System.out.println("3 = Add a question");
			System.out.println("4 = Display authors and credits");
			System.out.println("0 = exit");
			System.out.println("Pick one.");
			menu_entry2 = cin.nextInt();
			
			switch(menu_entry2) {
					case 1 : print_sets(A, B); break; // name to be more specific
					case 2 : intersection(A, B); break;
					case 3 : union(A, B); break;
					case 4 : differenceA_B(user_entry_string); break;
					case 0 : break;
					default : System.out.println("Cannot understand your response. Please try again.");
				}
		} while (menu_entry2 != 0);
		*/
		
	}//main
	// print menu during starting up 
	static void printMenu() {} //printMenu
	static void read(String filename) {} //read a CSV file
	static void write() {} //write to a CSV file
	static void checkAnswer(String guess) {}//can be either letter ("A") or whole answer ("B. Boston") 
	
}//class QuizBuilder 

public class ReadQuestionCSV {  
	public static void process_the_CSV() {
		Scanner fin = null;
	    try { 	fin = new Scanner(new File("C:\\Users\\sgill\\OneDrive\\Desktop\\CSC212\\QuizBuilder\\test_GRE_questions.csv")); 
		}// attempts to read the file
		catch (IOException ex) {
				System.out.println("file not found!");
				System.exit(1);
		}// catch for if the file is not found
		ArrayList<String> A = new ArrayList<>();//list of question records
		while ( fin.hasNext() ){ //do this until it reaches the end of the questions CSV
			Question rec = new Question(); // make a question record
			int[] score = readRecord(rec, fin);
		System.out.println(Integer.toString(score[0]) + " correct out of " + Integer.toString(score[1]));
			A.add(rec.toString());
		}//while
	}

	static int[] readRecord (Question G, Scanner fin) {	
		
		// counters
		int number_correct_int = 0;
		int number_attempted_int = 0;
		int amount = 0;
		
		// a location for the user to state how many questions they would like to recieve
		Scanner amount_user_will_answer = new Scanner(System.in); // starts the scanner
		System.out.println("How many questions would you like to answer?");  // prompt for the int
		int amount_user_will_answer_int = amount_user_will_answer.nextInt(); //scanner takes in the next line
		
		do {
			String s = fin.nextLine(); // takes in the next CSV line 
			String A[] = s.split(","); // splits the line whereever there is a comma
			G.actual_question = A[0];
			G.choice_A = A[1];
			G.choice_B = A[2];
			G.choice_C = A[3];
			G.choice_D = A[4];
			G.choice_E = A[5];
			G.correct_answer = A[6];
			
			System.out.println("Question:");
			System.out.println(A[0]);
			System.out.println("Answer choices:");
			System.out.println("A. " + A[1]);
			System.out.println("B. " + A[2]);
			System.out.println("C. " + A[3]);
			System.out.println("D. " + A[4]);
			System.out.println("E. " + A[5]);
			
			// opportunity for the user to input their guess
			Scanner guess_entry = new Scanner(System.in); // starts the scanner
			System.out.println("What is your answer?");  // prompt for the string
			String user_entry_string = guess_entry.nextLine(); //scanner takes in the next line
			
			// checks to see if the user answered the question correctly
			if (user_entry_string.equals(A[6])){
				System.out.println("correct");
				number_correct_int++;
				number_attempted_int++;
			} else {
				System.out.println("false, the correct answer is " + A[6]);
				number_attempted_int++;
			}
			amount ++;
		} while ( amount < amount_user_will_answer_int && fin.hasNext());
		//do this for the number of questions the user wants or until the CSV runs out of questions
		int[] score = {number_correct_int, number_attempted_int};
		return score;//returns an array with the score. ex. [3, 4]
	
	}//readRecord class
}

public class Question {
	String actual_question; String choice_A; String choice_B; String choice_C; String choice_D; String choice_E; String correct_answer; 
	//instantiate new question object
	public void Question(String actual_question, String choice_A, String choice_B, String choice_C, String choice_D, String choice_E, String correct_answer) {
		this.actual_question = actual_question; 
		this.choice_A = choice_A; 
		this.choice_B = choice_B; 
		this.choice_C = choice_C; 
		this.choice_D = choice_D; 
		this.choice_E = choice_E; 
		this.correct_answer = correct_answer;
	} //constructor
	//		GETTERS
	public String getA() { return choice_A; } 
	public String getB() { return choice_B; }
	public String getC() { return choice_C; }
	public String getD() { return choice_D; } 
	public String getE() { return choice_E; }
	public String getAnswer() { return correct_answer; }
	public String toString() {
		return "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E;
	}//toString 
	
}//class Question 