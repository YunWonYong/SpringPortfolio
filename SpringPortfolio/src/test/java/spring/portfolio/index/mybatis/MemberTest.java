package spring.portfolio.index.mybatis;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring.portfolio.common.namespace.NameSpace;
import com.spring.portfolio.member.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class MemberTest {
	@Inject
	private SqlSession sqlSession;
	public MemberTest() {
	} 
	
	@Test
	public void testList() {
		List<Object> list = sqlSession.selectList(NameSpace.MEMBER + "list"/* ,new SearchVO("m_index",1) */);
		assertNotNull(list);
		assertTrue(list.get(0) instanceof MemberDTO);
		list.forEach(dto->{
			System.out.println(((MemberDTO)dto).getM_id());
		});
	}
}
