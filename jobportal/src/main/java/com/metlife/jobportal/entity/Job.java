package com.metlife.jobportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "job_code")
	private String jobCode;
	@Column(name = "job_name")
	private String jobName;
	@Column(name = "job_location")
	private String jobLocation;
	private long salary;
	@Column(name = "added_by")
	private String addedBy;
	@Column(name = "added_date")
	private String addedDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_date")
	private String updatedDate;

//	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getJobCode() {
//		return jobCode;
//	}
//
//	public void setJobCode(String jobCode) {
//		this.jobCode = jobCode;
//	}
//
//	public String getJobName() {
//		return jobName;
//	}
//
//	public void setJobName(String jobName) {
//		this.jobName = jobName;
//	}
//
//	public String getJobLocation() {
//		return jobLocation;
//	}
//
//	public void setJobLocation(String jobLocation) {
//		this.jobLocation = jobLocation;
//	}
//
//	public long getSalary() {
//		return salary;
//	}
//
//	public void setSalary(long salary) {
//		this.salary = salary;
//	}
//
//	public String getAddedBy() {
//		return addedBy;
//	}
//
//	public void setAddedBy(String addedBy) {
//		this.addedBy = addedBy;
//	}
//
//	public String getAddedDate() {
//		return addedDate;
//	}
//
//	public void setAddedDate(String addedDate) {
//		this.addedDate = addedDate;
//	}
//
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}
//
//	public String getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(String updatedDate) {
//		this.updatedDate = updatedDate;
//	}

	public Job() {

	}

	public Job(String jobCode, String jobName, String jobLocation, long salary, String addedDate, String addedBy,
			String updatedDate, String updatedBy) {
		super();
		this.jobCode = jobCode;
		this.jobName = jobName;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobCode=" + jobCode + ", jobName=" + jobName + ", jobLocation=" + jobLocation
				+ ", salary=" + salary + ", addedBy=" + addedBy + ", addedDate=" + addedDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
