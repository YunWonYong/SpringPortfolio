package com.spring.portfolio.paging.model;

import java.util.Map;

import com.spring.portfolio.common.vo.PagingVO;

/**
 * @author user
 *
 */
@SuppressWarnings("unused")
public class PagingEntity {
	private int amount, currentPage, beginNumber, totalPage, stopNumber, minimum, maximum;

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
		int ten = 10;
		this.currentPage = vo.getCurrentPage();
		minimum = (currentPage == 1) ? 0 : ((currentPage - 1) * ten) + 1;
		maximum = minimum + (currentPage == 1 ? ten : 9); 
		float setAmount = amount / 10F;
		String[] gettotal = String.valueOf(setAmount).split("\\.");
		int settotal = Integer.parseInt(gettotal[0]);
		totalPage = gettotal[1].equals("0") ? settotal : settotal + 1;
		beginNumber = (Integer.parseInt(String.valueOf(currentPage / 10f).split("\\.")[1]) == 0)
				? (((currentPage - ten) / ten) * ten)
				: ((currentPage / ten) * ten);
		beginNumber++;
		stopNumber = beginNumber + 9;
		stopNumber = stopNumber > totalPage ? totalPage : stopNumber;
	}
}
