package member.dto;

public class StudentAdd {
private int stdNo;
private int stdGrade;
private int stdStatus;
private int stdTotalCredit;



public int getStdNo() {
	return stdNo;
}



public void setStdNo(int stdNo) {
	this.stdNo = stdNo;
}



public int getStdGrade() {
	return stdGrade;
}



public void setStdGrade(int stdGrade) {
	this.stdGrade = stdGrade;
}



public int getStdStatus() {
	return stdStatus;
}



public void setStdStatus(int stdStatus) {
	this.stdStatus = stdStatus;
}



public int getStdTotalCredit() {
	return stdTotalCredit;
}



public void setStdTotalCredit(int stdTotalCredit) {
	this.stdTotalCredit = stdTotalCredit;
}



public StudentAdd(int stdNo, int stdGrade, int stdStatus, int stdTotalCredit) {
	super();
	this.stdNo = stdNo;
	this.stdGrade = stdGrade;
	this.stdStatus = stdStatus;
	this.stdTotalCredit = stdTotalCredit;
}




}
