package com.spring.portfolio.common.util.member;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spring.portfolio.common.util.UtilityCommand;
import com.spring.portfolio.common.util.UtilityImpl;
import com.spring.portfolio.common.vo.LoopVO;

@Component(value = "memberUtil")
public class MemberUtility extends UtilityImpl implements UtilityCommand {

	private int start, end;

	public MemberUtility() {
	}

	public String getGrant(char grant) {
		String returnValue = null;
		switch (grant) {
		case 'z':
			returnValue = "일반회원";
			break;
		case 'a':
			returnValue = "운영자";
			break;
		default:
			break;
		}
		return returnValue;
	}

	public char setGender(String gender) {
		return gender != null ? '0' : '1';
	}

	public String getGender(char gender) {
		return gender == '1' ? "여자" : "남자";
	}

	public String searchContentParse(String target, String content) {
		String returnValue = content;
		switch (target) {
		case "m_gender":
			char gender = setGender(!content.contains("남") ? null : content);
			returnValue = String.valueOf(gender);
			break;
		case "m_grant":
			returnValue = setGrant(content);
			break;
		}
		return returnValue;
	}

	public int getAge(final String year) {
		return (Calendar.getInstance().get(Calendar.YEAR) - parsingInteger(year)) + 1;
	}

	public Map<String, List<String>> getBirth() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("year", getYear());
		map.put("month", getMonth());
		return map;
	}

	public String ajaxDuplicateResult(Map<String, String> map) {
		String selecter = (String) map.get("selecter");
		String flagmsg = (String) map.get("flag");
		StringBuffer msgSB = new StringBuffer();
		msgSB.append(selecter);
		msgSB.append(",");
		msgSB.append(flagmsg);
		return msgSB.toString();
	}

	private List<String> getYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return listLoop(new LoopVO(year, 100, 1));
	}

	private List<String> getMonth() {
		return listLoop(new LoopVO(0, 12, 0));
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

	private String setGrant(String content) {
		switch (content) {
		case "일반회원":
			content = "z";
			break;
		case "운영자":
			content = "a";
			break;
		}
		return content;
	}
}
