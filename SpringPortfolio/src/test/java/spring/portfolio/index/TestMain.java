package spring.portfolio.index;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.spring.portfolio.common.util.json.JsonParsing;
import com.spring.portfolio.member.model.MemberDTO;

public class TestMain {

	public static void main(String[] args) throws Exception {
		MemberDTO dto = new MemberDTO(0, "tester","123", "tester1", 'a',"2014/02/03",7, "12345","서울 강서구","1020번지 12호", "ywyi92@gmail.coom","010-2571-3495", '0',"123","tester");
		JsonParsing json = new JsonParsing(dto);
		System.out.println(json.parsing());
	} 

}
