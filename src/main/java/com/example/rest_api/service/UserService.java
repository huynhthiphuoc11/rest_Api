package com.example.rest_api.service;

import com.example.rest_api.Entity.User;
import com.example.rest_api.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Kiểm tra xem username đã tồn tại chưa
        if (userRepository.existsByUsername(user.getName())) {
            throw new RuntimeException("Username already exists");
        }

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Lưu người dùng mới vào cơ sở dữ liệu
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        // Tìm người dùng trong cơ sở dữ liệu bằng username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        // Trả về người dùng nếu xác thực thành công
        return user;
    }
}
