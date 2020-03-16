package spring.portfolio.index.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespaces.MapperNameSpaces;
import com.spring.portfolio.member.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml" })
public class AccountTest {
	@Inject
	private SqlSession sqlSession;
	@Value(MapperNameSpaces.ACCOUNT)
	private String accountNA;
	private AccountDTO dto;
	private Calendar calendar;
	private String m_id;
	private String a_holding_time;
	private String a_jsession_id;

	@Before
	public void testLogin() {
		m_id = "tester_A";
		String m_password = "1234";
		assertNotNull(sqlSession);
		MemberDTO mdto = new MemberDTO();
		mdto.setM_id(m_id);
		mdto.setM_password(m_password);
		assertEquals(accountNA, "com.spring.portfolio.account.");
		dto = sqlSession.selectOne(accountNA + "login", mdto);
		assertNotNull(dto);
		assertEquals(dto.getM_id(), m_id);
		calendar = Calendar.getInstance();
		assertNotNull(calendar);
		String realTime = String.valueOf(calendar.getTimeInMillis());
		a_holding_time = realTime;
		a_jsession_id = "D919198DE77E514E";
		dto.setA_jsession_id(a_jsession_id);
		dto.setA_autologin_check("on");
	}

	@Test
	public void testInsert() {
		long holding = Long.parseLong(a_holding_time);
		holding += (60 * 60 * 24);
		dto.setA_holding_time(String.valueOf(holding));
		int i = sqlSession.insert(accountNA + "insert", dto);
		assertTrue(i == 1);
	}

	@Test
	public void testAutoLogin() {
		AccountDTO dto = sqlSession.selectOne(accountNA + "autologin", a_jsession_id);
		assertNotNull(dto);
		assertEquals(dto.getA_jsession_id(), a_jsession_id);
		assertEquals(dto.getM_id(), m_id);
		this.dto = dto;
	}

	@Test
	public void testUpdate() {
		testAutoLogin();
		long target = Long.parseLong(dto.getA_holding_time());
		System.out.println(a_holding_time);
		assertTrue(target > Long.parseLong(a_holding_time));
		dto.setA_holding_time(String.valueOf(Long.parseLong(a_holding_time) + (60 * 60 * 24)));
		int i = sqlSession.update(accountNA + "update", dto);
		assertTrue(i == 1);
		AccountDTO dto = sqlSession.selectOne(accountNA + "autologin", a_jsession_id);
		assertFalse(target ==  Long.parseLong(dto.getA_holding_time()));

	}

	@Test
	public void testDelete() {
		int i = sqlSession.delete(accountNA + "delete", dto);
		assertTrue(i == 1);
		this.dto = null;
	}
}
