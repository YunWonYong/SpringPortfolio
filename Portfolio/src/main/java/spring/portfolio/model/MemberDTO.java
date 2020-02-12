package spring.portfolio.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String year;
	private String month;
	private String day;
	private String nickname;
	private String email1;
	private String at="@";
	private String email2;
	private String zipnumber1;
	private String zipnumber2;
	private String zipnumber3;
	private String phone1;
	private String phone2;
	private String phone3;
	private String zipcode;
	private String address1;
	private String address2;
	private MultipartFile fileMF;
	private String photo;
	private String cdate;
	private String hobby;
	private String grade="A";
	private String sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getZipnumber1() {
		return zipnumber1;
	}
	public void setZipnumber1(String zipnumber1) {
		this.zipnumber1 = zipnumber1;
	}
	public String getZipnumber2() {
		return zipnumber2;
	}
	public void setZipnumber2(String zipnumber2) {
		this.zipnumber2 = zipnumber2;
	}
	public String getZipnumber3() {
		return zipnumber3;
	}
	public void setZipnumber3(String zipnumber3) {
		this.zipnumber3 = zipnumber3;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public MultipartFile getFileMF() {
		return fileMF;
	}
	public void setFileMF(MultipartFile fileMF) {
		this.fileMF = fileMF;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
