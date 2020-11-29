/* file: Project/QuizBuilderAJAK.java */
import java.util.*;
import java.io.*; 
import java.util.Scanner;

/* 
very loose structure:

load CSV questions
menu option to do multiple choice math (and later other questions but let's start with math)
each numbered question is an object with charectistics of:
the question itself, answer possibilties, and the actual answer

steps
call the question
display answer possiblities
have user input a guess
check to see if their answer equals the actual answer 
Q: how to do this with a CSV? we could read each thing into an array 
and check the guess to see if question_3[6] == "B"? Not sure here.
have a questions_correct_counter go +1 if they get it right
have a questions_attempted_counter go +1 regardless of right or wrong

on exit, display the scores of correct, attempted, and correct %

*/  
class QuizBuilder {
	//public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		/*
		//test question, no files yet
		Question q = new Question("What is the capital of Massachusetts?", "Amherst", "Boston", "Springfield", "Worchester", "Holyoke", "Boston");
		System.out.println(q);
		*/
	
		ReadQuestionCSV try1 = new ReadQuestionCSV();
		System.out.println(try1);
		
		/*
		// MENU
		// we need to swap out the cases with our own stuff
		do{
			System.out.println("Menu.");
			System.out.println("1 = Instructions");
			System.out.println("2 = Try quiz");
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
	//menu printed during startup 
	static void printMenu() {
		// menu options: math question, authors, exit
		
	} //printMenu
	static void read(String filename) {} //read a CSV file
	static void write() {} //write to a CSV file
	static void checkAnswer(String guess) {}//can be either letter ("A") or whole answer ("B. Boston") 
	
}//class QuizBuilder 

public class ReadQuestionCSV {  
	public static void main(String [] args) {
		Scanner fin = null;
	    try { 	fin = new Scanner(new File("C:\\Users\\sgill\\OneDrive\\Desktop\\CSC212\\QuizBuilder\\test_GRE_questions.csv")); 
		}//try
		catch (IOException ex) {
				System.out.println("file not found!");	System.exit(1);
		}//catch
		ArrayList<String> A = new ArrayList<>();//list of question records
		while ( fin.hasNext() ){ //check end of file
			Question rec = new Question(); //make record
			readRecord(rec, fin);
			A.add(rec);
		}//while
		System.out.println(A);
		
	}
	static void readRecord (Question_records_array P, Scanner fin) {
		if (fin.hasNext()) {
			String s = fin.nextLine();  
			String A[] = s.split(","); // A[] = {"ana", "06/07/2000"}
			P.actual_question = A[0];
			P.choice_A = A[1];
			P.choice_B = A[2];
			P.choice_C = A[3];
			P.choice_D = A[4];
			P.choice_E = A[5];
			P.correct_answer = A[6];
			
		}
	}//
}

public class Question {
	
	
}

public class Question_class {
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
		return actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E;
	}//toString 
	
}//class Question 