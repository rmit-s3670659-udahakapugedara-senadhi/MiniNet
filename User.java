
public class User {
    
	String name;
    int age;
    String type;  
    
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


    
    
}



