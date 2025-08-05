package az.turing.hiremeproject.repo;

import az.turing.hiremeproject.entity.JobPosting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepo extends JpaRepository<JobPosting,Long> {

}
