package az.turing.hiremeproject.service;

import az.turing.hiremeproject.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    void deleteUserById(Long id);
    List<UserResponse> searchUsers(String keyword);

}
