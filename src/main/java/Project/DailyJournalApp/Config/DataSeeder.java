//package Project.DailyJournalApp.Config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import Project.DailyJournalApp.Entity.User;
//import Project.DailyJournalApp.Repository.UserRepository;
//
//@Component
//public class DataSeeder implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (!userRepository.existsByEmail("admin")) {
//            User admin=new User();
//            admin.setName("admin");
//            admin.setEmail("admin@gmail.com");
//            admin.setPassword(passwordEncoder.encode("Admin@1234"));
//            admin.setRole("ADMIN");
//            userRepository.save(admin);
//        }
//    }
//}