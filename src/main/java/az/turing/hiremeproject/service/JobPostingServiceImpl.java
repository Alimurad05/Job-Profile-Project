package az.turing.hiremeproject.service;

import az.turing.hiremeproject.dto.JobPostingRequest;
import az.turing.hiremeproject.dto.JobPostingResponse;
import az.turing.hiremeproject.entity.JobPosting;
import az.turing.hiremeproject.exception.SecurityException;
import az.turing.hiremeproject.exception.UserNotFoundException;
import az.turing.hiremeproject.mapper.JobPostingMapper;
import az.turing.hiremeproject.repo.JobPostingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class JobPostingServiceImpl implements JobPostingService {
    private final JobPostingRepo jobPostingRepo;
    private final JobPostingMapper jobPostingMapper;
    @Override
    public JobPostingResponse createJobPosting(JobPostingRequest jobPostingRequest) {
        JobPosting jobPosting = jobPostingMapper.toEntity(jobPostingRequest);
        JobPosting jobPostingSaved = jobPostingRepo.save(jobPosting);
        return jobPostingMapper.toResponse(jobPostingSaved);
    }

    @Override
    public JobPostingResponse getJobPostingById(Long id) {
        JobPosting jobPosting = jobPostingRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Job posting not found with id: " + id));
        return jobPostingMapper.toResponse(jobPosting);
    }

    @Override
    public List<JobPostingResponse> getAllJobPostings() {
        return jobPostingRepo.findAll()
                .stream()
                .map(jobPostingMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteJobPostingById(Long id) {
        JobPosting jobPosting = jobPostingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job posting not found with id: " + id));
    String currentEmail= SecurityContextHolder.getContext().getAuthentication().getName();
    if(!jobPosting.getCreatedBy().getEmail().equals(currentEmail)){
        throw new SecurityException("You are not authorized to delete this job posting");
    }
    jobPostingRepo.delete(jobPosting);

    }
    @Override
    public List<JobPostingResponse> searchJobPostingByJobField(String jobField) {
        List<JobPosting> jobPostings = jobPostingRepo.findJobPostingsByJobField(jobField.toLowerCase())
                .orElseThrow(() -> new UserNotFoundException("No job postings found for job field: " + jobField));
        return jobPostings.stream()
                .map(jobPostingMapper::toResponse)
                .toList();
    }
    @Override
    public List<JobPostingResponse> getActiveJobPostings() {
        List<JobPosting> jobPostings = jobPostingRepo.findJobPostingsByIsActive(true)
                .orElseThrow(() -> new UserNotFoundException("No active job postings found"));
        return jobPostings.stream()
                .map(jobPostingMapper::toResponse)
                .collect(toList());
    }

}
