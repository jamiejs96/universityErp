package attend.dto;

import java.util.Date;

public class AbsentDTO {
private int stdNo;
private Date date;
private int kind;
public int getStdNo() {
	return stdNo;
}
public void setStdNo(int stdNo) {
	this.stdNo = stdNo;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getKind() {
	return kind;
}
public void setKind(int kind) {
	this.kind = kind;
}
public AbsentDTO(int stdNo, Date date, int kind) {
	this.stdNo = stdNo;
	this.date = date;
	this.kind = kind;
}



}
