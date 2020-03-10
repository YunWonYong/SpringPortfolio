package spring.portfolio.index.properties;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.tomcat.util.file.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.namespace.NameSpaces;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml")
public class PropertiesTset {
	@Value(NameSpaces.MEMBER)
	private final String MEMBER;
	@Value(NameSpaces.ACCOUNT)
	private final String ACCOUNT;
	@Value(NameSpaces.PAGING)
	private final String PAGING;

	public PropertiesTset() {
		MEMBER = null;
		ACCOUNT = null;
		PAGING = null;
	}

	@Test
	public void testProperties() {
		Properties pro = new Properties(); 
		FileReader resource = null;
		try {
			resource =  new FileReader("src/main/webapp/WEB-INF/properties/namespace/namespace.properties");
			pro.load(resource);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			assertNotNull(MEMBER);
			assertNotNull(ACCOUNT);
			assertNotNull(PAGING);
			assertEquals(MEMBER, pro.get("member.mapper"));
			assertEquals(ACCOUNT, pro.get("account.mapper"));
			assertEquals(PAGING, pro.get("paging.mapper"));
		}
	}
}
