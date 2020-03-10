package spring.portfolio.index.mybatis;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring.portfolio.account.model.AccountDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml" })
public class AccountTest {
	@Inject
	private SqlSession sqlSession;
	@Value("#{namespace['account.namespace']}")
	private String NA;

	@Test
	public void testAutoLogin() {
		System.out.println(sqlSession);
		String jsessionID = "test";
		System.out.println(NA);
		AccountDTO dto = sqlSession.selectOne(NA + "autologin", jsessionID);
	}

	@Test
	public void testInsert() {
		AccountDTO dto = new AccountDTO();
		Calendar c = Calendar.getInstance();
		int holdingTime = Integer.parseInt(String.valueOf(c.getTimeInMillis()).substring(0, 7));
		dto.setM_id("admin");
		dto.setA_holding_time(holdingTime);
		dto.setA_jsession_id("testjsessionID");
		assertTrue((NA + "insert").equals("com.spring.portfolio.account.insert"));
		int i = sqlSession.insert(NA + "insert", dto);
		assertTrue(i == 1);
	}

}
