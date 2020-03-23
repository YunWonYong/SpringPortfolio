package spring.portfolio.index.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.member.MemberUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml"})
public class MemberUtilityTest {
	@Resource(name = UtilNameSpaces.MEMBER)
	private MemberUtility util;
	/**
	 * @param util
	 */ 
	@Before
	public void testFieldVariable() {
		assertNotNull(util);
	}
	@Test
	public void testGetAge() {
		assertEquals(util.getAge("1992"), 29);
	}

	@Test
	public void testGetBirth() {
		Map<String, List<String>> map = util.getBirth();
		Iterator<String> it = map.keySet().iterator();
		it.forEachRemaining(key -> {
			System.out.println(map.get(key));
		});
	}

	@Test
	public void testGenderUtil() {
		char man = util.setGender("qweqwe");
		char woman = util.setGender(null);
		assertTrue(woman == '1');
		assertTrue(man == '0');
		assertEquals(util.getGender(man), "남자");
		assertEquals(util.getGender(woman), "여자");
	}
}
