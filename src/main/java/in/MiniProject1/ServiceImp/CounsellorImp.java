package in.MiniProject1.ServiceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.MiniProject1.FormBindingClasses.DashboardResponse;
import in.MiniProject1.Service.CounsellorService;
import in.MiniProject1.emailsender.Emailutils;
import in.MiniProject1.entity.CounsellorsDetails;
import in.MiniProject1.repository.CounsellorsRepo;

@Service
public class CounsellorImp implements CounsellorService {

	@Autowired
	private CounsellorsRepo repo;

	@Autowired
	private JavaMailSender javamail;

	@Override
	public String savecounselleor(CounsellorsDetails c) {
		repo.save(c);
		return "Registration Successful";
	}

	@Override
	public CounsellorsDetails logincheck(String Email, String Pswd) {
		CounsellorsDetails counsellorEntity = repo.findByEmailAndPswd(Email, Pswd);
		if (counsellorEntity != null) {
			return counsellorEntity;
		}
		return null;
	}

	@Override
	public boolean recoverpswd(String email) {
		boolean flag=false;
		CounsellorsDetails byEmail = repo.findByEmail(email);
		if (byEmail != null) {
			Emailutils sender = new Emailutils(javamail);

			String pswd = "Your Password:"+byEmail.getPswd();
			String body = pswd;
			String subject = "Recovery Password";

			boolean status = sender.emailsender(email, body, subject);
			if(status) {
				flag=true;
			}
		}
		return flag;
	}

	@Override
	public DashboardResponse dashboardinfo(Integer Cid) {
		return null;
	}

}
