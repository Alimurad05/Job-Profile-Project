package az.turing.hiremeproject.mapper;

import az.turing.hiremeproject.dto.JobPostingRequest;
import az.turing.hiremeproject.dto.JobPostingResponse;
import az.turing.hiremeproject.entity.JobPosting;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface JobPostingMapper {
    JobPosting toEntity(JobPostingRequest jobPostingRequest);
    JobPostingResponse toResponse(JobPosting jobPosting);
}
