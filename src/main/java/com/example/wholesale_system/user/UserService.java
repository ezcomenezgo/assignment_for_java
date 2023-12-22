package com.example.wholesale_system.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserByUsername(String username) {
        Users user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new RuntimeException(
                    "This user does not exist!"
            );
        }

        return user.toString();
    }
}
