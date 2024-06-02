package in.MiniProject1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.MiniProject1.FormBindingClasses.DashboardResponse;
import in.MiniProject1.FormBindingClasses.SearchEnq;
import in.MiniProject1.entity.StudentDetails;

@Service
public interface EnquiryService {
	public boolean addenquiry(StudentDetails c);
	public DashboardResponse showenqiry(Integer cId);
	public List<StudentDetails> getEnquiry(Integer cId,SearchEnq s);
	
}
