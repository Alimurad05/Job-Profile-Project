package az.turing.hiremeproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        @Email(message = "Email should be valid")
        String email,
        @Size(min = 6, message = "Password should be at least 6 characters")
        @NotBlank(message = "Password is required")
        String password
) {

}
