package Project.DailyJournalApp.Service;

import Project.DailyJournalApp.Entity.Note;
import Project.DailyJournalApp.Entity.User;
import Project.DailyJournalApp.Repository.NoteRepository;
import Project.DailyJournalApp.Repository.UserRepository;
import org.springframework.data.domain.Sort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public List<Note> getAllNotes(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return noteRepository.findByUser(user);
    }

    public Note createNote(Note note, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        note.setUser(user);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public Note getNoteById(UUID id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public Note updateNote(UUID id, Note updatedNote) {
        Note existing = getNoteById(id);
        existing.setTitle(updatedNote.getTitle());
        existing.setContent(updatedNote.getContent());
        existing.setTags(updatedNote.getTags());
        existing.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(existing);
    }

    public void deleteNote(UUID id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getNotesByTag(String tag, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return noteRepository.findByUserAndTagsContaining(user, tag);
    }

    public List<Note> getNotesByDateRange(LocalDate startDate, LocalDate endDate, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(LocalTime.MAX);
        return noteRepository.findByUserAndCreatedAtBetween(user, start, end);
    }

    public List<Note> searchNotes(String query, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return noteRepository.findByUserAndContentContainingIgnoreCase(user, query);
    }
    
    public List<Note> getAllNotes(String email, String sortBy) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy.equalsIgnoreCase("updated") ? "updatedAt" : "createdAt");

        return noteRepository.findByUser(user, sort);
    }
    
    public List<Note> getAllNotesForAdmin() {
        return noteRepository.findAll();
    }
}