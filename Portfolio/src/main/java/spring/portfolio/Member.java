package spring.portfolio;

import java.util.Map;

import spring.portfolio.model.MemberDTO;

public interface Member extends CRUD {
	public int id_Check(String id);
	public int nickname_Check(String nickname);
	public int login(Map map);
	public String getGrade(String id);
	public String getPhoto(String id);
	public int passwdCheck(Map map);
	public boolean fileupdate(Map map);
	public int total(Map map);
}
 