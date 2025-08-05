package az.turing.hiremeproject.service;

import az.turing.hiremeproject.dto.JobPostingRequest;
import az.turing.hiremeproject.dto.JobPostingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingServiceImpl implements JobPostingService {
    @Override
    public JobPostingResponse createJobPosting(JobPostingRequest jobPostingRequest) {
        return null;
    }

    @Override
    public JobPostingResponse getJobPostingById(Long id) {
        return null;
    }

    @Override
    public List<JobPostingResponse> getAllJobPostings() {
        return List.of();
    }

    @Override
    public void deleteJobPostingById(Long id) {

    }
}
