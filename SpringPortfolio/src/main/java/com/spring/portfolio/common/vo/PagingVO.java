package com.spring.portfolio.common.vo;

public class PagingVO {
	private String primaryKey, tableName;
	private int currentPage;

	public PagingVO() {
	}

	public PagingVO(String primaryKey, String tableName, int currentPage) {
		this.primaryKey = primaryKey;
		this.tableName = tableName;
		this.currentPage = currentPage;
	}
//	private int currentPage = 1, beginNumber = 1, stopNumber, amount, minimum, maximum;
//
//	public PagingVO() {
//	}
//
//	public void setCurrentPage(int currentPage, SearchVO vo) {
//		this.currentPage = currentPage;
//		setRowBetween();
//	}
//
//	public void setAmount(int amount) {
//		this.amount = amount;
//		setPageNumber();
//	}
//
//	private void setRowBetween() {
//		minimum = currentPage == 1 ? 0 : ((currentPage - 1) * 10) + 1;
//		maximum = minimum + (currentPage == 1 ? 10 : 9);
//	}
//
//	private void setPageNumber() {
//		float setAmount = amount / 10F;
//		String[] getStopNumber = String.valueOf(setAmount).split("\\.");
//		int setStopNumber = Integer.parseInt(getStopNumber[0]);
//		stopNumber = getStopNumber[1].equals("0") ? setStopNumber : setStopNumber + 1;
//	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PagingVO [primaryKey=" + primaryKey + ", tableName=" + tableName + ", curruntNumber=" + currentPage
				+ "]";
	}
}
