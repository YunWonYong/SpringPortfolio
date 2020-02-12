package spring.portfolio.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.portfolio.Member;
@Repository
public class MemberDAO implements Member {
	@Autowired
	private SqlSessionTemplate sql;
		
	@Override
	public boolean crate(Object dto) {
		boolean flag=false;
		int cnt=sql.insert("member.create",dto);
		if(cnt>0){
			flag=true;
		}
		return flag; 
	}

	@Override
	public boolean delete(Object pk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object dto) {
		boolean flag=false;
		int cnt=sql.update("member.update",dto);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Object read(Object pk) {
		return sql.selectOne("member.read",pk);
	}

	@Override
	public List<Object> list(Map map) {
		return sql.selectList("member.list",map);
	}

	@Override
	public int id_Check(String id) {
		return sql.selectOne("member.id_Check", id);
	}

	@Override
	public int nickname_Check(String nickname) {
		return sql.selectOne("member.nickname_Check",nickname);
	}

	@Override
	public int login(Map map) {
		return sql.selectOne("member.login",map);
	}

	@Override
	public String getGrade(String id) {
		return sql.selectOne("member.getGrade",id);
	}

	@Override
	public String getPhoto(String id) {
		return sql.selectOne("member.getPhoto",id);
	}

	@Override
	public int passwdCheck(Map map) {
		return sql.selectOne("member.passwdCheck",map);
	}

	@Override
	public boolean fileupdate(Map map) {
		boolean flag=false;
		int cnt=sql.update("member.fileupdate",map);
		if(cnt>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public int total(Map map) {
		return sql.selectOne("member.total", map);
	}

}
