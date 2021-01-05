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
	public static void main(String[] args) {
		printMenu();
	} // end main
	static void printMenu() {// performs the main quiz menu
		Scanner cin = new Scanner(System.in);
		int menu_entry;
		do {
			System.out.println("Menu.");
			System.out.println("1 = Instructions");
			System.out.println("2 = Try math quiz");
			System.out.println("3 = Try vocabulary quiz");
			System.out.println("4 = none now"); 
			System.out.println("5 = Try verbal reasoning Quiz"); 
			System.out.println("6 = Display authors and credits");
			System.out.println("0 = exit");
			System.out.println("Pick one.");
			menu_entry = cin.nextInt();
			switch(menu_entry) {
				case 1 : printInstructions(); break; 
				case 2 : getMathQuiz(); break;
				case 3 : getVocabQuiz(); break; 
				//case 4 : getCSC212Quiz(); break;
				case 5 : getVerbalReasoning(); break;
				case 6 : printCredits(); break;
				case 0 : break;
				default : System.out.println("Cannot understand your response. Please try again.");
			} // end menu switch
		} while (menu_entry != 0);//repeat menu and its functions until the user exits the program by typing "0" into the menu
	} // end printMenu
	static void printInstructions() {//prints the instructions; called by printMenu
		System.out.println("This is a multiple choice quiz to practice the GRE General Test. \nPress the letter of your answer choice.");
		System.out.println("You will recieve immediate feedback if your choice is correct or not.");
		System.out.println("You may want scratch paper and a pencil for the math quiz.");
	} // end printInstructions
	static void printCredits() { // prints the credits; called by printMenu
		System.out.println("Practice GRE Math and Vocabulary Quiz.\nAuthors: Julia Griner & Sarah Gillespie" +
							"\nDisclaimer: Questions are taken from various online sources. See the README for sources.\nThis program is purely for educational purposes.");
	} // end printCredits
	static void getMathQuiz() { // reads in the CSV with the math questions, question options, and answers; called by printMenu
		File math_questions_file = new File("math_questions.txt").getAbsoluteFile();
		ReadTXT read_math_questions_quiz = new ReadTXT(math_questions_file); //an instance of the ReadTXT() class
		ArrayList<Question> math_questions_quiz = read_math_questions_quiz.process_the_txt();//the process_the_CSV() function within the ReadTXT() class
	} // end getMathQuiz
	static void getVocabQuiz() { //reads in CSV with vocab questions, question options, and answers; called by printMenu
		File vocabulary_questions_file = new File("vocabulary_questions.txt").getAbsoluteFile();
		ReadTXT read_vocabulary_questions_quiz = new ReadTXT(vocabulary_questions_file); //an instance of the ReadTXT() class
		ArrayList<Question> vocabulary_questions_quiz = read_vocabulary_questions_quiz.process_the_txt();//the process_the_CSV() function within the ReadTXT() class
	}
	static void getVerbalReasoning() { 
		File VerbalReasoning_file = new File("verbal_reasoning_questions.txt").getAbsoluteFile();
		ReadTXT read_VerbalReasoning_quiz = new ReadTXT(VerbalReasoning_file); //an instance of the ReadTXT() class
		ArrayList<Question> VerbalReasoning_quiz = read_VerbalReasoning_quiz.process_the_txt();//the process_the_CSV() function within the ReadTXT() class
	} // getVerbalReasoning
	
}//class QuizBuilder 

