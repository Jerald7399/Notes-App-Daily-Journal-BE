package Project.DailyJournalApp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String token;
    private String role;

    
	public AuthResponse() {
		
	}

	public AuthResponse(String token, String role) {
		super();
		this.token = token;
		this.role = role;
	}

	
}