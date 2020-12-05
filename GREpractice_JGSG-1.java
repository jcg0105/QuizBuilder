/* file: QuizBuilder/QuizBuilder_JGSG.java */

import java.util.*;
import java.io.*; 
import java.util.Scanner;

/* 
Questions? Reach out to:
https://github.com/SarahGillespie Smith College, Class of 2022J
https://github.com/jcg0105 Hampshire College, 18F
*/  

class QuizBuilder {
	public static Scanner cin = new Scanner(System.in); //scanner for menu entry in printMenu()
	public static void main(String[] args) {
		printMenu();
	} // end main
	static void printMenu() {// performs the main quiz menu
		int menu_entry;
		do {
			System.out.println("Menu.");
			System.out.println("1 = Instructions");
			System.out.println("2 = Try math quiz");
			System.out.println("3 = Try vocabulary quiz");
			System.out.println("4 = Try CSC212 Quiz"); 
			System.out.println("5 = Display authors and credits");
			System.out.println("0 = exit");
			System.out.println("Pick one.");
			menu_entry = cin.nextInt();
			switch(menu_entry) {
				//added new function calls
				case 1 : printInstructions(); break; 
				case 2 : getMathQuiz(); break;
				case 3 : getVocabQuiz(); break; 
				case 4 : getCSC212Quiz(); break; // save for later, only do if time
				case 5 : printCredits(); break;
				case 0 : break;
				default : System.out.println("Cannot understand your response. Please try again.");
			} // end menu switch
		} while (menu_entry != 0);//repeat menu and its functions until the user exits the program by typing "0" into the menu
	} // end printMenu
	static void printInstructions() {//prints the instructions; called by printMenu
		System.out.println("This is a multiple choice quiz to practice the GRE General Test. \nPress the letter of your answer choice.");
		System.out.println("You will recieve immediate feedback if your choice is correct or not.");
	} // end printInstructions
	static void printCredits() { // prints the credits; called by printMenu
		System.out.println("Practice GRE Math and Vocabulary Quiz.\nAuthors: Julia Griner & Sarah Gillespie" +
							"\nDisclaimer: Questions are taken from various online sources. See the README for sources.\nThis program is purely for educational purposes.");
	} // end printCredits
	static void getMathQuiz() { // reads in the CSV with the math questions, question options, and answers; called by printMenu
		//File math_file = new File("C:\\Users\\jujub\\Documents\\GitHub\\QuizBuilder\\test_GRE_questions.csv");
		File math_file = new File("test_GRE_questions.csv").getAbsoluteFile();
		ReadCSV read_math_quiz = new ReadCSV(math_file); //an instance of the ReadCSV() class
		ArrayList<Question> Math_Quiz = read_math_quiz.process_the_CSV();//the process_the_CSV() function within the ReadCSV() class
		// System.out.println("PRINT THE ARRAY LIST");
		// System.out.println(Math_Quiz.toString());
	} // end getMathQuiz
	static void getVocabQuiz() {
	} // getVocabQuiz
	static void getCSC212Quiz() {
		// getCSC212Quiz
	} // getCSC212Quiz
	
}//class QuizBuilder 

public class ReadCSV { // ReadQuestionCSV --> ReadCSV
	File fileName;
	public ReadCSV(File fileName) {
		this.fileName = fileName;
		System.out.println("this is in public ReadCSV(File fileName) ");
	} //ReadCSV constructor
	
	public ArrayList<Question> process_the_CSV() {
		Scanner fin = null;
		
	    try { 	fin = new Scanner(fileName); }// attempts to read the file
		catch (IOException ex) {
				System.out.println("file not found!");
				System.out.println(ex);
		}// catch for if the file is not found
		
		ArrayList<Question> Question_ARRAYLIST = new ArrayList<>(); //list of Questions
		while ( fin.hasNext() ){ //do this until it reaches the end of the questions CSV
			String current_question = fin.nextLine();
			//String[] questions = current_question.split(",");
			String[] question_parts_qchoicesora = current_question.split(",");
			Question Q = new Question(question_parts_qchoicesora[0],
			question_parts_qchoicesora[1],
			question_parts_qchoicesora[2],
			question_parts_qchoicesora[3],
			question_parts_qchoicesora[4],
			question_parts_qchoicesora[5],
			question_parts_qchoicesora[6]); // make a question record
			
			Question_ARRAYLIST.add(Q); // add each question to List of Questions
		}//while
		// fin.close();
		readRecord(Question_ARRAYLIST);
		return Question_ARRAYLIST; 
		}
		static int[] readRecord (ArrayList<Question> list_of_questions_arraylist) {	// <-- pass in list of questions
		Scanner fin = null; 
		
		// counters
		int number_correct_int = 0;
		int number_attempted_int = 0;
		int amount = 0;
		
		//int a[] = {1, 2};
		
		// a location for the user to state how many questions they would like to recieve
		Scanner amount_user_will_answer = new Scanner(System.in); // starts the scanner
		System.out.println("How many questions would you like to answer?");  // prompt for the int
		int amount_user_will_answer_int = amount_user_will_answer.nextInt(); //scanner takes in the next line
		do {
			// opportunity for the user to input their guess
			Scanner guess_entry = new Scanner(System.in); // starts the scanner
			System.out.println(list_of_questions_arraylist.get(amount));//prints the question
			System.out.println("What is your answer?");  // prompt for the string
			String user_entry_string = guess_entry.nextLine(); //scanner takes in the next line
			
			// checks to see if the user answered the question correctly
			if (user_entry_string.equalsIgnoreCase(list_of_questions_arraylist.get(amount).correct_answer)){
				System.out.println("correct");
				number_correct_int++;
				number_attempted_int++;
			} else {
				System.out.println("false, the correct answer is " + list_of_questions_arraylist.get(amount).correct_answer);
				number_attempted_int++;
			}
			amount ++;
			//readRecord(list_of_questions_arraylist);
		} while ( amount < amount_user_will_answer_int && amount < list_of_questions_arraylist.size());
		
		
		//do this for the number of questions the user wants or until the CSV runs out of questions
		int[] score = {number_correct_int, number_attempted_int};
		int grade = (int) (score[0] / score[1]) * 100;
		System.out.println("You scored " + score[0] + " out of " + score[1] + ".\nYour grade is " + grade + "%.");
		//while loop -- end program early
		return score; //returns an array with the score. ex. [3, 4]
		//return a;
	} // readRecord class
	
} // ReadCSV class 


//Question class -- takes parameters: Question, 5 answer options, and correct answer
public class Question {
	
	String actual_question; String choice_A; String choice_B; String choice_C; String choice_D; String choice_E; String correct_answer; 
	
	//instantiate new question object
	public Question(String actual_question, String choice_A, String choice_B, String choice_C, String choice_D, String choice_E, String correct_answer) {
		this.actual_question = actual_question; 
		this.choice_A = choice_A; 
		this.choice_B = choice_B; 
		this.choice_C = choice_C; 
		this.choice_D = choice_D; 
		this.choice_E = choice_E; 
		this.correct_answer = correct_answer;
	} //constructor
	/*
	//		GETTERS
	public String getQuestion() { return actual_question; }
	public String getA() { return choice_A; } 
	public String getB() { return choice_B; }
	public String getC() { return choice_C; }
	public String getD() { return choice_D; } 
	public String getE() { return choice_E; }
	public String getAnswer() { return correct_answer; }
	*/
	public String toString() {
		return "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E;
	}//toString 
	public String toString_correct_answer_only() {
		return correct_answer;
	}//toString 
}//class Question_List
