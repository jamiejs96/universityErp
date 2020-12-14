package jspstudy.dbcp;

public class PoolDTO {
	int subNo;
	String subName;
	
	public PoolDTO() {
		
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
	public PoolDTO(int subNo, String subName) {
		this.subNo = subNo;
		this.subName = subName;
	}
	
	
}
