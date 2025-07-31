package az.turing.hiremeproject.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String token
) {}
