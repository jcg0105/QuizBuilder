/* file: Project/QuizBuilderAJAK.java */
import java.util.*; import java.io.*;
class QuizBuilder {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//test question, no files yet
		Question q = new Question("What is the capital of Massachusetts?", "Amherst", "Boston", "Springfield", "Worchester", "Holyoke", "Boston");
		System.out.println(q);
		/* MENU
		TAKE QUIZ (Y/N)
		
		
	}//main
	//menu printed during startup 
	static void printMenu() {
		/*
		1. Access Latest Quiz
		2. Create Quiz 
		3. Export Quiz
		*/
	} //printMenu 
	//read file and create array/arraylist of question objects 
	static void read(String filename) {} //read
	static void write() {} //write 
	static void checkAnswer(String guess) {}//can be either letter ("A") or whole answer ("B. Boston") 
	static void takeQuiz
	
}//class QuizBuilder 

class Question {
	String question; String a; String b; String c; String d; String e; String ans; 
	//instantiate new question object
	public Question(String q, String a, String b, String c, String d, String e, String ans) {
		this.question = q; 
		this.a = a; 
		this.b = b; 
		this.c = c; 
		this.d = d; 
		this.e = e; 
		this.ans = ans;
	} //constructor
	//		GETTERS
	public String getA() { return a; } 
	public String getB() { return b; }
	public String getC() { return c; }
	public String getD() { return d; } 
	public String getE() { return e; }
	public String getAnswer() { return ans; }
	public String toString() {
		return question + "\nA. " + a + "\nB. " + b + "\nC. " + c + "\nD. " + d + "\nE. " + e;
	}//toString 
	
}//class Question 