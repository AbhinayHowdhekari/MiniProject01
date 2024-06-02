package in.MiniProject1.ServiceImp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.MiniProject1.FormBindingClasses.DashboardResponse;
import in.MiniProject1.FormBindingClasses.SearchEnq;
import in.MiniProject1.Service.EnquiryService;
import in.MiniProject1.entity.StudentDetails;
import in.MiniProject1.repository.StudentRepository;

@Service
public class EnquiryImp implements EnquiryService {
	@Autowired
	private StudentRepository repo;

	@Override
	public boolean addenquiry(StudentDetails c) {
		repo.save(c);
		return true;
	}

	@Override
	public DashboardResponse showenqiry(Integer cid) {
		List<StudentDetails> studentDetails = repo.findByCid(cid);
		DashboardResponse res=new DashboardResponse();
		int totalStudents = studentDetails.size();

		List<StudentDetails> list = studentDetails.stream().filter(li -> li.getStatus().equals("enrolled"))
				.collect(Collectors.toList());
		int enrolledSize = list.size();
		
		int lost=totalStudents-enrolledSize;
		res.setEnrolledEnq(enrolledSize);
		res.setLostEnq(lost);
		res.setTotalEnq(totalStudents);
		
		return res;
	}

	@Override
	public List<StudentDetails> getEnquiry(Integer cId,SearchEnq s) {
		StudentDetails enq=new StudentDetails();
		enq.setCid(cId);
		if(s.getCoursename()!=null && !s.getCoursename().equals("")){
			enq.setCourse(s.getCoursename());
		}
		if(s.getMode()!=null && !s.getMode().equals("")) {
			enq.setMode(s.getMode());
		}
		if(s.getEnquiryStatus()!=null && !s.getEnquiryStatus().equals("")) {
			enq.setStatus(s.getEnquiryStatus());
		}
		Example<StudentDetails> emp = Example.of(enq);
		List<StudentDetails> list = repo.findAll(emp);
		
		return list;
	}

}
