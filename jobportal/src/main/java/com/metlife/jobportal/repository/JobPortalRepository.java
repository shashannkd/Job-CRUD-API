package com.metlife.jobportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metlife.jobportal.entity.Job;
import com.metlife.jobportal.entity.JobPOJO;

@Repository
public interface JobPortalRepository extends CrudRepository<Job, Integer> {
	List<Job> findAll();

	Job findById(int id);

	Job findByJobCode(String jobCode);

	Job save(JobPOJO job);

	Job save(Job job);

	List<Job> deleteByJobCode(String jobCode);

}
