package spring.portfolio.index.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.util.sql.SqlMultiObject;
import com.spring.portfolio.common.vo.PagingVO;
import com.spring.portfolio.common.vo.SearchVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml")
public class SqlMultiObjectTest {

	public SqlMultiObjectTest() {
	}
	@Test
	public void testMapParameter() {
		Map<String, Object> map = SqlMultiObject.add(new SearchVO("m_id", "admin"), new PagingVO());
		assertNotNull(map);
		Iterator<String> it = map.keySet().iterator();
		returnWhile: while (it.hasNext()) {
			String key = it.next();
			assertTrue(key.equals("searchvo") || key.equals("pasingvo"));
			if (key.equals("searchvo")) {
				assertTrue(map.get(key) instanceof SearchVO);
				SearchVO search = null;
				search = (SearchVO) map.get(key);
				assertNotNull(search);
				assertTrue(search.getTarget().equals("m_id"));
				assertTrue(search.getValue().equals("admin"));
				continue returnWhile;
			}
			assertTrue(map.get(key) instanceof PagingVO);
			PagingVO pasing = null;
			pasing = (PagingVO) map.get(key);
			assertNotNull(pasing);
		}
	}
}
