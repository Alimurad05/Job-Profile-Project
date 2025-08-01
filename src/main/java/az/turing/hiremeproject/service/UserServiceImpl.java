package az.turing.hiremeproject.service;

import az.turing.hiremeproject.dto.UserResponse;
import az.turing.hiremeproject.entity.User;
import az.turing.hiremeproject.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteUserById(Long id) {
        User user= userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepo.delete(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepo.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    }

    @Override
    public List<UserResponse> searchUsers(String keyword) {
        return userRepo.search(keyword.toLowerCase()).stream()
                .map(this::mapToResponse)
                .toList();
    }
    private UserResponse mapToResponse(User user) {
        return new UserResponse(user.getFirstname(), user.getLastname(), user.getEmail(), user.getRole());
    }
}
