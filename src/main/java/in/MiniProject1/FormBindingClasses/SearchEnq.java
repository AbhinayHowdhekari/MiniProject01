package in.MiniProject1.FormBindingClasses;

public class SearchEnq {
	private String Coursename;
	private String EnquiryStatus;
	private String mode;
	public String getCoursename() {
		return Coursename;
	}
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}
	public String getEnquiryStatus() {
		return EnquiryStatus;
	}
	public void setEnquiryStatus(String enquiryStatus) {
		EnquiryStatus = enquiryStatus;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "SearchEnq [Coursename=" + Coursename + ", EnquiryStatus=" + EnquiryStatus + ", mode=" + mode + "]";
	}
	
	
}
