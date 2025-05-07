package Project.DailyJournalApp.Security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import Project.DailyJournalApp.Entity.User;
import Project.DailyJournalApp.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // Manually define the constructor for dependency injection
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Assuming the user has roles, you can dynamically fetch them
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole())  // Fetch roles from user.getRoles() if available
                .build();
    }
}
