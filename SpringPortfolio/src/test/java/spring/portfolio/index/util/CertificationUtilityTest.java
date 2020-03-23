package spring.portfolio.index.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.certification.model.CertificationVO;
import com.spring.portfolio.common.util.certification.CertificationUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml" })
public class CertificationUtilityTest {

	@Resource(name = "mailSender")
	private JavaMailSender mailSender;
	private MimeMessageHelper helper;
	private MimeMessage mimeMessage;

	@Before
	public void testMailSenderDI() throws MessagingException {
		assertNotNull(mailSender);
		mimeMessage = mailSender.createMimeMessage();
		assertNotNull(mimeMessage);
		helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

		assertNotNull(helper);

	}

	@Test
	public void testSend() throws MessagingException {
		helper.setSubject("학경아 이메일 인증 해보자");
		helper.setText("<a href='http://localhost/certification/test?code=qwondqowdno'>이메일 인증</a>", true);
		helper.setFrom("portfolioemail0215@gmail.com");
		helper.setTo("ywyi1992@gmail.com");
		mailSender.send(mimeMessage);
 
	}

	@Test
	public void testUtilGetInspectionCode() {
		try {
			String inspection = new CertificationUtility().inspectionCode("ywyi1992@gamil.com");
			assertNotNull(inspection);
			assertEquals("fd64c3a0645f4065e58ce2b3e1151623cdc3494ec4440c783132370915229", inspection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testUtilSend() throws Exception {
		String to = "egniz@naver.com";
		CertificationVO vo = new CertificationVO(new CertificationUtility().setContent(to), to);
		System.out.println(vo.getContent());
		helper.setSubject(vo.getSubject());
		helper.setText(vo.getContent(), true);
		helper.setFrom(vo.getForm());
		helper.setTo(vo.getTo());
		mailSender.send(mimeMessage);
	}

}
