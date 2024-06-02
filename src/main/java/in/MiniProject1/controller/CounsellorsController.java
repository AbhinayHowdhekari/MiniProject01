package in.MiniProject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.MiniProject1.FormBindingClasses.DashboardResponse;
import in.MiniProject1.FormBindingClasses.SearchEnq;
import in.MiniProject1.Service.CounsellorService;
import in.MiniProject1.Service.EnquiryService;
import in.MiniProject1.ServiceImp.EnquiryImp;
import in.MiniProject1.entity.CounsellorsDetails;
import in.MiniProject1.entity.StudentDetails;
import in.MiniProject1.repository.CounsellorsRepo;
import in.MiniProject1.repository.StudentRepository;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorsController {

	@Autowired
	private CounsellorService counservice;

	@Autowired
	private CounsellorsRepo repo;

	@Autowired
	private EnquiryImp enquiry;

	@Autowired
	private StudentRepository studentrepo;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("counsoller", new CounsellorsDetails());
		return "loginpage";
	}

	@PostMapping("/userlogin")
	public String loginhandle(@ModelAttribute("counsoller") CounsellorsDetails counsoller, Model model,
			HttpServletRequest req) {
		CounsellorsDetails logincheck = counservice.logincheck(counsoller.getEmail(), counsoller.getPswd());
		
		if (logincheck == null) {
			model.addAttribute("login", "inavlid crediantials");
			return "loginpage";
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("cid", logincheck.getCid());
			Object attribute = session.getAttribute("cid");
			Integer id = (Integer) attribute;
			DashboardResponse response = enquiry.showenqiry(id);
			model.addAttribute("ress", response);

			return "dashboard";
		}

	}

	@GetMapping("/register")
	public String index(Model model) {
		model.addAttribute("counsoller", new CounsellorsDetails());
		return "viewregister";
	}

	@PostMapping("/reg")
	public String handleregistration(@ModelAttribute("counsoller") CounsellorsDetails counsoller, Model model) {
		CounsellorsDetails entity = repo.findByEmail(counsoller.getEmail());
		if (entity != null) {
			model.addAttribute("mesg", "email already exist");
			return "viewregister";
		} else {
			String savecounselleor = counservice.savecounselleor(counsoller);
			model.addAttribute("mesg", savecounselleor);
			return "viewregister";
		}

	}

	@GetMapping("/recoverypage")
	public String getRecovery(Model model) {

		model.addAttribute("counsoller", new CounsellorsDetails());
		return "forgetpage";
	}

	@PostMapping("/recovery")
	public String emailrecovery(@ModelAttribute("counsoller") CounsellorsDetails counsoller, Model model) {

		boolean status = counservice.recoverpswd(counsoller.getEmail());
		if (status) {
			model.addAttribute("msg", "password sent to email");
		} else {
			model.addAttribute("invalid", "invalid email");
		}
		return "forgetpage";
	}

	@GetMapping("/addstudent")
	public String addStudentdata(Model model) {
		model.addAttribute("student", new StudentDetails());
		return "Addstudents";
	}

	@PostMapping("/studentinfo")
	public String studentinformation(Model model, @ModelAttribute("student") StudentDetails student,
			HttpServletRequest req) {

		HttpSession session = req.getSession();
		Object attribute = session.getAttribute("cid");
		Integer id = (Integer) attribute;
		student.setCid(id);
		boolean addenquiry = enquiry.addenquiry(student);
		if (addenquiry) {
			model.addAttribute("stu", "registration successful");
		} else {
			model.addAttribute("error", "registration failed");
		}
		return "Addstudents";
	}

	@GetMapping("/enquries")
	public String viewStudentData(Model model, HttpServletRequest req) {
	    HttpSession httpSession = req.getSession();
	    Object object = httpSession.getAttribute("cid");
	    Integer data = (Integer) object;

	    model.addAttribute("sc", new SearchEnq());

	    List<StudentDetails> list = studentrepo.findByCid(data);
	    model.addAttribute("enq", list);
	    return "ViewEnquiry";
	}

	@PostMapping("/filterenquiry")
	public String filterEnquiry(@ModelAttribute("sc") SearchEnq sc, Model model, HttpServletRequest req) {
	    HttpSession httpSession = req.getSession();
	    Object obj = httpSession.getAttribute("cid");
	    Integer data = (Integer) obj;
	    List<StudentDetails> filterenquiry = enquiry.getEnquiry(data, sc);
	    model.addAttribute("enq", filterenquiry);
	    return "filtertable";
	}

}
