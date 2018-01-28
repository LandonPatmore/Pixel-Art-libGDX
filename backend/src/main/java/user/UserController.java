package user;


import java.util.Random;

import scala.concurrent.forkjoin.ThreadLocalRandom;

import java.util.ArrayList;
import java.util.HashMap;

public class UserController {
private final ArrayList<Code> codes = new ArrayList<Code>();
private final HashMap<User, Code> userCodes = new HashMap<User, Code>();
//private int count = 0;
private ArrayList<Boolean> codesUsed = new ArrayList<Boolean>();

public UserController() {
	for(int x=0; x<10; x++) {
		Code c = new Code();
		while(codes.contains(c)) c = new Code();
		codes.add(c);
		codesUsed.add(false);
	}
//	count = 10;
	
}

public String getCode(User u) {
	Code c = userCodes.get(u);
	Code r = null;
	if(c == null) {
		for(int x=0; x<codesUsed.size(); x++) {
			if(codesUsed.get(x) == false) {
				r = codes.get(x);
				codesUsed.set(x, true);
			}
		}
		if(r == null) {
			Code g = new Code();
			while(codes.contains(g)) g = new Code();
			codes.add(g);
			codesUsed.add(true);
			r = g;
		}
	}
	else {
		r = c;
	}
	
	return r.term;
}

public boolean validateCode(String c) {
	for(Code cd: codes) {
		if(cd.comparewithString(c)) return true;
	}
	
	return false;
}


   

private final class Code{
	private String term;
	
	public Code() {
		generateCode();
	}
	
	protected void generateCode() {
		term = new String();
		Random r = ThreadLocalRandom.current();
		for(int x=0; x<10; x++) {
			term += toASCII(r.nextInt(49)+79);
		}
	}
	
	public boolean comparewithString(String str) {
		return term.equals(str);
	}
	
	private String toASCII(int value) {
	    int length = 4;
	    StringBuilder builder = new StringBuilder(length);
	    for (int i = length - 1; i >= 0; i--) {
	        builder.append((char) ((value >> (8 * i)) & 0xFF));
	    }
	    return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Code c = (Code) obj;
		return term.equals(c.term);
	}
	
	@Override
	public int hashCode() {
		return term.hashCode();
	}
}

}
