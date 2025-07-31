package az.turing.hiremeproject.repo;

import az.turing.hiremeproject.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepo extends JpaRepository<JobApplication, Long> {
    // Additional query methods can be defined here if needed
}
