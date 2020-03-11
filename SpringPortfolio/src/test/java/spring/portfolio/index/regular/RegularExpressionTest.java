package spring.portfolio.index.regular;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class RegularExpressionTest {

	public RegularExpressionTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testBlank() {
		String firstBlank = " sdasd";
		String lastBlank = "sdasd ";
		String middleBlank = "as as";
		assertTrue(verification("\\s.*", firstBlank));
		assertTrue(verification(".*\\s", lastBlank));
		assertFalse(verification(".*\\s", middleBlank));
		assertFalse(verification("\\s.*", middleBlank));
		assertTrue(verification(".*\\s.*", middleBlank));

	}

	@Test
	public void testIndex() {
		String input = "wefiwneifwb";
		assertTrue(verification(".*{0,}", input));
	}

	private boolean verification(String regex, String input) {
		return Pattern.matches(regex, input);
	}

}
