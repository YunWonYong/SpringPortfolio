/*
 * package spring.portfolio.index.util;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertNotNull; import static org.junit.Assert.assertTrue;
 * 
 * import java.lang.reflect.Field; import java.util.ArrayList; import
 * java.util.Arrays; import java.util.Iterator; import java.util.List; import
 * java.util.Map;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 * 
 * import com.spring.portfolio.account.model.AccountDTO; import
 * com.spring.portfolio.common.util.json.JsonParsing; import
 * com.spring.portfolio.common.util.json.JsonUnParsing; import
 * com.spring.portfolio.member.model.MemberDTO; import
 * com.spring.portfolio.member.model.MemberVO;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration(locations =
 * "file:src/main/webapp/WEB-INF/spring/junit/junitTest.xml") public class
 * JsonTest {
 * 
 * public JsonTest() { // TODO Auto-generated constructor stub }
 * 
 * @Test public void testParsing() throws Exception { List<Object> list =
 * Arrays.asList(new AccountDTO(), new AccountDTO(), new MemberVO());
 * List<Object> list2 = Arrays.asList( new MemberDTO(0, "tester1", "123",
 * "tester1", 'a', "2014/02/03", 7, "12345", "서울 강서구", "1020번지 12호",
 * "ywyi92@gmail.coom", "010-2571-3495", '1', "123", "tester"), new MemberDTO(1,
 * "tester2", "123", "tester1", 'a', "2014/02/03", 7, "12345", "서울 강서구",
 * "1020번지 12호", "ywyi92@gmail.coom", "010-2571-3495", '1', "123", "tester"),
 * new MemberDTO(2, "tester3", "123", "tester1", 'a', "2014/02/03", 7, "12345",
 * "서울 강서구", "1020번지 12호", "ywyi92@gmail.coom", "010-2571-3495", '1', "123",
 * "tester"), new AccountDTO(), new AccountDTO(), new MemberVO()); String test =
 * null; test = new JsonParsing().parsingList(list); assertNotNull(test); test =
 * new JsonParsing().parsingList(list2); assertNotNull(test); }
 * 
 * @Test public void testUnParsing() throws Exception { Map<String, Map<String,
 * String>> map = null; JsonUnParsing un = new JsonUnParsing(); List<Object>
 * jsonList = Arrays.asList(new AccountDTO(), new MemberVO()); String json = new
 * JsonParsing().parsingList(jsonList); map = un.unParsing(json);
 * assertNotNull(map); List<Boolean> flag1 = new ArrayList<Boolean>();
 * List<Boolean> flag2 = new ArrayList<Boolean>(); List<Boolean> flag3 = null;
 * flagList(jsonList, flag1); assertTrue(flag1.size() == 2); Iterator<String> it
 * = map.keySet().iterator(); int i = 0; while (it.hasNext()) { Class<? extends
 * Object> c = jsonList.get(i).getClass(); flag2.add(true); String key =
 * it.next(); flag3 = fieldEquals(map.get(key), c); key = key.replace("\"", "");
 * assertTrue(key.equals(c.getSimpleName().toLowerCase())); i++; }
 * assertTrue(Arrays.deepEquals(flag1.toArray(), flag2.toArray()));
 * flag3.forEach(flag -> { });
 * 
 * }
 * 
 * private List<Boolean> fieldEquals(Map<String, String> map, Class<? extends
 * Object> c) { Field[] f = getField(c); List<Boolean> list = new
 * ArrayList<Boolean>(); Iterator<String> it = map.keySet().iterator(); int i =
 * 0; while (it.hasNext()) { String key = it.next().replace("\"", ""); String
 * target = f[i].getName(); i++; } return list; }
 * 
 * private Field[] getField(Class<? extends Object> c) { Field[] f =
 * c.getDeclaredFields(); List<Field> list = new ArrayList<Field>(); for (int i
 * = 0; i < f.length; i++) { if (!f[i].getName().equals("serialVersionUID")) {
 * list.add(f[i]); } } return fieldAdd(list); }
 * 
 * private Field[] fieldAdd(List<Field> list) { Field[] f = new
 * Field[list.size()]; for (int i = 0; i < list.size(); i++) { f[i] =
 * list.get(i); } return f; }
 * 
 * private void flagList(List<Object> target, List<Boolean> flag) { for (int i =
 * 0; i < target.size(); i++) { flag.add(true); }
 * 
 * } }
 */