package spring.portfolio.index.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.certification.model.CertificationDTO;
import com.spring.portfolio.common.namespaces.MapperNameSpaces;
import com.spring.portfolio.common.util.certification.CertificationUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml" })
public class CertificationTest {
	@Inject
	private SqlSession sqlSession;
	@Value(MapperNameSpaces.CERTIFICATION)
	private String ns;
	private CertificationDTO dto;

	public CertificationTest() {
	}

	@Before
	public void testSetting() throws Exception {
		dto = new CertificationDTO(); // instance
		dto.setC_email("egniz@naver.com"); 
		dto.setC_inspection(new CertificationUtility().inspectionCode(dto.getC_email()));
		assertNotNull(ns);
		assertEquals(ns, "com.spring.portfolio.certification.");
	}

	@Test
	public void testrRegister() throws Exception {
		assertTrue(sqlSession.insert(ns + "insert", dto) == 1);
	}

	@Test
	public void testInspectionCheck() throws Exception {
		assertTrue(sqlSession.update(ns + "check", dto) == 1);
	}

	@Test
	public void testGetOne() {
		Object obj = sqlSession.selectOne(ns + "read", this.dto);
		assertNotNull(obj);
		assertTrue(obj instanceof CertificationDTO);
		CertificationDTO dto = (CertificationDTO) obj;
		assertEquals(this.dto.getC_inspection(), dto.getC_inspection());
		assertEquals(dto.getC_inspection_check(),"1");
	}
}
