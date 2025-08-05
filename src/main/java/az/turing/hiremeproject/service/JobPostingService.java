package az.turing.hiremeproject.service;

import az.turing.hiremeproject.dto.JobPostingRequest;
import az.turing.hiremeproject.dto.JobPostingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobPostingService {
    JobPostingResponse createJobPosting(JobPostingRequest jobPostingRequest);
    List<JobPostingResponse> getAllJobPostings();
    JobPostingResponse getJobPostingById(Long id);
    public void deleteJobPostingById(Long id);
}
