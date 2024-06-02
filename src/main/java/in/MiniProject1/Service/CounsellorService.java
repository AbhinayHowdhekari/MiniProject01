package in.MiniProject1.Service;

import org.springframework.stereotype.Service;

import in.MiniProject1.FormBindingClasses.DashboardResponse;
import in.MiniProject1.entity.CounsellorsDetails;

@Service
public interface CounsellorService {
	public String savecounselleor(CounsellorsDetails c);
	public CounsellorsDetails logincheck(String Email,String Pswd);
	public boolean recoverpswd(String Pswd);
	public DashboardResponse dashboardinfo(Integer Cid);
}
