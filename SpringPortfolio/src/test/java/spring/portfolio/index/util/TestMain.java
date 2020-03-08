package spring.portfolio.index.util;


public class TestMain {

	public static void main(String[] args) throws Exception {
		int amount = 0;
		float f = amount/10F;
		String[] test = String.valueOf(f).split("\\.");
		int stopNumber = test[1].equals("0")? Integer.parseInt(test[0]) :Integer.parseInt(test[0])+1;
		System.out.println("stopNumber:"+(stopNumber));
	}
}
