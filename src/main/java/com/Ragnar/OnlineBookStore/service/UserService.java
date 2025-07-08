package com.Ragnar.OnlineBookStore.service;
import com.Ragnar.OnlineBookStore.dto.UserDTO;
import com.Ragnar.OnlineBookStore.model.User;
import com.Ragnar.OnlineBookStore.model.Role;
import com.Ragnar.OnlineBookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.Ragnar.OnlineBookStore.dto.LoginDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements  UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public String registerUser(UserDTO userDTO){
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            return "Email already Registered";
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.valueOf(userDTO.getRole().toUpperCase())); // Convert string to enum

        userRepository.save(user);
        return "User registered successfully!";

    }

    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return "Login successful!";
        } else {

            return "Invalid credentials!";
        }

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: "+email));

    }


}
