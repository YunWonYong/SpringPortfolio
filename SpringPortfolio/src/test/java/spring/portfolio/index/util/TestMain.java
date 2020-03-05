package spring.portfolio.index.util;

public class TestMain {

	public static void main(String[] args) throws Exception {
		Object value  = null;
		value = (Integer)1;
		System.out.println(value instanceof Integer);
		value = (String)"text";
		System.out.println(value instanceof String);
		value = "test";
		System.out.println(value instanceof String);
		value = 1;
		System.out.println(value.getClass().getSimpleName());
	}
}
