package studio8.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;


import studio8.MultipleChoiceQuestion;
import studio8.Question;
import studio8.Quiz;
import studio8.SelectAllQuestion;


/**
 * @author victoriaprisco
 */
public class QuizTest {
	
	public Quiz setUp() {
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

		choices = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);

		Question[] questions = {q, multipleChoice, selectAll}; 
		
		Quiz studio8quiz = new Quiz(questions);
		return studio8quiz;
	}
	
	@Test
	public void testGetTotalPoints() {
		Quiz q = setUp();
		int totalPoints = 7;
		assertEquals(totalPoints, q.getTotalPoints());
	}

	@Test
	public void testAllWrong() {
		Quiz studio8quiz = setUp();
		
		ByteArrayInputStream in = new ByteArrayInputStream("My string\nHello\nasdf\n".getBytes());
		Scanner in2 = new Scanner(in);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		studio8quiz.takeQuiz(in2);
		
		String output = outContent.toString();
		
		String prompt = "Please enter your answer:";
		int indexOfPoints = output.lastIndexOf(prompt) + prompt.length();
		
		String score = output.substring(indexOfPoints);
		
	    assertTrue("Your output:\n" + score + "But we expected: You earned -3 points.", score.contains("-3 points"));
		
	}
	
	@Test
	public void testPartialCredit() {
		Quiz studio8quiz = setUp();
		
		ByteArrayInputStream in = new ByteArrayInputStream("3\n3\n13\n".getBytes());
		Scanner in2 = new Scanner(in);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		studio8quiz.takeQuiz(in2);
		
		String output = outContent.toString();
		
		String prompt = "Please enter your answer:";
		int indexOfPoints = output.lastIndexOf(prompt) + prompt.length();
		
		String score = output.substring(indexOfPoints);
		
	    assertTrue("Your output:\n" + score + "But we expected a score of 5.", score.contains("5 points"));
		
	}
	
	@Test
	public void testAcedQuiz() {
		Quiz studio8quiz = setUp();
		
		ByteArrayInputStream in = new ByteArrayInputStream("8\n3\n13\n".getBytes());
		Scanner in2 = new Scanner(in);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		studio8quiz.takeQuiz(in2);
		
		String output = outContent.toString();
		

		String prompt = "Please enter your answer:";
		int indexOfPoints = output.lastIndexOf(prompt) + prompt.length();
		
		String score = output.substring(indexOfPoints);
		
	    assertTrue("Your output:\n" + score + "But we expected a score of 7.", score.contains("7 points"));
				
	}
}
