
package spring.portfolio.index.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.exception.json.JsonException;
import com.spring.portfolio.common.exception.json.JsonStringException;
import com.spring.portfolio.common.util.json.Json;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml")
public class JsonTest {


	@Test(expected = JsonException.class)
	public void testJsonException() throws JsonException {
		Json.parsing(new HashMap<String, Object>());
		Json.parsing(1);
	}

	@Test(expected = JsonStringException.class)
	public void testJsonStringException() throws JsonException {
		Json.parsing("]");
	}

	@Test
	public void testJsonStringParsing() {
		String json = null;
		try {
			json = Json.parsing(
					"{{{{{{{{\"test1\":\"test1,"
					+ "test2\":test2,"
					+ "test3:1,"
					+ "test4:t1,"
					+ "test5:123,"
					+ "test6:null,"
					+ "test7:true,"
					+ "test8:false"
					);
			assertFalse(json.contains("]")&&json.contains("["));
			json=Json.parsing("test:test,tests:tests");
			assertTrue(json.contains("[")&&json.contains("},{")&&json.contains("]"));
			json =Json.parsing("3test1:3test1,3test2:3test2");
			assertTrue(json.indexOf("},{")!=json.lastIndexOf("},{"));
		} catch (Exception e) {
			e.printStackTrace();
			json = null; 
		}finally {
			assertNotNull("is json:"+json,json);
			System.out.println(json);
		}
	}
	
	@Test
	public void tesJsonStringElementArrayParsing() {
		String json = null;
		try {
			json = Json.parsing(Arrays.asList("1test1:1test1,1test2:1test2"));
			String fail = "is json:"+json;
			assertFalse(fail,json.contains("]")&&json.contains("["));
			json=Json.parsing(Arrays.asList("2test1:2test1,2test2:2test2"));
			fail = "is json:"+json;
			assertTrue(fail,json.contains("[")&&json.contains("},{")&&json.contains("]"));
			json =Json.parsing(Arrays.asList("3test1:3test1,3test2:3test2","4test1:4test1,4test2:4test2","5test1:5test1,5test2:5test2,5test3:5test3"));
			fail = "is json:"+json;
			assertTrue(fail,json.indexOf("},{")!=json.lastIndexOf("},{"));
			json = Json.parsing(Arrays.asList("6testFalse:false,6testTrue:true,6test:null"));
			fail = "is json:"+json;
			assertFalse(fail,json.contains("\"null\"")&&json.contains("\"false\"")&&json.contains("\"true\"")&&json.contains("}{")&&json.contains("}]{"));
		} catch (JsonException e) {
			e.printStackTrace();
			json = null;
		}finally {
			assertNotNull(json);
			System.out.println(json); 
		}
	}

	@Test
	public void testObjectEelementArrayParsing() {
		String json = null;
		try {	
			json = Json.parsing(Arrays.asList(new MemberVO(),new MemberVO()));
			System.out.println(json);
		}catch (Exception e) {
			e.printStackTrace();
			json = null;
		}finally {
			assertNotNull("is json null!!!!!!!!!!!!!!",json);
		}
	}
	
	@Test
	public void testArrayParsing() {
		String json = null;
		try {
			json = Json.parsing(Arrays.asList(new MemberVO(),"test:test"));
		}catch (Exception e) {
			e.printStackTrace();
			json  = null;
		}finally {
			assertNotNull("is json null!!!!!!!!!!!!!!",json);
			System.out.println(json);
		}
	}
}
