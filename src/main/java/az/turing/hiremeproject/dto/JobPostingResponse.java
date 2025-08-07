package az.turing.hiremeproject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record JobPostingResponse(
        Long id,
        String title,
        List<String> description,
        Boolean isActive,
        LocalDate startDate,
        LocalDate endDate,
        String companyName,
        String contactNumber,
        String contactEmail,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<String> requirements,
        String jobField
) {
}
