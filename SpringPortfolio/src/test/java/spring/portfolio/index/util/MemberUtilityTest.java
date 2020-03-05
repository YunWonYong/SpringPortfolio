package spring.portfolio.index.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.util.member.MemberUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class MemberUtilityTest {
	private MemberUtility util = new MemberUtility();

	/**
	 * @param util
	 */
	@Test
	public void testFieldVariable() {
		assertNotNull(util);
		System.out.println(util);
	}

	@Test
	public void testGetAge() {
		int age = util.getAge("1992");
		assertEquals(age, 29);
	}

	@Test
	public void testGetBirth() {
		Map<String,List<String>> map = util.getBirth();
		Iterator<String> it = map.keySet().iterator();
		it.forEachRemaining(key ->{
			System.out.println(map.get(key));
		});
	}
//	@Test
//	public void testGetYear() {
//		List<String> yearList = util.getYear();
//		List<String> testList = new ArrayList<String>();
//
//		for (int i = 2020; i > 1920; i--) {
//			testList.add(String.valueOf(i));
//		}
//
//		assertEquals(yearList.size(), 100);
//		assertEquals(Arrays.deepEquals(yearList.toArray(), testList.toArray()),true );
//		assertArrayEquals(yearList.toArray(), testList.toArray());
//	}
//
//	@Test
//	public void testGetMonth() {
//		List<String> monthList = util.getMonth();
//		List<String> testList =  new ArrayList<String>();
//		for(int i = 1; i<=12; i++) {
//			String value = String.valueOf(i);
//			testList.add(value.length()==1?"0"+value:value);
//		}
//		assertEquals(monthList.size(), 12);
//		assertEquals(Arrays.deepEquals(monthList.toArray(), testList.toArray()),true);
//		assertArrayEquals(monthList.toArray(),testList.toArray());
//		
//	}
}
