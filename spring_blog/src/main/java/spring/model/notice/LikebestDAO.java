package spring.model.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LikebestDAO {
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
	
public List<LikebestDTO> list(){
		
		return sqlSession.selectList("likebest.list");
		
	}
	
	
	
//		public boolean ncreate(LikebestDTO dto){
//			boolean flag = false;
//			int cnt = sqlSession.insert("notice.create", dto);
//			if(cnt>0)flag=true;
//			return flag;
//		}
}
