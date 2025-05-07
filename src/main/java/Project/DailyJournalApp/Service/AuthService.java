package Project.DailyJournalApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Project.DailyJournalApp.DTO.AuthRequest;
import Project.DailyJournalApp.DTO.AuthResponse;
import Project.DailyJournalApp.DTO.RegisterRequest;
import Project.DailyJournalApp.Entity.User;
import Project.DailyJournalApp.Repository.UserRepository;
import Project.DailyJournalApp.Security.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	@Autowired
    private  UserRepository userRepo;
	
	@Autowired// Dependency Injection
    private  PasswordEncoder passwordEncoder;
	
	@Autowired// Dependency Injection
    private  JwtService jwtService;  
	
	@Autowired// Dependency Injection
    private  AuthenticationManager authenticationManager; // Dependency Injection

    // Register method to create a new user
    public ResponseEntity<String> register(RegisterRequest request) {
        // Create new user with data from RegisterRequest
    	User user = User.builder()
    	        .name(request.getName())
    	        .email(request.getEmail())
    	        .password(passwordEncoder.encode(request.getPassword()))
    	        .build();
    	        user.setRole("USER");
    	        
        // Save the user to the database
        userRepo.save(user); 
     
        // Return AuthResponse with generated token
        return ResponseEntity.ok("User Registered....");
    }

    // Login method for authenticating users
    public AuthResponse login(AuthRequest request) {
        // Authenticate using email and password provided in the request
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // Fetch the user from the repository based on email
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate JWT token after successful authentication
        String token = jwtService.generateToken(user);
        String role=user.getRole();
        // Return AuthResponse with generated token
        return new AuthResponse(token,role);
    }
}
