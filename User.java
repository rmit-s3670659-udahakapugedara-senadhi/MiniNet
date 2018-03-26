import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
    
	String name;
    int age;
    String type;  
    ArrayList<String> parents = new ArrayList<String>();
    ArrayList<String> children = new ArrayList<String>();
    
    
    public User(String name, int age) {
    	this.name = name;
    	this.age = age;
    	if(age <= 16 && age > 2) {
    		this.type = "Dependent";	
    	}
    	if(age <= 2) {
    		this.type = "Child";	
    	}
    	if(age > 16) {
    		this.type = "Adult";	
    	}
    }  
    
public String getUName() {
	
	return this.name;
	
}

public String getType() {
	
	return this.type;
	
}

public int getAge() {
	
	return this.age;
	
}

public void setChildren(String input) {
	children.add(input);
}

public ArrayList<String> getChildren() {
	
	return this.children;
	
}

public void setParent() {
	System.out.println("Enter Mother's Profile Name");
	Scanner reader = new Scanner(System.in);
	String input1  = reader.nextLine();
	System.out.println("Enter Father's Profile Name");
	String input2  = reader.nextLine();
	
	parents.add(input1);
	parents.add(input2);

}

public ArrayList<String> getParents() {
	
	return this.parents;
	
}

public String printParents() {
	
	return parents.toString();
	
}

public String printChildren() {
	
	return children.toString();
	
}

    
    
}



