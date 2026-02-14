// @author Alexa Montilla
// Copyright © Alexa Montilla 2025. All rights reserved. 

//PromptBank - 12.15.25

// URL: https://drive.google.com/file/d/1QB2_IbcItYS-o84mezZNq5-JkVjfY_Do/view?usp=sharing
// Self Tutory & ChatGBT study, learn, and revision feature only. No code generation! 
// CMP167 & CMP 157 Final WorkShop with Prof.Madramootoo (templates and idea) - 12.06.25
// CS LAB Tutoring center - (fixing minor/major issues) 12.13.2025
// YouTube Statement/Question support: https://www.youtube.com/watch?v=noCPyoEXZJM

// Main class for storing Eliza's prompt
import java.util.Random; // NEW INFO: random numbers = Math.**
public class PromptBank { 

	// Used arrays to hold statement and question templates. These two arrays will be initialize later on
	public String[] statements; // store statements using first & last words
	public String[] questions;  // store questions using first & last words
	public String[] answersStatements; // Stores Eliza's statement's-style (for normal/ dramatic sentences) 
	public String[] answersQuestions; // Stores Eliza's question-style (when user ask a question) 
	
	Random rand = new Random(); // Created a random object used to generate random numbers 
	
	private final int MAX_PROMPT_BANK = 8; // review 'final'
	
	// NEW INFO LEARNED: Don't add 'static' and 'void' for constructor
	public PromptBank() { // this is a constructor - runs when PromptBank object is made
	
		statements = new String[MAX_PROMPT_BANK]; // initialize arrays w/ 8 indexes to correct length 
		questions = new String[MAX_PROMPT_BANK]; // limit the maximum number of characters allowed in a single chat message
		answersStatements = new String[MAX_PROMPT_BANK];
		answersQuestions = new String[MAX_PROMPT_BANK];
		
		// populateQuestionsArray(); 
		// populateStatementsArray(); 
	}

	public void fillStatementsArray(String firstWord, String lastWord) {
		String word1 = firstWord; 
		String word2 = lastWord; 
 
		// Each array is different statement template 
		answersStatements[0] = "Tell me more about " + word1 + " and " + word2 + "."; 
		answersStatements[1] = word1 + " seems important to you, so does " + word2 + ". Please tell me more."; 
		answersStatements[2] = word1 + " and " + word2 + " seem to be on your mind. Let's talk about it."; 
		answersStatements[3] = "I want to know more about " + word1 + " and " + word2 + ".";
		answersStatements[4] = "I would love to know more about " + word1 + " and " + word2 + "."; 
		answersStatements[5] = "Teach me more about " + word1 + " and " + word2 + ".";
		answersStatements[6] = word1 + " seems important to you, so does " + word2 + ". Please tell me more."; // repeat from statement 1
		answersStatements[7] = word1 + " and " + word2 + " seem very interesting. Let's talk more about it.";

	}  
	
	public void fillQuestionsArray(String firstWord, String lastWord) {
		String word1 = firstWord; 
		String word2 = lastWord; 
		
		// Each array is different question template 
		answersQuestions[0] = "Is there anything else about " + word1 + " and " + word2 + "?"; 
		answersQuestions[1] = "Does " + word1 + " bother you? How about " + word2 + "?";  
		answersQuestions[2] = "Are " + word1 + " and " + word2 + " things you think about often?"; 
		answersQuestions[3] = "What is it about " + word1 + " and " + word2 + " that intrigues you?";
		answersQuestions[4] = "Do you know anything else about " + word1 + " and " + word2 + "?";
		answersQuestions[5] = "How important are " + word1 + " and " + word2 + "?";
		answersQuestions[6] = "Do you find " + word1 + " and " + word2 + " captivating?";
		answersQuestions[7] = "What's the difference between " + word1 + " and " + word2 + "?";
		
	}

	
	public void populateStatementsArray() {
		// Each array is different statement template 
		statements[0] = "Tell me more about BLANK1 and BLANK2."; 
		statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more."; 
		statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it."; 
		statements[3] = "I want to know more about BLANK1 and BLANK2.";
		statements[4] = "I would love to know more about BLANK1 and BLANK2."; 
		statements[5] = "Teach me more about BLANK1 and BLANK2.";
		statements[6] = "BLANK1 seems important to you, so does BLANK2."; // repeat from statement 1
		statements[7] = "BLANK1 and BLANK2 seem very interesting. Let's talk more about it.";
	}
	
	public void populateQuestionsArray() {
		// Each array is different question template 
		questions[0] = "Is there anything else about BLANK1 and BLANK2?"; 
		questions[1] = "Does BLANK1 bother you? How about BLANK2?";  
		questions[2] = "Are BLANK1 and BLANK2 things you think about often?"; 
		questions[3] = "What is it about BLANK1 and BLANK2 that intrigues you?";
		questions[4] = "Do you know anything else about BLANK1 and BLANK2?";
		questions[5] = "How important are BLANK1 and BLANK2?";
		questions[6] = "Do you find BLANK1 and BLANK2 captivating?";
		questions[7] = "What's the difference between BLANK1 and BLANK2?";
		
	}
	
	public String getRandomStatement() { 
		int ranStatement = (int)(Math.random() * statements.length); // random index
		return answersStatements[ranStatement]; // this returns to the statement template
	
	} 
	
	public String getRandomQuestion() {
		int ranQuestions = (int)(Math.random() * questions.length); // random index
		return answersQuestions[ranQuestions]; // this also returns to the question template
		
	}
	// fill the method so it can randomly selects the statement template 
	// Return a random statement from the statements array
	public String getRandomStatementTrunk() { 
		populateStatementsArray(); 
		int ranStatement = rand.nextInt(8); // random index
		return statements[ranStatement]; // this returns to the statement template
	} 
	// returns a random question from the questions array
	public String getRandomQuestionTrunk() {
		populateQuestionsArray();
		int ranQuestions = rand.nextInt(8); // random index
		return questions[ranQuestions]; // this also returns to the question template
		
	}

		
} // end class
	
