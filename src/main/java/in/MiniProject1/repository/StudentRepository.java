package in.MiniProject1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.MiniProject1.entity.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {
	public List<StudentDetails> findByCid(Integer cid);
	}
	
