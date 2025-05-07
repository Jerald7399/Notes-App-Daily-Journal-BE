package Project.DailyJournalApp.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.DailyJournalApp.Entity.Note;
import Project.DailyJournalApp.Entity.User;
import Project.DailyJournalApp.Service.AdminService;


@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    

    @Autowired
    private AdminService adminService;

    // ✅ Get all notes from all users
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(adminService.getAllNotesForAdmin());
    }

    // ✅ Get all users
    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getuserById(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.getuserById(id));
    }

    // ✅ Delete any note by ID
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable UUID id) {
    	adminService.deleteNote(id);
        return ResponseEntity.ok("Note deleted by admin");
    }

    // ✅ Add note for a specific user
    @PostMapping("/notes/{userId}")
    public ResponseEntity<Note> createNoteForUser(@PathVariable UUID userId, @RequestBody Note note) {
        return ResponseEntity.ok(adminService.createNoteForUser(userId, note));
    }

    // ✅ Filter notes by keyword
    @GetMapping("/notes/search")
    public ResponseEntity<List<Note>> searchNotes(@RequestParam String keyword) {
        return ResponseEntity.ok(adminService.searchNotesByKeyword(keyword));
    }
    
    @GetMapping("/filter/tag")
    public ResponseEntity<Object> getNotesByTag(@RequestParam String tag) {
        return ResponseEntity.ok(adminService.getNotesByTag(tag));
    }

    @GetMapping("/filter/date-range")
    public ResponseEntity<Object> getNotesByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(adminService.getNotesByDateRange(startDate, endDate));
    }

    @GetMapping("/date")
    public ResponseEntity<Object> getAllNotes(
            @RequestParam(name = "sortBy", defaultValue = "created") String sortBy) {
        return ResponseEntity.ok(adminService.getAllNotes(sortBy));
    }

}
