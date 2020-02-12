package spring.portfolio;

import java.util.List;
import java.util.Map;
/**
*코딩날짜:2017년05월16일
*개발자:윤원용
*코딩목적:자주 사용되는 메서드를 상속받아 사용하기 위해서
* */
public interface CRUD {
	public boolean crate(Object dto);
	public boolean delete(Object pk);
	public boolean update(Object dto);
	public Object read(Object pk);
	public List<Object> list(Map map);
}
