package spring.file.utility;

public class MemberELFunction {

	public static String getGrade(String grade){
		String gradename=null; 
		System.out.println(grade);
		if(grade.equals("A") ){ 
			gradename="일반회원";
		}else if(grade.equals("B")){
			gradename="우수회원";
		}else if(grade.equals("G")){
			gradename="운영자";
		}
			return gradename;
	}
}
 