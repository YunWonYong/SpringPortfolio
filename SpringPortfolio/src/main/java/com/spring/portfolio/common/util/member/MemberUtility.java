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
import com.spring.portfolio.member.model.MemberDTO;

@Component(value = UtilNameSpaces.MEMBER)
public class MemberUtility extends UtilityImpl implements Utility {

	private int start, end;
	private MemberDTO dto;

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

	public String setUpdateForm(String key, MemberDTO dto) {
		System.out.println("param dto:" + dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("identify", "m_password#m_nickname");
		map.put("userinfo", "m_name#m_birth#m_age#m_gender");
		map.put("useraddress", "m_phone#m_email#m_zipcode#m_address1#m_address2");
		map.put("grantupdate", "m_grant");
		this.dto = dto;
		return getForm(map.get(key));
	}

	private String getForm(String key) {
		StringBuffer input = new StringBuffer();

		String[] elements = key.split("\\#");
		for (String element : elements) {
			input.append(setElement(element));
		}
		return input.toString();
	}

	private String setElement(String element) {
		StringBuffer input = new StringBuffer();
		switch (element) {
		case "m_password":
			input.append("<div class='pw'>");
			input.append("<p>기존 비밀번호 확인</p>");
			input.append("<input class='txtb' type='password' id='password_1' />");
			input.append("<p>수정할 비밀번호</p>");
			input.append("<input class='txtb' type='password' name = 'm_password' id='password_2' />");
			input.append("<p>수정할 비밀번호 확인</p>");
			input.append("<input class='txtb' type='password' id='password_3' />");
			input.append("</div>");
			break;
		case "m_nickname":
			input.append("<div class='ni'>");
			break; 
		case "m_name":
			break;
		case "m_birth":
			break;
		case "m_age":
			break;
		case "m_gender":
			break;
		case "m_phone":
			break;
		case "m_zipcode":
			break;
		case "m_address1":
			break;
		case "m_address2":
			break;
		case "m_email":
			break;
		case "m_grant":
			break;
		}
		return input.toString();
	}

	public String getLogo(String key) {
		return key.equals("identify") ? "회원 닉네임 및 비밀변호 변경"
				: key.equals("userinfo") ? "회원 정보 수정"
						: key.equals("useraddress") ? "회원 연락처 및 주소 수정" : key.equals("grantupdate") ? "회원 등급 수정" : null;
	}

}
