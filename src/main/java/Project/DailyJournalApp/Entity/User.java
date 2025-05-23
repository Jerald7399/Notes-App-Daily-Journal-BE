package Project.DailyJournalApp.Entity;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")

public class User {
	
	@Id
    @GeneratedValue
    private UUID id;

    private String name;
    
    private UUID userId;
    
   
	@Column(unique = true, nullable = false)
    private String email;
    
    private String password;
    
    private String role;
    
    

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	 public UUID getUserId() {
			return userId;
		}

		public void setUserId(UUID userId) {
			this.userId = userId;
		}


	

    // --- Manual Builder ---
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder id(UUID id) {
            user.setId(id);
            return this;
        }

        public Builder name(String object) {
            user.setName(object);
            return this;
        }

        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
