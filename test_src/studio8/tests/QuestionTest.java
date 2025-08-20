package studio8.tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


import studio8.Question;

 
/**
 * @author victoriaprisco
 */
public class QuestionTest {
	@Test
	public void testCheckAnswer() {
		Question q131 = new Question("What is a hot dog?", "A sandwich", 131);
		assertEquals(q131.checkAnswer("Not a sandwich"), 0); // Ensure that a wrong answer gives 0 points
		assertEquals(q131.checkAnswer("A sandwich"), 131); // Ensure that a right answer gets the total points
	}
	
	@Test
	public void testGetters() {
		Question q131 = new Question("Who will win the 2025 World Series?", "The New York Yankees", 131);
		assertEquals(q131.getAnswer(), "The New York Yankees"); 
		assertEquals(q131.getPoints(), 131);
	}
}

