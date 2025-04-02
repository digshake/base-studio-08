package studio8.tests;
 
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import studio8.MultipleChoiceQuestion;
import studio8.Question;

/**
 * @author victoriaprisco
 */
public class MultipleChoiceQuestionTest {
	
	@Test
	public void testDisplayPrompt() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    String[] choices = new String[] {"131", "231", "425"}
	    MultipleChoiceQuestion q = new MultipleChoiceQuestion("What is the course code for this class", "131", 1, );
	    q.displayPrompt();
	    boolean hasAll = true;
	    String questionDisplayed = "What is the course code for this class" + "(" + q.getPoints() + " points)";
	    var out = outContent.toString();
	    for(String opt : choices) {
	    	if(!out.contains(opt)) {
	    		hasAll = false;
	    	}
	    }
	    assertTrue("Your output:\n" + outContent.toString() + "\nMake sure that you call the inherited method and print the choices on new lines and includes a numbered list of options.",  hasAll);
	}
	
	@Test
	public void testGetters() {
		String[] expectedChoices = new String[] {"131", "231", "425"};
	    MultipleChoiceQuestion q = new MultipleChoiceQuestion("What is the course code for this class", "131", 1, expectedChoices);
	    String[] actualChoices = q.getChoices();
	    assertArrayEquals(expectedChoices, actualChoices);
	}
	
	@Test
	public void testCheckAnswer() {
		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);
		multipleChoice.displayPrompt();
		assertEquals(multipleChoice.checkAnswer("hi"), 0);
		assertEquals(multipleChoice.checkAnswer("1"), 0);
		assertEquals(multipleChoice.checkAnswer("3"), 1);
	}
	
}
