package az.turing.hiremeproject.repo;

import az.turing.hiremeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    @Query("SELECT u FROM User u WHERE LOWER(u.firstname) LIKE %:keyword% OR LOWER(u.lastname) LIKE %:keyword% OR LOWER(u.email) LIKE %:keyword%")
    List<User> search(@Param("keyword") String keyword);
}
