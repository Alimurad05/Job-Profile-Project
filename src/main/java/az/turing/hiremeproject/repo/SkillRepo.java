package az.turing.hiremeproject.repo;

import az.turing.hiremeproject.entity.Skill;
import az.turing.hiremeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill,Long> {
}
