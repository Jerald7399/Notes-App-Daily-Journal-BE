package Project.DailyJournalApp.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Project.DailyJournalApp.Entity.Note;
import Project.DailyJournalApp.Entity.User;
import Project.DailyJournalApp.Repository.NoteRepository;
import Project.DailyJournalApp.Repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Note> getAllNotesForAdmin() {
	    return noteRepository.findAll();
	}

	public void deleteNoteById(UUID id) {
	    noteRepository.deleteById(id);
	}

	public Note createNoteForUser(UUID userId, Note note) {
	    User user = userRepository.findById(userId).orElseThrow();
	    note.setUser(user);
	    return noteRepository.save(note);
	}

	public List<Note> searchNotesByKeyword(String keyword) {
	    return noteRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
	}

	public Object getAllUsers() {
		
		return userRepository.findAll();
	}
	
	public void deleteNote(UUID id) {
        noteRepository.deleteById(id);
    }
	public Object getNotesByTag(String tag) {
	    return noteRepository.findByTagsContaining(tag);
	}

	public Object getNotesByDateRange(LocalDate startDate, LocalDate endDate) {
	    LocalDateTime start = startDate.atStartOfDay();
	    LocalDateTime end = endDate.atTime(LocalTime.MAX);
	    return noteRepository.findByCreatedAtBetween(start, end);
	}

	public Object getAllNotes(String sortBy) {
	    Sort sort = Sort.by(Sort.Direction.DESC, 
	        sortBy.equalsIgnoreCase("updated") ? "updatedAt" : "createdAt");
	    return noteRepository.findAll(sort);
	}


//	public Optional<User> getUserById(UUID id) {
//	    return userRepository.findById(id);
//	}

	public Object getuserById(UUID id) {

		 return userRepository.findById(id);
	}



}
