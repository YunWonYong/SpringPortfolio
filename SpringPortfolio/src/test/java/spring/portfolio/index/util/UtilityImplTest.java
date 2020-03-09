package spring.portfolio.index.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.common.util.UtilityImpl;
import com.spring.portfolio.member.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml")
public class UtilityImplTest {
	private UtilityImpl util = new UtilityImpl();

	public UtilityImplTest() {
	}

	@Test
	public void testTransform() {
		int i = 0;
		int j = 1;
		char ch1 = '0';
		char ch2 = '1';
		boolean b1 = true;
		boolean b2 = false;
		boolean resultFlag1 = util.booleanTransform(i);
		boolean resultFlag2 = util.booleanTransform(j);
		boolean resultFlag3 = util.booleanTransform(ch1);
		boolean resultFlag4 = util.booleanTransform(ch2);
		boolean resultFlag5 = util.booleanTransform(b1);
		boolean resultFlag6 = util.booleanTransform(b2);
		assertFalse(resultFlag1);
		assertTrue(resultFlag2);
		assertFalse(resultFlag3);
		assertTrue(resultFlag4);
		assertTrue(resultFlag5);
		assertFalse(resultFlag6);

		MemberDTO dto1 = new MemberDTO();
		MemberDTO dto2 = null;
		boolean objectFlag1 = util.booleanTransform(dto1);
		boolean objectFlag2 = util.booleanTransform(dto2);
		assertTrue(objectFlag1);
		assertFalse(objectFlag2);
	}

}
