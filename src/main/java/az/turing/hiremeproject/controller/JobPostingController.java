package az.turing.hiremeproject.controller;

import az.turing.hiremeproject.dto.JobPostingRequest;
import az.turing.hiremeproject.dto.JobPostingResponse;
import az.turing.hiremeproject.service.JobPostingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-posting")
@RequiredArgsConstructor
public class JobPostingController {
    private final JobPostingService jobPostingService;
    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<JobPostingResponse> createJobPosting(@Valid @RequestBody JobPostingRequest jobPostingRequest) {
        JobPostingResponse jobPostingResponse = jobPostingService.createJobPosting(jobPostingRequest);
        return ResponseEntity.ok(jobPostingResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobPostingResponse> getJobPostingById(@Valid @PathVariable Long id) {
        JobPostingResponse response = jobPostingService.getJobPostingById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobPostingResponse>> getAllJobPostings() {
        List<JobPostingResponse> responses = jobPostingService.getAllJobPostings();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPostingById(@Valid @PathVariable Long id) {
        jobPostingService.deleteJobPostingById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobPostingResponse>> searchByJobField(@Valid @RequestParam String jobField) {
        List<JobPostingResponse> responses = jobPostingService.searchJobPostingByJobField(jobField);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/active")
    public ResponseEntity<List<JobPostingResponse>> getActiveJobPostings() {
        List<JobPostingResponse> responses = jobPostingService.getActiveJobPostings();
        return ResponseEntity.ok(responses);
    }
}
