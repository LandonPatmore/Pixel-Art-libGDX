package Attempt_1.backend_maven;

/**
 * Hello world!
 *
 */

import static spark.Spark.*;

import database.Grid;
import user.User;
import user.UserController;
import user.UserDoa;

public class App 
{
    public static void main( String[] args )
    {
    	UserDoa userdoa = new UserDoa();
    	UserController uc = new UserController();
    	Grid grid = new Grid(50,50);
    	
    	 get("/hello", (req, res) -> "Hello World");
    	 post("/login", (req,res) -> {
    		String body = req.body();
    		String s = "\"username\":";
    		int u = body.indexOf(s);
    		int e = 0;
    		for(int x=u; x<body.length(); x++) {
    			if(body.charAt(x)== ',') {
    				e = x-1;
    				break;
    			}
    		}
    		if(e == 0) {
    			return "ERROR";
    		}
    		String username = body.substring(u+s.length()+2,e);
    		System.out.println(username);
    		
    		String p = "\"password\":";
    		u = body.indexOf(p);
    		e= body.lastIndexOf("\"");
    		
    		String password = body.substring(u+p.length()+2,e);
    		System.out.println(password);
    		
    		User curUse = userdoa.getUserByUsername(username);
    		if(curUse == null) {
    			userdoa.addUser(username, password);
    		}
    		
    		return uc.getCode(curUse);
    	
    	 });
    	 
    	  post("/changePixel", (req,res) ->{
    		  String body = req.body();
      		String s = "\"position\":";
      		int u = body.indexOf(s);
      		int e = 0;
      		boolean passed = false;
      		for(int x=u; x<body.length(); x++) {
      			if(body.charAt(x)== ',') {
      				e = x-1;
      				if(passed) break;
      				else passed = true;
      			}
      		}
      		if(e == 0) {
      			return "ERROR";
      		}
      		String position = body.substring(u+s.length()+2,e);
      		System.out.println(position);
      		
      		String p = "\"color\":";
    		u = body.indexOf(p);
    		//e = body.length()-4;
    		e = body.lastIndexOf("\"");
    		
    		String color = body.substring(u+p.length()+2,e);
    		System.out.println(color);
      		
    		int x = Integer.parseInt(""+position.charAt(0));
    		int y = Integer.parseInt(""+position.charAt(2));
    		
    		grid.changePixel(color, x, y);
    		
      		return "Sucess";
    	  });
    	
    }
}
