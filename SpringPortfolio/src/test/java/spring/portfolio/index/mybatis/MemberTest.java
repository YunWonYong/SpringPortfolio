package spring.portfolio.index.mybatis;

import static org.junit.Assert.*;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.common.vo.TargetAndValueAbstractVO;
import com.spring.portfolio.member.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml")
public class MemberTest {
	@Inject
	private SqlSession sqlSession;
	private String id;
	private String nickName;

	/**
	 * insert Test start
	 **/
	@Test
	public void testInsert() {
		/**
		 * 멤버변수 id,nickName 값을 필수로변경해야함
		 **/
		id = "test2";
		nickName = "test2";
		testDuplicate();
		MemberDTO dto = new MemberDTO(2, id, "1234", "테스터", 'z', "2020-03-09", 1, "00000", "테스터는집이없어요", "그래서 주소가없어요.",
				"email@email.com", "02-1992-1107", '0', null, nickName);
		assertTrue(sqlSession.insert("insert", dto) == 1);
		testRead();
	}

	@Test
	public void testDuplicate() {
		TargetAndValueAbstractVO duplicate = new DuplicateVO("m_id", id);
		MemberDTO dto = sqlSession.selectOne("duplicate", duplicate);
		assertNull("중복된아이디.", dto);

	}

	@Test
	public void testRead() {
		MemberDTO dto = new MemberDTO();
		dto.setM_id(id);
		dto = sqlSession.selectOne("read", dto);
		assertNotNull(dto);
		assertTrue(dto.getM_nickname().equals(nickName));
	}

	/**
	 * insert Test end
	 **/
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testList() {
//		PagingVO page = new PagingVO();
//		SearchVO searchvo = new SearchVO(null, "admin");
//		page.setCurrentPage(2, searchvo);
//		Map<String, Object> map = SqlMultiObject.add(searchvo, page);
//		Iterator<String> it = map.keySet().iterator();
//		returnWhile: while (it.hasNext()) {
//			String key = it.next();
//			System.out.println(key);
//			assertTrue(key.equals("searchvo") || key.equals("pagingvo"));
//			if (key.equals("searchvo")) {
//				assertTrue(map.get(key) instanceof SearchVO);
//				SearchVO search = null;
//				search = (SearchVO) map.get(key);
//				assertNotNull(search);
//				if (search.getTarget() != null) {
//					assertTrue(search.getTarget().equals("m_id"));
//					assertTrue(search.getValue().equals("admin"));
//				}
//				continue returnWhile;
//			}
//			assertTrue(map.get(key) instanceof PagingVO);
//			PagingVO pasing = null;
//			pasing = (PagingVO) map.get(key);
//			assertNotNull(pasing);
//		}
//		List<Object> list = sqlSession.selectList(NameSpace.MEMBER + "list", map);
//		assertNotNull(list);
//		for (Object obj : list) {
//			assertTrue(obj instanceof MemberDTO);
//			MemberDTO dto = (MemberDTO) obj;
//			System.out.println(list.size());
//			System.out.println(dto.getM_id());
//		}
//	}

	@Test
	public void testSearchList() {
		fail("Not yet implemented");
	}

}
