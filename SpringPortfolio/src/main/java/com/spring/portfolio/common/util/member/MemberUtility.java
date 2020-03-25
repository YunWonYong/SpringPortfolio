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
		if(dto!=null) { 
			map.put("date",getDate());
		}
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

	public String getLogo(String key) {
		return key.equals("identify") ? "회원 닉네임 및 비밀변호 변경"
				: key.equals("userinfo") ? "회원 정보 수정"
						: key.equals("useraddress") ? "회원 연락처 및 주소 수정" : key.equals("grantupdate") ? "회원 등급 수정" : null;
	}

	public String setUpdateForm(String key, MemberDTO dto) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("identify", "m_password#m_nickname");
		map.put("userinfo", "m_name#m_birth#m_gender");
		map.put("useraddress", "m_phone#m_zipcode#m_address1#m_address2");
		map.put("grantupdate", "m_grant");
		map.put("certification","m_email");
		this.dto = dto;
		return getForm(map.get(key));
	}

	private List<String> getYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return listLoop(new LoopVO(year, 100, 1));
	}

	private List<String> getMonth() {
		return listLoop(new LoopVO(1, 12, 0));
	}
	private List<String> getDate() { 
		String[] birth =  dto.getM_birth().split(" ")[0].split("-");
		int year = parsingInteger(birth[0]);
		int month = parsingInteger(birth[1]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month,0);
		return listLoop(new LoopVO(0,calendar.getActualMaximum(Calendar.DAY_OF_MONTH),0));
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

	private String getForm(String value) {
		StringBuffer input = new StringBuffer();
		String[] elements = value.split("#");
		for (String element : elements) {
			input.append(setElement(element));
		}
		return input.toString();
	}

	private String setElement(String element) {
		StringBuffer input = new StringBuffer();
		switch (element) {
		case "m_password":
			input.append("<div class=''>");
			input.append("<p>기존 비밀번호 확인</p>");
			input.append("<input class='txtb' type='password' id='password_1' />");
			input.append("<span id='password_msg_old' class='msg' >&nbsp;</span>");
			input.append("<p>수정할 비밀번호</p>");
			input.append("<input class='txtb' type='password' name = 'm_password' id='password_2' />");
			input.append("<span id='password_msg_1' class='msg' >&nbsp;</span>");
			input.append("<p>수정할 비밀번호 확인</p>");
			input.append("<input class='txtb' type='password' id='password_3' />");
			input.append("<span id='password_msg_2' class='msg' >&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_nickname":
			input.append("<div class=''>");
			input.append("<p>닉네임</p>");
			input.append("<input class='txtb' type='text' name='m_nickname' value ='");
			input.append(dto.getM_nickname());
			input.append("'/>");
			input.append("<span id='nickname_msg' class='msg' >&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_name":
			input.append("<div class=''>");
			input.append("<p>이름</p>");
			input.append("<input class='txtb' type='text' name='m_name' value ='");
			input.append(dto.getM_name());
			input.append("'/>");
			input.append("<span id='name_msg' class='msg' >&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_birth": 
			input.append("<div class='birth'>");
			input.append("<p>생년월일</p>");
			input.append("<select name='year'>");
			input.append(appendOptionTag("year"));
			input.append("</select>");
			input.append("<span><i class='fa fa-minus' aria-hidden='true'></i></span>");
			input.append("<select name='month'>");
			input.append(appendOptionTag("month"));
			input.append("</select>");
			input.append("<span><i class='fa fa-minus' aria-hidden='true'></i></span>");
			input.append("<select name='date' id='date'>");
			input.append(appendOptionTag("date"));
			input.append("</select>");
			input.append("<span id='brith_msg' class='msg' >&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_gender":
			String man = dto.getM_gender() =='0'?"checked":"";
			String woman = dto.getM_gender() !='0'?"checked":"";
			input.append("<div class='gender'>");
			input.append("<p>성별<p>");
			input.append("<div class='man'>");
			input.append("<label for='man'>남자</label>");
			input.append("<input type='radio' name='genderCheck' id='man' ");
			input.append(man);
			input.append("/></div>");
			input.append("<div class='girl'>");
			input.append("<label for='woman'>여자</label>");
			input.append("<input type='radio' id='woman' ");
			input.append(woman);
			input.append("/></div>");
			input.append("<span id='gender_msg' class='msg'>&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_phone":
			input.append("<div class='box'>");
			input.append("<p>전화번호</p>");
			input.append("<input class='txtb' type='text' name='m_phone' value='");
			input.append(dto.getM_phone());
			input.append("'/>");
			input.append("<span id='phone_msg' class='msg'>&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_zipcode":
			input.append("<div class='box'>");
			input.append("<p>우편번호</p>");
			input.append("<input class='txtb' name='m_zipcode' id='m_zipcode' readonly value='");
			input.append(dto.getM_zipcode());
			input.append("'/>");
			input.append("<button type='button' onclick='daumPostcode()'>우편찾기</button>");
			input.append("</div>");
			break;
		case "m_address1":
			input.append("<div class='box'>");
			input.append("<input class='txtb' name='m_address1' id='m_address1' readonly value='");
			input.append(dto.getM_address1());
			input.append("'/>");
			input.append("</div>");
			break;
		case "m_address2":
			input.append("<div class='box'>");
			input.append("<input class='txtb' name='m_address2' id='m_address2' value='");
			input.append(dto.getM_address2());
			input.append("'/>");
			input.append("<span id='address_msg' class='msg'>&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_email":
			input.append("<div class='box'>");
			input.append("<p>이메일</p>");
			input.append("<input type='text' class='txtb' name='m_email' id='m_email' value='");
			input.append(dto.getM_email());
			input.append("'/>");
			input.append("<button type='button' id='certification'>인증하기</button>");
			input.append("<span id='email_msg' class='msg'>&nbsp;</span>");
			input.append("</div>");
			break;
		case "m_grant":
			break;
		}
		return input.toString();
	}
	
	private String appendOptionTag(String key) {
		StringBuffer option = new StringBuffer();
		Map<String, List<String>> map = getBirth();
		String[] birth = dto.getM_birth().split(" ")[0].split("-");
		for (String value : map.get(key)) {
			option.append("<option value='");
			option.append(value);
			option.append("'");
			if(birth[0].equals(value)||birth[1].equals(value)&&key.equals("month")||birth[2].equals(value)&&key.equals("date")) {
				option.append(" selected");
			} 
			option.append(">");
			option.append(value);
			option.append("</option>"); 
		}
		return option.toString();
	}
}
