package com.spring.portfolio.common.util.member;

import java.util.Calendar;
import java.util.List;

import com.spring.portfolio.common.UtilityCommad;
import com.spring.portfolio.common.vo.LoopVO;

public class MemberUtil implements UtilityCommad {

	private int start, end;

	public MemberUtil() {
		// TODO Auto-generated constructor stub
	}

	public String getGender(char gender) {
		return gender == '1' ? "여자" : "남자";
	}

	public int getAge(final String year) {
		return (Calendar.getInstance().get(Calendar.YEAR) - parsingInteger(year)) + 1;
	}

	public List<String> getYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return listLoop(new LoopVO(year, 100, 1));
	}

	public List<String> getMonth() {
		return listLoop(new LoopVO(1, 12, 0));
	}

	private List<String> listLoop(final LoopVO vo) {

		switch (vo.getOperator()) {
		case 0:
			vo.setReturnList(monthLoop(vo));
			break;
		case 1:
			vo.setReturnList(yearLoop(vo));
			break;
		}

		return vo.getReturnList();
	}

	private List<String> yearLoop(final LoopVO vo) {
		start = vo.getStart();
		end = vo.getEnd();
		while (end > 0) {
			vo.addArrayList(parsingString(start));
			start--;
			end--;
		}
		return vo.getReturnList();
	}

	private List<String> monthLoop(final LoopVO vo) {
		start = vo.getStart();
		end = vo.getEnd();
		while (start <= end) {
			vo.addArrayList(monthParSing(start));
			start++;
		}
		return vo.getReturnList();
	}

	private int parsingInteger(final String value) {
		return Integer.parseInt(value);
	}

	private String parsingString(final Integer value) {
		return String.valueOf(value);
	}

	private String monthParSing(final int value) {
		String pasingValue = parsingString(value);
		return pasingValue.length() == 1 ? "0" + pasingValue : pasingValue;
	}
}
