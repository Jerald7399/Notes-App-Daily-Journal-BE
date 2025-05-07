package Project.DailyJournalApp.DTO;

import lombok.Data;


public class AuthRequest {
	
	private String email;
	private String password;
	
	
	
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
	
	
	
//    public String getEmail() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Object getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Object getEmail11() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Object getEmail1() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Object getPassword11() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public Object getPassword1() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}