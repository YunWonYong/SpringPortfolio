package spring.portfolio.index.dbcp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberServiceTest {
	@Resource(name="memberService")
	private MemberService memberService;
	public MemberServiceTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void testMember() {
	MemberDTO dto = null;
		try { 
			dto = memberService.getOne("admin");
			assertEquals(dto.getM_id(), "admin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMemberDuplicate() {
		DuplicateVO vo =new DuplicateVO();
		vo.setTarget("m_id");
		vo.setValue("admins");
		boolean flag = false;
		try {
			flag = memberService.checkDuplicate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			assertTrue(flag);
		}
		
	}
}
