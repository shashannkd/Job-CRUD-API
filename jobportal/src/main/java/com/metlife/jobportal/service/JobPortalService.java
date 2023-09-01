package com.metlife.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metlife.jobportal.entity.Job;
import com.metlife.jobportal.entity.JobPOJO;

@Service
public interface JobPortalService {

	public List<Job> findAll();

	public Job findById(int id);

	public Job findByJobCode(String jobCode);

	public Job save(JobPOJO job);

	public Job updateJob(String jobCode, long salary);

	List<Job> deleteByJobCode(String jobCode);
}
