package member.dto;

public class HyuHakforProf {
	private int stdNo;
	private int start;
	private int period;
	private String reason;
	private String stdName;
	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public HyuHakforProf(int stdNo, int start, int period, String reason, String stdName) {
		this.stdNo = stdNo;
		this.start = start;
		this.period = period;
		this.reason = reason;
		this.stdName = stdName;
	}
	
	
	
	
	
	

}
