package spring.portfolio.index.mybatis;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/junit/*Junit.xml" })
public class MailTest {
	
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
		helper.setText("보안코드는 노래방이다.", true);
		helper.setFrom("portfolioemail0215@gmail.com");
		helper.setTo("egniz@naver.com"); 
		mailSender.send(mimeMessage);

	}
}