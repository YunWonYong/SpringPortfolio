package spring.model.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BestDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	public int ntotal(String col, String word){
//		
//		Map map = new HashMap();
//		map.put("col", col);
//		map.put("word", word);
//		
//		
//		return sqlSession.selectOne("likebest.total",map);
//	}
	

	
	public List<BestDTO> llist(){
		
		return sqlSession.selectList("likebest.llist",6);
		
	}
	
	public boolean create(Map  map){
		boolean flag = false;
		int cnt = sqlSession.insert("likebest.create", map);
		if(cnt > 0) flag = true;
		return flag;
	}
	
	
	
//		public boolean ncreate(LikebestDTO dto){
//			boolean flag = false;
//			int cnt = sqlSession.insert("notice.create", dto);
//			if(cnt>0)flag=true;
//			return flag;
//		}
}
