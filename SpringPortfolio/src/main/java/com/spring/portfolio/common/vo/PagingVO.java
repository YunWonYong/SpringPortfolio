package com.spring.portfolio.common.vo;

public class PagingVO {
	private int currentPage = 1, beginNumber = 1, stopNumber, amount, minimum, maximum ;

	public PagingVO() {
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		setRowBetween();
	}

	public void setAmount(int amount) {
		this.amount = amount;
		setPageNumber();
	}

	private void setRowBetween() {
		minimum = currentPage == 1 ? 0 : ((currentPage-1) * 10)+1;
		maximum = minimum +(currentPage ==1? 10:9); 
	}
 
	private void setPageNumber() {
		float setAmount = amount / 10F;
		String[] getStopNumber = String.valueOf(setAmount).split("\\.");
		int setStopNumber = Integer.parseInt(getStopNumber[0]);
		stopNumber = getStopNumber[1].equals("0") ? setStopNumber : setStopNumber + 1;
	}
}
