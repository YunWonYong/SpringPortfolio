package spring.portfolio.index.util;

public class TestMain {

	public static void main(String[] args) throws Exception {
		StringBuffer form = new StringBuffer();
		form.append("<form action='/member/update' method='post'>");
		
		form.append("<\\form>");
		String s = "<input type='text' name='m_phone' value='010-2222-2222' \\>";
		
		System.out.println(s);
		System.out.println(form.toString());
	}
}
