package in.MiniProject1.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_info")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Enq_id;
	private String name;
	private Long mobileNo;
	private String mode;
	private String course;
	private String status;
	@CreationTimestamp
	@Column(name = "createdDate",updatable = false)
	private LocalDate createdDate;
	private Integer cid;
	public Integer getEnq_id() {
		return Enq_id;
	}
	public void setEnq_id(Integer enq_id) {
		Enq_id = enq_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "StudentDetails [Enq_id=" + Enq_id + ", name=" + name + ", mobileNo=" + mobileNo + ", mode=" + mode
				+ ", course=" + course + ", status=" + status + ", createdDate=" + createdDate + ", cid=" + cid + "]";
	}
	
}
