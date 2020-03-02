package spring.portfolio.index.db;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class SqlSessionFactoryBeanTest {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactoryBeanTest() {
	}

	@Test
	public void testSqlSessionFactory1() {
		assertNotNull(sqlSessionFactory);
	}

	@Test
	public void tesSqlSessionFactory2() {
		SqlSession sess = sqlSessionFactory.openSession();
		assertNotNull(sess);
	}
}
