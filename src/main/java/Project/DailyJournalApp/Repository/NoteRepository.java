package Project.DailyJournalApp.Repository;

import Project.DailyJournalApp.Entity.Note;
import org.springframework.data.domain.Sort;
import Project.DailyJournalApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findByUser(User user);
	List<Note> findByUserAndTagsContaining(User user, String tag);
	List<Note> findByUserAndCreatedAtBetween(User user, LocalDateTime start, LocalDateTime end);
	List<Note> findByUserAndContentContainingIgnoreCase(User user, String query);	
	
	List<Note> findByUser(User user, Sort sort);
	List<Note> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);
	
	List<Note> findByTagsContaining(String tag);

	
	List<Note> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);


	List<Note> findAll(Sort sort);
}