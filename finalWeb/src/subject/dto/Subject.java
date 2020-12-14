package subject.dto;

public class Subject {
	private int subNo;
	private String subName;
	private String profName; //실제로는 교수번호지만 교수명으로
	private int subTime;
	private String subDay;
	private int subCredit;
	private int subCapacity;
	
	private int stdNo;

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	
	public Subject(int subNo) {
		this.subNo = subNo;
	}

	public Subject(int subNo, String subName, String profName, int subTime, String subDay, int subCredit,
			int subCapacity) {
		this.subNo = subNo;
		this.subName = subName;
		this.profName = profName;
		this.subTime = subTime;
		this.subDay = subDay;
		this.subCredit = subCredit;
		this.subCapacity = subCapacity;
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

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName){
		this.profName = profName;
	}

	public int getSubTime() {
		return subTime;
	}

	public void setSubTime(int subTime) {
		this.subTime = subTime;
	}

	public String getSubDay() {
		return subDay;
	}

	public void setSubDay(String subDay) {
		this.subDay = subDay;
	}

	public int getSubCredit() {
		return subCredit;
	}

	public void setSubCredit(int subCredit) {
		this.subCredit = subCredit;
	}

	public int getSubCapacity() {
		return subCapacity;
	}

	public void setSubCapacity(int subCapacity) {
		this.subCapacity = subCapacity;
	}

	@Override
	public String toString() {
		return "Subject [subNo=" + subNo + ", subName=" + subName + ", profName=" + profName + ", subTime=" + subTime
				+ ", subDay=" + subDay + ", subCredit=" + subCredit + ", subCapacity=" + subCapacity + "]";
	}
	
	
	
}
