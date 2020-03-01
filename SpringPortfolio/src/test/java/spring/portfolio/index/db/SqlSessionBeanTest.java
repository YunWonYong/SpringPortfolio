package spring.portfolio.index.db;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.member.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class SqlSessionBeanTest {
	@Inject
	private SqlSession sqlSess;

	public SqlSessionBeanTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testSqlSession1() {
		assertNotNull(sqlSess);
	}

	@Test
	public void testSqlSession2() {
		MemberDTO dto = sqlSess.selectOne("com.spring.portfolio.member.read", "admin");
		System.out.println(dto.getM_id());
		assertNotNull(dto);
	}
}
