package user;


public class User {
	private String name;
	private String hashedpassword;
	
	public User(String n, String p) {
		name = n;
		hashedpassword = p;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return hashedpassword;
	}
}
