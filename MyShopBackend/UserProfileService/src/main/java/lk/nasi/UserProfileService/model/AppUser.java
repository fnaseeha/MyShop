package lk.nasi.UserProfileService.model;

public class AppUser {
	
	private String name;
	private String email;
	private boolean isAdmin;
	
	
	public AppUser(String name, String email, boolean isAdmin) {
		super();
		this.name = name;
		this.email = email;
		this.isAdmin = isAdmin;
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
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	

}
