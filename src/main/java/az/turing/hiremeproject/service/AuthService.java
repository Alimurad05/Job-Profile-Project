package az.turing.hiremeproject.service;

import az.turing.hiremeproject.dto.AuthResponse;
import az.turing.hiremeproject.dto.LoginRequest;
import az.turing.hiremeproject.dto.RegisterRequest;
import az.turing.hiremeproject.entity.Role;
import az.turing.hiremeproject.entity.User;
import az.turing.hiremeproject.exception.EmailAlreadyExistsException;
import az.turing.hiremeproject.exception.UserNotFoundException;
import az.turing.hiremeproject.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        if(userRepo.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException("Email already exists" + request.email());
        }
        User user = new User();
        user.setFirstname(request.firstName());
        user.setLastname(request.lastName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);
        userRepo.save(user);
        String jwtToken = jwtService.generateToken(user.getEmail());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthResponse login(LoginRequest request) {
            authenticationManager.authenticate(
                    new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        User user = userRepo.findByEmail(request.email())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        String jwtToken = jwtService.generateToken(user.getEmail());
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

}
