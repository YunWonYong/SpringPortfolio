package spring.file.utility;

public class MemberELFunction {

	public static String getGrade(String grade){
		String gradename=null; 
		System.out.println(grade);
		if(grade.equals("A") ){ 
			gradename="�Ϲ�ȸ��";
		}else if(grade.equals("B")){
			gradename="���ȸ��";
		}else if(grade.equals("G")){
			gradename="���";
		}
			return gradename;
	}
}
 