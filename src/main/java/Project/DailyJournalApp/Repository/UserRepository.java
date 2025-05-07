package Project.DailyJournalApp.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.DailyJournalApp.Entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    //Optional<User> findByEmail(Object object);

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	void save(org.apache.catalina.User admin);

	Optional<User> findByUserId(UUID id);
}