public class ReadTXT { // ReadQuestionCSV --> ReadTXT
	File fileName;
	public ReadTXT(File fileName) {
		this.fileName = fileName;
	} //ReadTXT constructor
	public ArrayList<Question> process_the_txt() {
		Scanner fin = null;
	    try { 	fin = new Scanner(fileName); }// attempts to read the file
		catch (IOException ex) {
				System.out.println("file not found!");
				System.out.println(ex);
		}// catch for if the file is not found
		
		ArrayList<Question> Question_ARRAYLIST = new ArrayList<>(); //list of Questions
		while ( fin.hasNext() ){ //do this until it reaches the end of the questions CSV
			String current_question = fin.nextLine();
			String[] question_parts_qchoicesora = current_question.split("\t");
			Question Q = new Question(question_parts_qchoicesora[0],//source
			question_parts_qchoicesora[1],//number of answer choices
			question_parts_qchoicesora[2],//the correct answer(s)
			question_parts_qchoicesora[3],//question instructions
			question_parts_qchoicesora[4],//the question itself
			question_parts_qchoicesora[5],//answer choice A
			question_parts_qchoicesora[6],//answer choice B
			question_parts_qchoicesora[7],//answer choice C
			question_parts_qchoicesora[8],//answer choice D
			question_parts_qchoicesora[9],//answer choice E
			question_parts_qchoicesora[10],//answer choice F
			question_parts_qchoicesora[11],//answer choice G
			question_parts_qchoicesora[12],//answer choice H
			question_parts_qchoicesora[13]);//answer choice I
			// makes a question record
			
			Question_ARRAYLIST.add(Q); // add each question to List of Questions
		}//while
		readRecord(Question_ARRAYLIST);
		return Question_ARRAYLIST; 
	}// process_the_txt
		static void readRecord (ArrayList<Question> list_of_questions_arraylist) {	// <-- pass in list of questions
		Scanner scan = new Scanner(System.in);
		
		double grade; // (number_correct / number_attempted) * 100
		// counters
		int number_correct_int = 0;
		int number_attempted_int = 0;
		int amount = 0; // current question
		
		// a location for the user to state how many questions they would like to recieve
		Scanner amount_user_will_answer = new Scanner(System.in); // starts the scanner
		System.out.println("How many questions would you like to answer? The current quiz is " + list_of_questions_arraylist.size() + " questions long.");  // prompt for the int
		int amount_user_will_answer_int = amount_user_will_answer.nextInt(); //scanner takes in the next line
		do {
			// opportunity for the user to input their guess
			Scanner guess_entry = new Scanner(System.in); // starts the scanner
			System.out.println(list_of_questions_arraylist.get(amount));//prints the question
			System.out.println("What is your answer?");  // prompt for the string
			String user_entry_string = guess_entry.nextLine(); //scanner takes in the next line
			
			// checks to see if the user answered the question correctly
			if (user_entry_string.equalsIgnoreCase(list_of_questions_arraylist.get(amount).correct_letters)){
				System.out.println("Correct");
				number_correct_int++;
				number_attempted_int++;
			} else {
				System.out.println("Incorrect. The correct answer is " + list_of_questions_arraylist.get(amount).correct_letters);
				number_attempted_int++;
			}
			amount ++;
		} while ( amount < amount_user_will_answer_int && amount < list_of_questions_arraylist.size());
		
		
		//do this for the number of questions the user wants or until the CSV runs out of questions
		int[] score = {number_correct_int, number_attempted_int};
		grade = (double) number_correct_int/number_attempted_int;
		grade = grade*100;
		double rounded_grade = Math.round(grade * 100.0) / 100.0;
		System.out.println("You scored " + score[0] + " out of " + score[1] + ".\nYour grade is " + rounded_grade + "%.");

		//skip returning to menu after quiz is taken
		System.out.println("Take quiz again? (y/n) ");
		String take_quiz_again = scan.nextLine();
		if (take_quiz_again.equalsIgnoreCase("Y")) { readRecord(list_of_questions_arraylist); }	
	} // readRecord class
	
} // ReadTXT class 


//Question class -- takes parameters: Question, 5 answer options, and correct answer
public class Question {
	
	String source;
	String total_answers;
	String correct_letters; 
	String instructions;
	String actual_question;
	String choice_A;
	String choice_B;
	String choice_C;
	String choice_D;
	String choice_E;
	String choice_F;
	String choice_G;
	String choice_H;
	String choice_I;
	
	//instantiate new question object
	public Question(String source, String total_answers, String correct_letters, String instructions, String actual_question, String choice_A, String choice_B, String choice_C, String choice_D, String choice_E, String choice_F, String choice_G, String choice_H, String choice_I ) {
		this.source = source;
		this.total_answers = total_answers;
		this.correct_letters = correct_letters;
		this.instructions = instructions;
		this.actual_question = actual_question; 
		this.choice_A = choice_A; 
		this.choice_B = choice_B; 
		this.choice_C = choice_C; 
		this.choice_D = choice_D; 
		this.choice_E = choice_E;
		this.choice_F = choice_F; 
		this.choice_G = choice_G; 
		this.choice_H = choice_H;
		this.choice_I = choice_I; 		
		
	} //constructor

	//		GETTERS
	public String getSource() {return source;}
	public String getTotalAnswers() { return total_answers; }
	public String getAnswer() { return correct_letters; }
	public String getInstructions() { return instructions; }
	public String getActualQuestion() { return actual_question; }
	public String getA() { return choice_A; } 
	public String getB() { return choice_B; }
	public String getC() { return choice_C; }
	public String getD() { return choice_D; } 
	public String getE() { return choice_E; }
	public String getF() { return choice_F; }
	public String getG() { return choice_G; }
	public String getH() { return choice_H; } 
	public String getI() { return choice_I; }
	

	public String toString() {
		//prints a variable number of answer choices based on the number of answer options
		if (total_answers.equals("0")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\n" + source + "\n" + "Enter your response in the box.";
		} else if (total_answers.equals("3")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\n" + source + "\n";
		} else if (total_answers.equals("4")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + source + "\n";
		} else if (total_answers.equals("5")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E + "\n" + source + "\n";
		} else if (total_answers.equals("6")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E + "\nF. " + choice_F + "\n" + source + "\n";
		} else if (total_answers.equals("7")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E + "\nF. " + choice_F + "\nG. " + choice_G + "\n" + source + "\n";
		} else if (total_answers.equals("8")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E + "\nF. " + choice_F + "\nG. " + choice_G + "\nH. " + choice_H + "\n" + source + "\n";
		} else if (total_answers.equals("9")){
			return "\n" + "\n" + instructions + "\n" + "\n" + actual_question + "\nA. " + choice_A + "\nB. " + choice_B + "\nC. " + choice_C + "\nD. " + choice_D + "\nE. " + choice_E + "\nF. " + choice_F + "\nG. " + choice_G + "\nH. " + choice_H + "\nI. " + choice_I + "\n" + source + "\n";
		} else {
			return "not working";
		}
		
	}//toString 
	
}//class Question_List

