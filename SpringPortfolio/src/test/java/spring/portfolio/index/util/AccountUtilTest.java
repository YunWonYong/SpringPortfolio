package spring.portfolio.index.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;

import com.spring.portfolio.common.util.account.AccountUtility;

public class AccountUtilTest {
	private AccountUtility util;
	private Calendar c;
	private String realTime;
	private Cookie[] cookies;
	private long assertValue;

	@Before
	public void testSet() {
		c = Calendar.getInstance();
		realTime = String.valueOf(c.getTimeInMillis());
		assertValue = Long.parseLong(realTime);
		util = new AccountUtility();
		cookies = new Cookie[] { new Cookie("a_jsession_id", "success"), new Cookie("test", "test") };
	}

	@Test
	public void testGetHoldingTime() {
		assertTrue((assertValue + (60 * 60 * 24 * 1000))==Long.valueOf(util.getHoldingTime()));
	}

	@Test
	public void testCookieCheck() {
		Cookie cookie = util.getCookie(cookies);
		assertNotNull(cookie);
		assertEquals(cookie.getValue(), cookies[0].getValue());

	}

	@Test
	public void testGetLifeTimeCheck() {
		String a_holding_time = util.getHoldingTime();
		assertTrue(util.lifeTimeCheck(a_holding_time));
		assertFalse(util.lifeTimeCheck(String.valueOf(Long.parseLong(a_holding_time) - ((60 * 60 * 24 * 1000) + 1))));

	}

}
