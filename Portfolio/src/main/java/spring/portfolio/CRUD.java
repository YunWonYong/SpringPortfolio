package spring.portfolio;

import java.util.List;
import java.util.Map;
/**
*�ڵ���¥:2017��05��16��
*������:������
*�ڵ�����:���� ���Ǵ� �޼��带 ��ӹ޾� ����ϱ� ���ؼ�
* */
public interface CRUD {
	public boolean crate(Object dto);
	public boolean delete(Object pk);
	public boolean update(Object dto);
	public Object read(Object pk);
	public List<Object> list(Map map);
}
