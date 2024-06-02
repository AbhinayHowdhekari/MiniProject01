package in.MiniProject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.MiniProject1.entity.CounsellorsDetails;
import java.util.List;


public interface CounsellorsRepo extends JpaRepository<CounsellorsDetails, Integer> {
	
	
  public CounsellorsDetails findByEmailAndPswd(String email, String pswd);
  public CounsellorsDetails findByEmail(String email);
}
