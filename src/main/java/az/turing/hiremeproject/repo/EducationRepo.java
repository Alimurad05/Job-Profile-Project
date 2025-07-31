package az.turing.hiremeproject.repo;

import az.turing.hiremeproject.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education,Long> {
}
