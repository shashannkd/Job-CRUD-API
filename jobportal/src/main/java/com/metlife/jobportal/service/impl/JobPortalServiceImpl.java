package com.metlife.jobportal.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metlife.jobportal.entity.Job;
import com.metlife.jobportal.entity.JobPOJO;
import com.metlife.jobportal.exception.ResourceNotFoundException;
import com.metlife.jobportal.repository.JobPortalRepository;
import com.metlife.jobportal.service.JobPortalService;
import com.metlife.jobportal.util.Constants;

@Service
public class JobPortalServiceImpl implements JobPortalService {

	@Autowired
	private JobPortalRepository jobPortalRepository;

	@Override
	public List<Job> findAll() {
		Iterable<Job> jobs = jobPortalRepository.findAll();
		List<Job> jobList = new ArrayList<>();
		jobs.forEach(job -> jobList.add(job));
		return jobList;
	}

	@Override
	public Job findById(int id) {
		return jobPortalRepository.findById(id);
	}

	@Override
	public Job findByJobCode(String jobCode) {
		return jobPortalRepository.findByJobCode(jobCode);
	}

	@Override
	public Job save(JobPOJO job) {

		Job jobObj = null;
		try {
			if (jobPortalRepository.findByJobCode(job.getJobCode()) == null) {
				if (job.getJobCode() != null && job.getJobName() != null && job.getSalary() > 0) {
					jobObj = new Job(job.getJobCode(), job.getJobName(), job.getJobLocation(), job.getSalary(),
							Timestamp.from(Instant.now()).toString(), Constants.USER,
							Timestamp.from(Instant.now()).toString(), Constants.USER);
					jobPortalRepository.save(jobObj);
				}
			} else {
				System.out.println("Duplicate record!! Record already exists with this job code: " + job.getJobCode());
				return null;
			}
		} catch (Exception e) {
			System.out.println("Exception occured suring insert:" + e.getMessage());
		}

		return jobObj;
	}

	@Override
	public Job updateJob(String jobCode, long salary) {
		try {

			Job searchedJob = jobPortalRepository.findByJobCode(jobCode);
			searchedJob.setSalary(salary);
			searchedJob.setUpdatedDate(Timestamp.from(Instant.now()).toString());
			jobPortalRepository.save(searchedJob);
			System.out.println("Updated Job " + searchedJob);

		} catch (ResourceNotFoundException ex) {
			throw new ResourceNotFoundException("Job with Job code " + jobCode + " not found");
		} catch (Exception e) {
			System.out.println("Exception Occured while fetching job with job code " + jobCode + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Job> deleteByJobCode(String jobCode) {
		return jobPortalRepository.deleteByJobCode(jobCode);
	}

}
