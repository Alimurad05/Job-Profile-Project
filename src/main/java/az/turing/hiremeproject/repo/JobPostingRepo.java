package az.turing.hiremeproject.repo;

import az.turing.hiremeproject.dto.JobPostingResponse;
import az.turing.hiremeproject.entity.JobPosting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobPostingRepo extends JpaRepository<JobPosting,Long> {
    @Query("SELECT j FROM JobPosting j WHERE LOWER(j.jobField) = LOWER(:jobField)")
    Optional<List<JobPosting>> findJobPostingsByJobField(String jobField);
    Optional<List<JobPosting>> findJobPostingsByIsActive(Boolean isActive);


}
