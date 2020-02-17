package spring.portfolio.index.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring.portfolio.common.util.member.MemberUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/wepapp/WEB-INF/spring/**/*.xml" })
public class MemberUtilityTest {
	private MemberUtil util = new MemberUtil();

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
	public void testGetYear() {
		List<String> yearList = util.getYear();
		List<String> testList = new ArrayList<String>();

		for (int i = 2020; i > 1920; i--) {
			testList.add(String.valueOf(i));
		}

		assertEquals(yearList.size(), 100);
		assertEquals(Arrays.deepEquals(yearList.toArray(), testList.toArray()),true );
		assertArrayEquals(yearList.toArray(), testList.toArray());
	}

	@Test
	public void testGetMonth() {
		List<String> monthList = util.getMonth();
		List<String> testList =  new ArrayList<String>();
		for(int i = 1; i<=12; i++) {
			String value = String.valueOf(i);
			testList.add(value.length()==1?"0"+value:value);
		}
		assertEquals(monthList.size(), 12);
		assertEquals(Arrays.deepEquals(monthList.toArray(), testList.toArray()),true);
		assertArrayEquals(monthList.toArray(),testList.toArray());
		
	}
}
