package member.dto;


public class Member {
	
private int no;
private String pw;
private String name;
private String birth;
private String major;
private String email;
private String gender;
private int job;


public Member() {}

public Member(int no, String pw, String name, String birth, String major, String email, String gender, int job) {
	this.no = no;
	this.pw = pw;
	this.name = name;
	this.birth = birth;
	this.major = major;
	this.email = email;
	this.gender = gender;
	this.job = job;
}

public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getJob() {
	return job;
}
public void setJob(int job) {
	this.job = job;
}

}
