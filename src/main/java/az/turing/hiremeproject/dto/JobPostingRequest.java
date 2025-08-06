package az.turing.hiremeproject.dto;

import java.time.LocalDate;
import java.util.List;

public record JobPostingRequest(
         String title,
         List<String> description,
         LocalDate startDate,
         LocalDate endDate,
         String companyName,
         String contactNumber,
         String contactEmail,
         List<String> requirements,
         String jobField
) {
}
