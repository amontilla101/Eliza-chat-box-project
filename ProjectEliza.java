// @author Alexa Montilla
// Copyright © Alexa Montilla 2025. All rights reserved. 

// ProjectEliza - 12.15.25

// Self Tutory & ChatGBT study, learn, and revision feature only. No code generation! 
// CMP167 & CMP 157 Final WorkShop with Prof.Madramootoo (templates and idea) - 12.06.25
// CS LAB Tutoring center - 12.13.2025
// YouTube Statement/Question support: https://www.youtube.com/watch?v=noCPyoEXZJM

import java.util.Scanner; // use Scanner 

public class ProjectEliza { // Main class
	public static String extractFirstWords(String sentence) { // Helper methods(3)
		// String tempString; 
		sentence = sentence.trim(); // NEW: trim() remove extra spaces at the start and last spaces 
		int firstWord = sentence.indexOf(" "); // find the first index space 
		
		// if there is no space in sentence, means there is only ONE word
		if(firstWord == -1) { 
			// Check if last character is punctuation (?, !, or .)
			if(sentence.charAt(sentence.length() - 1) == '?' || sentence.charAt(sentence.length() - 1) == '!' || sentence.charAt(sentence.length() - 1) == '.')
				return sentence.substring(0, sentence.length() - 1);
			else {
				return sentence; // if there is no punctuation, return word as is
			}
		} 
			return sentence.substring(0, firstWord); // first word before first space 
		} // end method 
		
	// this method takes and extracts first words
	public static String extractLastWords(String sentence) {
		sentence = sentence.trim(); 
		int lastWord = sentence.lastIndexOf(" "); // find the last index space  
		
		if(lastWord == -1) {
			if(sentence.charAt(sentence.length() - 1) == '?' || sentence.charAt(sentence.length() - 1) == '!' || sentence.charAt(sentence.length() - 1) == '.')
				return sentence.substring(0, sentence.length() - 1);
			else {
				return sentence; 
			}
		} 
		else { 
			if(sentence.charAt(sentence.length() - 1) == '?' || sentence.charAt(sentence.length() - 1) == '!' || sentence.charAt(sentence.length() - 1) == '.')
				return sentence.substring(lastWord + 1, sentence.length() - 1);
			else 
			return sentence.substring(lastWord + 1); // return last space to end 
		}	
	} // end method
	
	// This method checks last character of user's sentence. EX: '!', '?', '.' It decides what type of response Eliza should give 
	public static String determineResponseType(String sentence) { // make sure sentence has at least 1 character after removing spaces 
		sentence = sentence.trim(); // cleans off extra space so last character is accurate 

		//if user typed only spaces or nothing at all. Prevents errors if user enters nothing 
		if(sentence.isEmpty()) {
			return "statement"; // a default to statement 
		}
	
		char lastChar = sentence.charAt(sentence.length() - 1); // gets very last character of sentence 
		// check for question mark
		if(lastChar == '?') { // Eliza will respond to a question 
			return "question"; 
		} // check for exclamation mark
		else if(lastChar == '!') {
			return "dramatic"; // Eliza will respond to a dramatic template 'WOW!', "DRAMATIC!' 
		} 
		else if(lastChar == '.' || lastChar == ' ') {
			return "statement"; 
		}
		else {
			return "statement"; // default for everything else 
		}
		
	} // end method 

	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in); // NEW INFO: in = input 
		PromptBank pb = new PromptBank(); // pb = PromptBank 

		
		String name, sentence, repeatInput; // store user's sentence, name, and repeat session (loop) 
		
		boolean repeatSession; // outer loop control 
		
		// First do loop is outer loop to run until user says 'no'
	do {
		// Greeting per session 
		System.out.println("Hello, my name is Eliza. What is your name?"); // ask and print out user name 
		name = in.nextLine().trim(); //NEW INFO: trim(); to remove extra space 
		
		// will greet user  and ask in 1 sentence 
		System.out.println("Hello " + name + ". Tell me what is on your mind today in 1 sentence.");
		
		do { // Inner code do-while loop until user says 'EXIT' 
			
			// read user's full sentence & remove extra spaces
			sentence = in.nextLine().trim();
			if(!sentence.equalsIgnoreCase("EXIT")) { // continue if user didn't say exit 
				
				// type of user sentence 
				String type = determineResponseType(sentence); 
				
			// Respond based on type
			String first, last;
			first = extractFirstWords(sentence); // if user typed other words that are NOT exit. AKA Sentences 
			last = extractLastWords(sentence);  // take last words from sentence 
			pb.fillStatementsArray(first, last); // fill statement templates using extracted words
			pb.fillQuestionsArray(first, last); // fill question templates using extracted words
			
			if(type.equals("question")) { // if sentence ends with '?', it respond with a question
				System.out.println(pb.getRandomQuestion());
				
			} 
			else if(type.equals("dramatic") ) { // if sentence ends with '!', respond dramatically 
				System.out.println("WOW! Dramatic! " + pb.getRandomStatement()); 
			} 
			else { // Otherwise, respond with normal statement 
				System.out.println(pb.getRandomStatement());
				}

			} // end whole if 
			
		} while(!sentence.equalsIgnoreCase("EXIT")); // end inner first loop 
		
		System.out.println("Do you want to run the session again?");  
		repeatInput = in.nextLine().trim();
		
		repeatSession = repeatInput.equalsIgnoreCase("yes"); 
		
	} while(repeatSession); //outer loop repeats and ask user for another session 
	
		System.out.println("Goodbye, until next time"); // Ends the whole session

	}

} // end whole class
