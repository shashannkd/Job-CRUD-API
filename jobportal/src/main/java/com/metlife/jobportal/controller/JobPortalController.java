package com.metlife.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metlife.jobportal.entity.Job;
import com.metlife.jobportal.entity.JobPOJO;
import com.metlife.jobportal.service.impl.JobPortalServiceImpl;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
public class JobPortalController {

	@Autowired
	private JobPortalServiceImpl jobPortalService;

	@RequestMapping("/welcome")
	public String welcome() {
		return "<h1>Hello, Welcome to the Job Portal" + "\uD83D\uDC4D" + "</h1>";
	}

	@GetMapping(value = "/getAllJobs", produces = "application/json")
	public ResponseEntity<List<Job>> getAllJobs() throws JsonProcessingException {

		List<Job> jobList = jobPortalService.findAll();
		System.out.println("Retrieved all records successfully! \n" + jobList);
		return new ResponseEntity<List<Job>>(jobList, HttpStatus.OK);
	}

	@GetMapping("/getJobById")
	public Job getJobById(@RequestParam("id") int id) {
		Job job = jobPortalService.findById(id);
		System.out.println("job response: " + job);
		return job;
	}

	@GetMapping("/getJobByJobCode/{jobCode}")
	public Job getJobByJobCode(@PathVariable("jobCode") String jobCode) {
		Job job = jobPortalService.findByJobCode(jobCode);
		System.out.println("job response: " + job);
		return job;
	}

	@PostMapping(value = "/addJob", consumes = "application/json")
	public ResponseEntity<String> createJob(@RequestBody JobPOJO jobObject) {

		Job job = jobPortalService.save(jobObject);
		System.out.println("job response: " + job);
		return job != null
				? new ResponseEntity<>("The job with code " + jobObject.getJobCode() + " is inserted.",
						HttpStatus.CREATED) // 201
				: new ResponseEntity<>(
						"The creation of job with code " + jobObject.getJobCode()
								+ " has failed due to internal error or duplicate record.",
						HttpStatus.INTERNAL_SERVER_ERROR); // 500
	}

	@PutMapping(value = "/updateJobSalaryByJobCode/{jobCode}")
	public ResponseEntity<String> updateJobSalary(@PathVariable("jobCode") String jobCode, @RequestBody JobPOJO jobPojo) {
		Job job = jobPortalService.updateJob(jobCode, jobPojo.getSalary());

		return new ResponseEntity<>("The PUT/Update request is successful for the job code: " + jobCode,
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByJobCode/{jobCode}")
	public ResponseEntity<String> deleteByJobCode(@PathVariable("jobCode") String jobCode) {
		List<Job> jobList = jobPortalService.deleteByJobCode(jobCode);
		System.out.println("Deleted Records List: " + jobList);
		return jobList.size() > 0
				? new ResponseEntity<String>("Delete Successful. " + jobList.size() + " records deleted.",
						HttpStatus.OK) // 200
				: new ResponseEntity<String>(
						"Deletion Falied. " + "Failure due to no record(s) with the" + jobCode + " or Internal Error.",
						HttpStatus.INTERNAL_SERVER_ERROR); // 500
	}

}
