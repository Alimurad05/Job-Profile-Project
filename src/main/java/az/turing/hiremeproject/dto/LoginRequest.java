package az.turing.hiremeproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Email(message = "Email should be valid")
        String email,
        @Size(min = 6, message = "Password should be at least 6 characters")
        String password
) {
}
