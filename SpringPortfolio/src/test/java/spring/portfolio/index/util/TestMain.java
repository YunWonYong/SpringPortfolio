package spring.portfolio.index.util;

import java.util.Calendar;

import javax.swing.text.AbstractDocument.BranchElement;

public class TestMain {

	public static void main(String[] args) throws Exception {
		Calendar c = Calendar.getInstance();
		System.out.println(String.valueOf(c.getTimeInMillis()).substring(0,7));
		System.out.println(Integer.parseInt((String.valueOf(c.getTimeInMillis()).substring(0,7)))+(60 * 60 * 24));
		int i = Integer.parseInt((String.valueOf(c.getTimeInMillis()).substring(0,7)))+(60 * 60 * 24);
		
		long holdingTime = c.getTimeInMillis() + (86400);
//		for (long i = c.getTimeInMillis() + 86350; i <= holdingTime; i++) {
//			if (holdingTime - i > 0) {
//				System.out.println("Session conection");
//			} else {
//				System.out.println("dataBase del");
//				break;
//			}
//			Thread.sleep(1000);
//		}

	}
}
 