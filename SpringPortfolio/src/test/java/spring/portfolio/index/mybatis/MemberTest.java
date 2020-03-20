package spring.portfolio.index.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespaces.MapperNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.model.MemberVO;
import com.spring.portfolio.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml")
public class MemberTest {
	@Resource(name = ServiceNameSpaces.MEMBER)
	private MemberService service;
	private MemberDTO dto;
	private String m_id;
	private String m_email;
	@Value(MapperNameSpaces.MEMBER)
	private String ns;
	@Resource(name = UtilNameSpaces.MEMBER)
	private MemberUtility util;

	@Before
	public void testDataSet() {
		dto = new MemberDTO();
		m_id = "admin2"; 
		m_email = "ywyi1992@nate.com";
		assertNotNull("nameSpace value:" + ns, ns);
		assertEquals(ns, "com.spring.portfolio.member.");
		dto.setM_id(m_id);
		dto.setM_email(m_email);
		assertNotNull(service);
		assertNotNull(ns);
		assertNotNull(util);
	}
 
	@Test
	public void testServiceRegister() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setGenderCheck("on");
		vo.setYear("1992");
		dto.setM_password("1234");
		dto.setM_nickname("admin2");
		dto.setM_name("윤원용");
		dto.setM_birth("1993-12-13");
		dto.setM_age(util.getAge(vo.getYear()));
		dto.setM_zipcode("15675");
		dto.setM_address1("서울특별시 강남구 123-123");
		dto.setM_address2("중앙정보 처리 학원");
		dto.setM_phone("010-2222-2222");
		dto.setM_gender(util.setGender(vo.getGenderCheck()));
		dto.setM_grant('a');
		assertTrue(service.register(dto));
	}

	@Test
	public void testServiceModify() throws Exception {
		MemberDTO dto1 = new MemberDTO();
		MemberVO vo = new MemberVO();
		vo.setYear("1993");
		vo.setGenderCheck(null);
		dto1.setM_id(m_id);
		dto1.setM_password("4333");
		dto1.setM_nickname("호윤호윤2");
		MemberDTO dto2 = new MemberDTO();
		dto2.setM_id(m_id);
		dto2.setM_name("이윤호");
		dto2.setM_birth("1994-11-05");
		dto2.setM_age(util.getAge(vo.getYear()));
		dto2.setM_gender(util.setGender(vo.getGenderCheck()));
		MemberDTO dto3 = new MemberDTO();
		dto3.setM_id(m_id);
		dto3.setM_phone("010-1111-2222");
		dto3.setM_zipcode("05555");
		dto3.setM_address1("서울 강남구 강남동 강남면 (역삼동)");
		dto3.setM_address2("에스코 빌딩 6층 54강의실");
		dto3.setM_email("lolo18@gmail.com");
		MemberDTO dto4 = new MemberDTO();
		dto4.setM_id(m_id);
		dto4.setM_grant('z');
		assertTrue(service.modify(dto3));
		
	}

	@Test
	public void testServiceRemove() throws Exception {
		AccountDTO dto = new AccountDTO();
		dto.setM_id(m_id);
		assertTrue(service.remove(dto));
	}

}
