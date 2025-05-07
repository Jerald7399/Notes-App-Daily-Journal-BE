package Project.DailyJournalApp.Controller;

import Project.DailyJournalApp.Entity.Note;
import Project.DailyJournalApp.Service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")

public class NoteController {
    private final NoteService noteService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(noteService.getAllNotes(userDetails.getUsername()));
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note, 
                                         @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(noteService.createNote(note, userDetails.getUsername()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable UUID id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable UUID id, @RequestBody Note updatedNote) {
        return ResponseEntity.ok(noteService.updateNote(id, updatedNote));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable UUID id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/tag")
    public ResponseEntity<List<Note>> getNotesByTag(@RequestParam String tag,
                                                  @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(noteService.getNotesByTag(tag, userDetails.getUsername()));
    }

    @GetMapping("/filter/date-range")
    public ResponseEntity<List<Note>> getNotesByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(noteService.getNotesByDateRange(startDate, endDate, userDetails.getUsername()));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(@RequestParam String query,
                                                  @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(noteService.searchNotes(query, userDetails.getUsername()));
    }
  
    
    @GetMapping("/date")
    public ResponseEntity<List<Note>> getAllNotes(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(name = "sortBy", defaultValue = "created") String sortBy) {
        return ResponseEntity.ok(noteService.getAllNotes(userDetails.getUsername(), sortBy));
    }
}