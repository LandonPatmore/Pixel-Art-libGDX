package user;


import java.util.*;
import java.util.stream.*;

public class UserDoa {
private final List<User> users = new ArrayList<User>();
	
	 public User getUserByUsername(String username) {
	        return users.stream().filter(b -> b.getName().equals(username)).findFirst().orElse(null);
	    }

	    public Iterable<String> getAllUserNames() {
	        return users.stream().map(User::getName).collect(Collectors.toList());
	    }
	    
	    public void addUser(String user, String pass) {
	    	users.add(new User(user,pass));
	    }
}
