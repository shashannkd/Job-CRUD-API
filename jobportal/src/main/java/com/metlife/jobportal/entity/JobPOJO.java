package com.metlife.jobportal.entity;

import lombok.Data;

@Data
public class JobPOJO {

	private String jobCode;
	private String jobName;
	private String jobLocation;
	private long salary;

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "JobPOJO [jobCode=" + jobCode + ", jobName=" + jobName + ", jobLocation=" + jobLocation + ", salary="
				+ salary + "]";
	}

}
