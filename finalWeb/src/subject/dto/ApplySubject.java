package subject.dto;

public class ApplySubject {
private int stdNo;
private int[] subNo;
public int getStdNo() {
	return stdNo;
}
public void setStdNo(int stdNo) {
	this.stdNo = stdNo;
}
public int[] getSubNo() {
	return subNo;
}
public void setSubNo(int[] subNo) {
	this.subNo = subNo;
}
public ApplySubject(int stdNo, int[] subNo) {
	this.stdNo = stdNo;
	this.subNo = subNo;
}

}
