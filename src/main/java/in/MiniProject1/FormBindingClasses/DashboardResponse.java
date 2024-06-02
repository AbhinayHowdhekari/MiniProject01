package in.MiniProject1.FormBindingClasses;

public class DashboardResponse {
	private Integer TotalEnq;
	private Integer EnrolledEnq;
	private Integer LostEnq;
	public Integer getTotalEnq() {
		return TotalEnq;
	}
	public void setTotalEnq(Integer totalEnq) {
		TotalEnq = totalEnq;
	}
	public Integer getEnrolledEnq() {
		return EnrolledEnq;
	}
	public void setEnrolledEnq(Integer enrolledEnq) {
		EnrolledEnq = enrolledEnq;
	}
	public Integer getLostEnq() {
		return LostEnq;
	}
	public void setLostEnq(Integer lostEnq) {
		LostEnq = lostEnq;
	}
	@Override
	public String toString() {
		return "DashboardResponse [TotalEnq=" + TotalEnq + ", EnrolledEnq=" + EnrolledEnq + ", LostEnq=" + LostEnq
				+ "]";
	}
	
	
}
