package spring.portfolio.index.util;

import java.util.List;
import java.util.Map;

import com.spring.portfolio.common.util.member.MemberUtility;

public class TestMain {

	public static void main(String[] args) {
		Map<String,List<String>> map = new MemberUtility().getBirth();
		map.keySet().iterator().forEachRemaining(msg->{
			System.out.println(map.get(msg));
		});
	
	}
}
