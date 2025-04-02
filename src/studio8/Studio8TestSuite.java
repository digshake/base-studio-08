package studio8;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import studio8.tests.MultipleChoiceQuestionTest;
import studio8.tests.QuestionTest;
import studio8.tests.QuizTest;
import studio8.tests.SelectAllQuestionTest;

/**
 * @author Victoria Prisco
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ QuestionTest.class, MultipleChoiceQuestionTest.class, SelectAllQuestionTest.class,
	QuizTest.class, })
public class Studio8TestSuite {

}
