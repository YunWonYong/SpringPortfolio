package spring.portfolio.index.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class DataSourceBeanTest {
	@Inject
	private DataSource dataFactory;
	
	public DataSourceBeanTest() {
	} 
	@Test
	public void testDataFactoryBean1() {
		assertNotNull(dataFactory);
	} 
	@Test
	public void testDataFactoryBean2(){
		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
			assertNotNull(conn);
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		
	}

}
