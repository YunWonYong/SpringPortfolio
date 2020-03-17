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
		m_id = "junitTest";
		m_email = "ywyi1992@naver.com";
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
		vo.setGenderCheck(null);
		vo.setYear("1993");
		dto.setM_password("1234");
		dto.setM_nickname("윤호윤호");
		dto.setM_name("이윤효");
		dto.setM_birth("1993-12-13");
		dto.setM_age(util.getAge(vo.getYear()));
		dto.setM_zipcode("15675");
		dto.setM_address1("서울특별시 강남구 123-123");
		dto.setM_address2("중앙정보 처리 학원");
		dto.setM_phone("010-2222-2222");
		dto.setM_gender(util.setGender(vo.getGenderCheck()));
		assertTrue(service.register(dto));
	}
	
	@Test
	public void testServiceRemove() throws Exception {
		AccountDTO dto = new AccountDTO();
		dto.setM_id(m_id);
		assertTrue(service.remove(dto)); 
		
	}
}
