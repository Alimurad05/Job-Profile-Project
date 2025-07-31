package az.turing.hiremeproject.dto;

public record LoginRequest(
    String email,
    String password
) {
}
