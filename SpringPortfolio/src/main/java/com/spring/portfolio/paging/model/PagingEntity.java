package com.spring.portfolio.paging.model;

import java.util.Map;

import com.spring.portfolio.common.vo.PagingVO;

/**
 * @author user
 *
 */
@SuppressWarnings("unused")
public class PagingEntity {
	private int amount, currentPage, beginNumber, stopNumber, minimum, maximum;
	public PagingEntity() {
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginNumber() {
		return beginNumber;
	}

	public void setBeginNumber(int beginNumber) {
		this.beginNumber = beginNumber;
	}

	public int getStopNumber() {
		return stopNumber;
	}

	public void setStopNumber(int stopNumber) {
		this.stopNumber = stopNumber;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount, PagingVO vo) {
		this.amount = amount;
		execute(vo);
	}

	public void execute(PagingVO vo) {
		this.currentPage = vo.getCurrentPage();
		minimum = currentPage == 1 ? 0 : ((currentPage - 1) * 10) + 1;
		maximum = minimum + (currentPage == 1 ? 10 : 9);
		float setAmount = amount / 10F;
		String[] getStopNumber = String.valueOf(setAmount).split("\\.");
		int setStopNumber = Integer.parseInt(getStopNumber[0]);
		stopNumber = getStopNumber[1].equals("0") ? setStopNumber : setStopNumber + 1;
	}
}
