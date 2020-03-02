package spring.portfolio.index.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class PropertiesTset {
	@Value("#{namespace['member.namespace']}")
	private String member;
	@Value("#{namespace['account.namespace']}")
	private String account;

	public PropertiesTset() {
	}

	@Test 
	public void testProperties() {
		System.out.println(member);
		System.out.println(account); 
	}
}
