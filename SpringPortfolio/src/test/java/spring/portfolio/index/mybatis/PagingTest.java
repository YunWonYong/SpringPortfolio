package spring.portfolio.index.mybatis;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.util.sql.SqlMultiObject;
import com.spring.portfolio.common.vo.PagingVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.paging.model.PagingEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml"})
public class PagingTest {
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	private String target;
	private String value;
	private String primaryKey = "m_index";
	private String tablaName = "portfolio_member";

	@Test
	public void testQuery() {
		target = "m_nickname";
		value = "test1";
		Map<String, Object> map = SqlMultiObject.add(new PagingVO(primaryKey, tablaName, 1),
				new SearchVO(target, value));
		Iterator<String> it = map.keySet().iterator();
		mapChang: while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			if (map.get(key) instanceof SearchVO) {
				SearchVO vo = (SearchVO) map.get(key);
				if (vo.getTarget() == null) {
					assertNull(vo.getTarget());
					assertNull(vo.getValue());
				} else {
					assertTrue(vo.getTarget().equals(target));
					assertTrue(vo.getValue().equals(value));
				}
				continue mapChang;
			}
			PagingVO vo = (PagingVO) map.get(key);
			assertTrue(vo.getPrimaryKey().equals(primaryKey)); 
			assertTrue(vo.getTableName().equals(tablaName));
		}
		int i = sqlSession.selectOne( "amount", map);
		System.out.println(i);
	}

	@Test
	public void testService() throws Exception {
		target = "m_nickname";
		value = "test1";
		Map<String, Object> map = SqlMultiObject.add(new PagingVO(primaryKey, tablaName, 1),
				new SearchVO(target, value));
		PagingEntity entity= new PagingEntity();
		int amount = sqlSession.selectOne("amount",map);
		entity.setAmount(amount,(PagingVO)map.get("pagingvo"));
		int minimum = entity.getMinimum();  
		int maximum = entity.getMaximum();
		System.out.println(minimum);
		System.out.println(maximum);
		assertTrue(minimum==0);
		assertTrue(maximum>0); 
	}
}
