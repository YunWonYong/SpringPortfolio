package spring.portfolio.index.properties;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml")
public class PropertiesTset {
	private String path = "src/main/webapp/WEB-INF/properties/";
	private final Properties PRO = new Properties();

	public PropertiesTset() {
	}

	@Test
	public void testMapperNameSpaceProperties() {
		setProperties(path + "namespace/mapperNameSpace.properties");
		assertEquals("com.spring.portfolio.account.", PRO.get("account.mapper"));
		assertEquals("com.spring.portfolio.member.", PRO.get("member.mapper"));
		assertEquals("com.spring.portfolio.paging.", PRO.get("paging.mapper"));
	}

	@Test
	public void testMailProperties() {
		setProperties(path+"mail/mail.properties");
		assertEquals("smtp.gmail.com",PRO.get("email.host"));
	}

	private void setProperties(String path) {
		Reader resource = null;
		try {
			resource = new FileReader(path);
			PRO.load(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
