package az.turing.hiremeproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    @CollectionTable(name = "job_posting_description",
            joinColumns = @JoinColumn(name = "job_posting_id"))
    @Column(name = "description")
    private List<String> description;
    private Boolean isActive;
    private LocalDate startDate;
    private LocalDate endDate;
    private String companyName;
    private String contactNumber;
    private String contactEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String jobField;
    @ElementCollection
    @CollectionTable(name = "job_posting_requirements",
        joinColumns = @JoinColumn(name = "job_posting_id"))
    @Column(name = "requirement")
    private List<String> requirements;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (isActive == null) {
            isActive = true;
        }
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }



}
