package com.spring.portfolio.common.util.member;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.Utility;
import com.spring.portfolio.common.util.UtilityImpl;
import com.spring.portfolio.common.vo.LoopVO;

@Component(value = UtilNameSpaces.MEMBER)
public class MemberUtility extends UtilityImpl implements Utility {

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

	public String setUpdateForm(String key) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("identify", "m_password#m_nickname");
		map.put("userinfo", "m_name#m_birth#m_age#m_gender");
		map.put("useraddress", "m_phone#m_email#m_zipcode#m_address1#m_address2");
		map.put("grantupdate", "m_grant");
		return setInput(map.get(key));
	}

	private String setInput(String key) {
		StringBuffer input = new StringBuffer();

		String[] elements = key.split("\\#");
		for (String element : elements) {
			input.append("<p class='test'>");
			input.append(getTarget(element));
			input.append("</p>");
			input.append("<input type='");
			input.append(element.equals("m_gender") ? "radio" : element.equals("m_password") ? "password" : "text");
			input.append("'/>");
		}
		return input.toString();
	}

	private String getTarget(String element) {
		String title = null;
		switch (element) {
		case "m_password":
			title = "비밀번호";
			break;
		case "m_nickname":
			title = "닉네임";
			break;
		case "m_name":
			title = "이름";
			break;
		case "m_birth":
			title = "생년월일";
			break;
		case "m_age":
			title = "나이";
			break;
		case "m_gender":
			title = "성별";
			break;
		case "m_phone":
			title = "전화번호";
			break;
		case "m_zipcode":
			title = "우편번호";
			break;
		case "m_address1":
			title = "주소";
			break;
		case "m_address2":
			title = "상세주소";
			break;
		case "m_email":
			title = "이메일";
			break;
		case "m_grant":
			title = "등급";
			break;
		}
		return title;
	}

	public String getLogo(String key) {
		return key.equals("identify") ? "회원 닉네임 및 비밀변호 변경"
				: key.equals("userinfo") ? "회원 정보 수정"
						: key.equals("useraddress") ? "회원 연락처 및 주소 수정" 
								: key.equals("grantupdate") ? "회원 등급 수정" 
										: null;
	}

}
