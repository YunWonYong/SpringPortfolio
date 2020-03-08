package spring.portfolio.index.mybatis;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.namespace.NameSpace;
import com.spring.portfolio.common.util.sql.SqlMultiObject;
import com.spring.portfolio.common.vo.PagingVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.member.model.MemberDTO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class MemberTest {
	@Inject
	private SqlSession sqlSession;


	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}
 
	@Test 
	public void testList() {
		PagingVO page = new PagingVO();
		page.setCurrentPage(2);
		Map<String, Object> map = SqlMultiObject.add(new SearchVO(null, "admin"),page );
		Iterator<String> it= map.keySet().iterator();
		returnWhile: while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			assertTrue(key.equals("searchvo") || key.equals("pagingvo"));
			if (key.equals("searchvo")) {
				assertTrue(map.get(key) instanceof SearchVO);
				SearchVO search = null;
				search = (SearchVO) map.get(key);
				assertNotNull(search);
				if(search.getTarget()!=null) {
					assertTrue(search.getTarget().equals("m_id"));
					assertTrue(search.getValue().equals("admin"));
				}
				continue returnWhile;
			}
			assertTrue(map.get(key) instanceof PagingVO);
			PagingVO pasing = null;
			pasing = (PagingVO) map.get(key);
			assertNotNull(pasing);
		}
		List<Object> list = sqlSession.selectList(NameSpace.MEMBER + "list", map);
		assertNotNull(list);
		for (Object obj : list) {
			assertTrue(obj instanceof MemberDTO);
			MemberDTO dto = (MemberDTO) obj;
			System.out.println(list.size());
			System.out.println(dto.getM_id());
		}
	}

	@Test
	public void testDuplicate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchList() {
		fail("Not yet implemented");
	}

}
