package score.dto;

public class Score {
private int subNo;
private String subName;
private String  stdScore;
private int subCredit;
private String profName;



public Score(int subNo, String subName, String stdScore, int subCredit,String profName) {
	this.subNo = subNo;
	this.subName = subName;
	this.stdScore = stdScore;
	this.subCredit = subCredit;
	this.profName = profName;
}
public int getSubNo() {
	return subNo;
}
public void setSubNo(int subNo) {
	this.subNo = subNo;
}
public String getSubName() {
	return subName;
}
public void setSubName(String subName) {
	this.subName = subName;
}
public String getStdScore() {
	return stdScore;
}
public void setStdScore(String stdScore) {
	this.stdScore = stdScore;
}
public int getSubCredit() {
	return subCredit;
}
public void setSubCredit(int subCredit) {
	this.subCredit = subCredit;
}
public String getProfName() {
	return profName;
}
public void setProfName(String profName) {
	this.profName = profName;
}




}
