package attend.dto;

import java.sql.Timestamp;

public class AttendDTO {
private String profName;
private int profNo;
private String subName;
private int subNo;
private int stdNo;
private int attWeek1;
private int attWeek2;
private int attWeek3;
private int attWeek4;
private int attWeek5;
private int attWeek6;
private int attWeek7;
private int attWeek8;
private int attWeek9;
private int attWeek10;
private int attWeek11;
private int attWeek12;
private int attWeek13;
private int attWeek14;
private int attWeek15;
private Timestamp date;

private String stdName;



public String getStdName() {
	return stdName;
}
public void setStdName(String stdName) {
	this.stdName = stdName;
}
public String getProfName() {
	return profName;
}
public void setProfName(String profName) {
	this.profName = profName;
}
public int getProfNo() {
	return profNo;
}
public void setProfNo(int profNo) {
	this.profNo = profNo;
}
public String getSubName() {
	return subName;
}
public void setSubName(String subName) {
	this.subName = subName;
}
public int getSubNo() {
	return subNo;
}
public void setSubNo(int subNo) {
	this.subNo = subNo;
}
public int getStdNo() {
	return stdNo;
}
public void setStdNo(int stdNo) {
	this.stdNo = stdNo;
}
public int getAttWeek1() {
	return attWeek1;
}
public void setAttWeek1(int attWeek1) {
	this.attWeek1 = attWeek1;
}
public int getAttWeek2() {
	return attWeek2;
}
public void setAttWeek2(int attWeek2) {
	this.attWeek2 = attWeek2;
}
public int getAttWeek3() {
	return attWeek3;
}
public void setAttWeek3(int attWeek3) {
	this.attWeek3 = attWeek3;
}
public int getAttWeek4() {
	return attWeek4;
}
public void setAttWeek4(int attWeek4) {
	this.attWeek4 = attWeek4;
}
public int getAttWeek5() {
	return attWeek5;
}
public void setAttWeek5(int attWeek5) {
	this.attWeek5 = attWeek5;
}
public int getAttWeek6() {
	return attWeek6;
}
public void setAttWeek6(int attWeek6) {
	this.attWeek6 = attWeek6;
}
public int getAttWeek7() {
	return attWeek7;
}
public void setAttWeek7(int attWeek7) {
	this.attWeek7 = attWeek7;
}
public int getAttWeek8() {
	return attWeek8;
}
public void setAttWeek8(int attWeek8) {
	this.attWeek8 = attWeek8;
}
public int getAttWeek9() {
	return attWeek9;
}
public void setAttWeek9(int attWeek9) {
	this.attWeek9 = attWeek9;
}
public int getAttWeek10() {
	return attWeek10;
}
public void setAttWeek10(int attWeek10) {
	this.attWeek10 = attWeek10;
}
public int getAttWeek11() {
	return attWeek11;
}
public void setAttWeek11(int attWeek11) {
	this.attWeek11 = attWeek11;
}
public int getAttWeek12() {
	return attWeek12;
}
public void setAttWeek12(int attWeek12) {
	this.attWeek12 = attWeek12;
}
public int getAttWeek13() {
	return attWeek13;
}
public void setAttWeek13(int attWeek13) {
	this.attWeek13 = attWeek13;
}
public int getAttWeek14() {
	return attWeek14;
}
public void setAttWeek14(int attWeek14) {
	this.attWeek14 = attWeek14;
}
public int getAttWeek15() {
	return attWeek15;
}
public void setAttWeek15(int attWeek15) {
	this.attWeek15 = attWeek15;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
public AttendDTO(String profName, int profNo, String subName, int subNo, int stdNo, int attWeek1, int attWeek2,
		int attWeek3, int attWeek4, int attWeek5, int attWeek6, int attWeek7, int attWeek8, int attWeek9, int attWeek10,
		int attWeek11, int attWeek12, int attWeek13, int attWeek14, int attWeek15, Timestamp date) {
	this.profName = profName;
	this.profNo = profNo;
	this.subName = subName;
	this.subNo = subNo;
	this.stdNo = stdNo;
	this.attWeek1 = attWeek1;
	this.attWeek2 = attWeek2;
	this.attWeek3 = attWeek3;
	this.attWeek4 = attWeek4;
	this.attWeek5 = attWeek5;
	this.attWeek6 = attWeek6;
	this.attWeek7 = attWeek7;
	this.attWeek8 = attWeek8;
	this.attWeek9 = attWeek9;
	this.attWeek10 = attWeek10;
	this.attWeek11 = attWeek11;
	this.attWeek12 = attWeek12;
	this.attWeek13 = attWeek13;
	this.attWeek14 = attWeek14;
	this.attWeek15 = attWeek15;
	this.date = date;
}

public AttendDTO(int subNo, String subName) {
	   this.subNo = subNo;
	   this.subName = subName;
	}

}
