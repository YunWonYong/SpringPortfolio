package spring.portfolio.index.util;

import java.util.List;

import com.spring.portfolio.common.util.member.MemberUtil;

public class TestMain {

	public static void main(String[] args) {
		MemberUtil util = new MemberUtil();
		List<String> years = util.getYear();
		for(String year : years) {
			System.out.println(year+"년");
		}
		System.out.println("years Size = "+years.size());
		List<String> months = util.getMonth();
		for(String month : months) {
			System.out.println(month+"달");
		}
		System.out.println("months Size = "+months.size()); 
	
	
	}
}
