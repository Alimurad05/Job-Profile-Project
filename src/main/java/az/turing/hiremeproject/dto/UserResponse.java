package az.turing.hiremeproject.dto;

import az.turing.hiremeproject.entity.Role;

public record UserResponse(
        String firstName,
        String lastName,
        String email,
        Role role
) {
}
