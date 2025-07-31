package az.turing.hiremeproject.dto;

public record RegisterRequest(
    String firstName,
    String lastName,
    String email,
    String password
) {

}
