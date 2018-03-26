import java.util.ArrayList;
import java.util.Iterator;

public class Profile extends User {
	private ArrayList<String> friends = new ArrayList();
	private String pname;
	private String displaypic;
	private String status;
	
	
	public Profile(String name, int age) {
		super(name, age);
	}
	
	public Profile(String name, int age, String pname) {
		super(name, age);
		this.pname = pname;	
	}
	
	
	public void addFriends(String pname) {
		friends.add(pname);	
	}
	
	
	public void removeFriends(String pname) {
		friends.remove(pname);	
	}
	
	public ArrayList<String> getFriendlist() {
		
		return friends;
		
	}
	
	public String getName() {
		
		return this.pname;
		
	}
	
	
	public String printAllFriends() {
		
			String print = friends.toString();
			return print;				
				
		}

	
	public boolean searchFriends(String pname) {
		
		if (friends.contains(pname)) {
			return true;
		}
		else {
			return false;
		}
				
	}
	
	
	public void addStatus(String status) {
		this.status = status;	
	}
	
	public String getStatus() {
		return status;
	}
	
	public void changeName(String pname) {
		this.pname = pname;	
	}
	
	
	public void setDisplayPic(String dp) {
		this.displaypic = dp;
	}
	
	
	

  
}
