package studio8.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import studio8.Question;
import studio8.SelectAllQuestion;

/**
 * @author victoriaprisco
 */
public class SelectAllQuestionTest {
	String[] choices = {"instance variables", "git", "methods", "eclipse"};
	Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);

	@Test
	public void testAllIncorrect() {
		assertEquals(selectAll.checkAnswer("hi"), 0);
		assertEquals(selectAll.checkAnswer("24"), 0);
	}
	
	@Test
	public void testPartialCredit() {
		assertEquals(selectAll.checkAnswer("2"), 1);
		assertEquals(selectAll.checkAnswer("1"), 3); 
		assertEquals(selectAll.checkAnswer("3"), 3); 
		assertEquals(selectAll.checkAnswer("23"), 2); 
		assertEquals(selectAll.checkAnswer("34"), 2); 
		assertEquals(selectAll.checkAnswer("4"), 1); 
		assertEquals(selectAll.checkAnswer("124"), 1);

	}
	
	@Test
	public void testFullCredit() {		
		assertEquals(selectAll.checkAnswer("13"), 4);
		assertEquals(selectAll.checkAnswer("31"), 4);
	}

}
