
import java.util.*;


public class Driver {
	
	private ArrayList<Profile> profiles = new ArrayList<Profile>();
	private ArrayList<String> index = new ArrayList<String>();
	

	
	public  Driver() {		
		
		
		//Creating Demo Users
		Profile Allice = new Profile("Allice User",25,"Allice");
		Profile Don = new Profile("Don User",28,"Don");
		Profile Bob = new Profile("Bob User",35,"Bob");
		Profile Cathy = new Profile("Cathy User",45,"Cathy");
		Profile Jill = new Profile("Jill User",13,"Jill");
		Profile John = new Profile("John User",8,"John");
		Profile Nate = new Profile("Nate User",1,"Nate");
		
		profiles.add(Allice);
		index.add("Allice");
		
		profiles.add(Don);
		index.add("Don");
		
		profiles.add(Bob);
		index.add("Bob");
		
		profiles.add(Cathy);
		index.add("Cathy");
		
		profiles.add(Jill);
		index.add("Jill");
		profiles.get(4).setdemoParent("Allice","Don");
		profiles.get(0).setChildren("Jill");
		profiles.get(1).setChildren("Jill");
		
		profiles.add(John);
		index.add("John");
		profiles.get(5).setdemoParent("Cathy","Bob");
		profiles.get(2).setChildren("John");
		profiles.get(3).setChildren("John");
		
		profiles.add(Nate);
		index.add("Nate");
		profiles.get(6).setdemoParent("Cathy","Bob");
		profiles.get(2).setChildren("Nate");
		profiles.get(3).setChildren("Nate");
		

		profiles.get(0).addFriends("Don");
		profiles.get(1).addFriends("Allice");
		
		profiles.get(2).addFriends("Cathy");
		profiles.get(3).addFriends("Bob");
		
		profiles.get(4).addFriends("John");
		profiles.get(5).addFriends("Jill");
		
		
		viewMenu();	
		
		
	}
	
		
	
	
	
	public void viewMenu() {	
		
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println(" ");
		System.out.println("            MiniNet Menu");
		System.out.println("=========================================");
		System.out.println(" 1. List everyone");
		System.out.println(" 2. Select a person");
		System.out.println(" 3. Are these two direct friends?");
		System.out.println(" 4. Add a Profile");		
		System.out.println(" ?. Exit");
		
		String input = reader.nextLine();
			
		try {
		if (Integer.parseInt(input) == 1) {
			
			listProfiles();
			
			System.out.println("======================================");
			System.out.println(" ");

			System.out.println(" Press Enter to go Back to Menu");
			input = reader.nextLine();
			viewMenu();
			
		}
		else if (Integer.parseInt(input) == 2) {
			enterProfile();	
		}
		else if (Integer.parseInt(input) == 3) {
			searchTwoFriends();	
		}
		
		else if (Integer.parseInt(input) == 4) {
			addProfile();	
		}
		
		else if (input == "?") {
			System.out.println(" Thank You for Using MiniNet");	
			System.exit(0);
		} else {
			System.out.println(" Please Enter a valid Input");
			viewMenu();
			
		}
		
		} catch (Exception e) {
			System.out.println(" Please Enter a valid Input");
			viewMenu();
			
		}
		
	
	}
	
	
	
	public void enterProfile() {
		Scanner reader = new Scanner(System.in);
		System.out.println(" Enter the Profile Name");
		String name = reader.nextLine();
		viewProfile(name);
	
	}
	

	
	
	public void viewProfile(String name) {
		
		
		Scanner reader = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("           " + name);
		System.out.println("=========================================");
		System.out.println(" Username : "+ profiles.get(index.indexOf(name)).getUName());
		System.out.println(" Age : "+ profiles.get(index.indexOf(name)).getAge());
		System.out.println(" Status : " + profiles.get(index.indexOf(name)).getStatus());
		System.out.println(" Friend List: " + profiles.get(index.indexOf(name)).printAllFriends());
		
		if (profiles.get(index.indexOf(name)).getParents() != null) {
			System.out.println(" Parents: " + profiles.get(index.indexOf(name)).printParents());
		}
		if (profiles.get(index.indexOf(name)).getChildren() != null) {
			System.out.println(" Children: " + profiles.get(index.indexOf(name)).printChildren());
		}
		
		System.out.println("        ");
		
		System.out.println("1. To Add a Friend");
		System.out.println("2. To Delete Profile");
		System.out.println("3. Delete a Friend");
		System.out.println("4. Update Status");
		System.out.println("5. Upload Display Picture");
		System.out.println("6. Back to Menu");
		
		
		String input = reader.nextLine();
			
		try{
		if (Integer.parseInt(input) == 1) {
			addingFriends(name);
		}
		
		
		else if (Integer.parseInt(input) == 2) {
			removeMyProfile(name);
		}
		else if (Integer.parseInt(input) == 3) {
			System.out.println("Enter Friend's Name");
			input = reader.nextLine();
			
			profiles.get(index.indexOf(name)).removeFriends(input);
			profiles.get(index.indexOf(input)).removeFriends(name);
			
			System.out.println(input + " And you are no longer friends");
			System.out.println(" Click enter to go back to Profile");
			input = reader.nextLine();
			viewProfile(name);

			
				
		}
		else if (Integer.parseInt(input) == 4) {
			
			System.out.println("Enter the Status");
			input = reader.nextLine();
			profiles.get(index.indexOf(name)).addStatus(input);	
			System.out.println(" Your Status is updated to" + input);
			System.out.println(" Click enter to go back to Profile");
			input = reader.nextLine();
			viewProfile(name);
		}
		
		else if (Integer.parseInt(input) == 5) {
			
			System.out.println("Enter the Display Picture");
			input = reader.nextLine();
			profiles.get(index.indexOf(name)).setDisplayPic(input);
			System.out.println(" Your Display is updated to" + input);
			System.out.println(" Click enter to go back to Profile");
			input = reader.nextLine();
			viewProfile(name);
		}

		else if ((Integer.parseInt(input)) == 6) {
			viewMenu();	
		} 
		else {
			
			System.out.println("Please Enter a Valid Input");
			viewProfile(name);
			}
		}
		
		catch (Exception e) {
			
			System.out.println("Please Enter a Valid Input");
			viewProfile(name);
		}
		
		
		
	}
	
	
	
	public void listProfiles(){
		for (int i = 0; i < index.size(); i++) {	
			System.out.println("Profile "+ i + " : " + index.get(i));			
		}
		
		
		
		
	}
	
	
	
	
	
	
	public void addProfile(){
		//creating user
		
		try {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please Enter the Username");
		String username = reader.nextLine();
		System.out.println("Please Enter the Profile Name");
		String profilename = reader.nextLine();
		System.out.println("Please Enter the Age");
		int age = reader.nextInt();
		
		
		Profile user = new Profile(username,age,profilename);	
		profiles.add(user);
		index.add(profilename);
		
		
		if (age < 16) {
			profiles.get(index.indexOf(profilename)).setParent();
			
			ArrayList<String> parents = profiles.get(index.indexOf(profilename)).getParents();
			try {
			for(int i = 0; i < parents.size(); i++) {		
				  profiles.get(index.indexOf(parents.get(i))).setChildren(profilename);
			}
			}catch (Exception e) {
				System.out.println("!!!!! Parents do not exist on MiniNet");
				System.out.println("Press Enter to go back to Menu");
				System.out.println("======================================");
				age = reader.nextInt();
				viewMenu();
			}
			
		}

		System.out.println("Profile has been Successfully added");
		System.out.println("Click Enter to go back to Menu");
		String input = reader.nextLine();
		viewMenu();	
		
		
		} catch(Exception e) {
			System.out.println("Please enter a valid Input");
			addProfile();
		}
		
    }
	
	
	public void removeProfile(){
		//removing user
		Scanner reader = new Scanner(System.in);
		System.out.println("Please Enter the Profile Name");
		String profilename = reader.nextLine();
		int store = index.indexOf(profilename);
		 
		ArrayList<String> friends = profiles.get(store).getFriendlist();
		
		for (int i = 0; i < friends.size(); i++) {
			String name = friends.get(i);
			
			profiles.get(index.indexOf(name)).removeFriends(profilename);	
			
		}

		profiles.remove(store);
		index.remove(store);

		
		System.out.println("Profile has been Successfully Removed");
		System.out.println("Click Enter to go back to Menu");
		String input = reader.nextLine();
		viewMenu();
				
		
    }
	
	
	public void removeMyProfile(String profilename){
		//removing user
		
		int store = index.indexOf(profilename);
		 
		ArrayList<String> friends = profiles.get(store).getFriendlist();
		
		for (int i = 0; i < friends.size(); i++) {
			String name = friends.get(i);
			
			profiles.get(index.indexOf(name)).removeFriends(profilename);	
			
		}

		profiles.remove(store);
		index.remove(store);
		
		System.out.println("Profile has been Successfully Removed");
		System.out.println("Click Enter to go back to Profile");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();

		viewMenu();		
		
    }
	
	

	public void addingFriends(String name) {
		//adding friends
		try {
		
		Scanner reader = new Scanner(System.in);
		String input;
		if (profiles.get(index.indexOf(name)).getAge() <= 3) {
			System.out.println("Sorry !! Infants cannot have friends");
			System.out.println("Click Enter to go back to Profile");
			
			input = reader.nextLine();

			viewProfile(name);
			
		} 
		
		if(profiles.get(index.indexOf(name)).getAge() < 16 && profiles.get(index.indexOf(name)).getAge() > 2) {
			System.out.println("Please Enter the Profile Name of the Person");
			String profilename = reader.nextLine();
			
			if(profiles.get(index.indexOf(profilename)).getAge() < 16 && Math.abs(profiles.get(index.indexOf(profilename)).getAge() - profiles.get(index.indexOf(name)).getAge()) <=3 ) {
		
			
			profiles.get(index.indexOf(name)).addFriends(profilename);
			profiles.get(index.indexOf(profilename)).addFriends(name);
			
			System.out.println(profilename + "has been successfully added as your friend");
			System.out.println("Click Enter to go back to Profile");
			
			input = reader.nextLine();

			viewProfile(name);
			} else { 
				System.out.println("Sorry!! You can only add People who are Dependents and elder or younger to you not more than 3 years");
				System.out.println("Click Enter to go back to Profile");
				
				input = reader.nextLine();

				viewProfile(name);
			}
	
		}else {
		System.out.println("Please Enter the Profile Name of the Person");
		String profilename = reader.nextLine();

		profiles.get(index.indexOf(name)).addFriends(profilename);
		profiles.get(index.indexOf(profilename)).addFriends(name);
		
		System.out.println(profilename + "has been successfully added as your friend");
		System.out.println("Click Enter to go back to Profile");
		
		input = reader.nextLine();

		viewProfile(name);
		}
		} catch(Exception e) {
			System.out.println("The Friend you entered do not exist on MiniNet");
			
			System.out.println("Click Enter to go back to Profile");
			Scanner reader = new Scanner(System.in);
			String input = reader.nextLine();

			viewProfile(name);
		}
		
	}
	
	
	public void printFriendList(String name) {
		profiles.get(index.indexOf(name)).printAllFriends();
		
		
	}
	
	public void searchFriends(String name) {
		// Searching if a person is a friend of the profile owner
		Scanner reader = new Scanner(System.in);	
		System.out.println("Please Enter the Profile Name of the Person you need to Search");
		String profilename = reader.nextLine();
		
		
		if(profiles.get(index.indexOf(name)).searchFriends(profilename)) {
			System.out.println("Yes " + name + " is a friend of "+ profilename);	
		}else {
			System.out.println("No " + name + " is not a friend of "+ profilename);
		}
		System.out.println("Click Enter to go back to Menu");
		
		String input = reader.nextLine();

		viewMenu();	
	
	}
		
		public void searchTwoFriends() {
			//Searching two People are friends with each other
			Scanner reader = new Scanner(System.in);	
			System.out.println("Please Enter the Profile Name of the First Person");
			String profilename1 = reader.nextLine();
			System.out.println("Please Enter the Profile Name of the Second Person");
			String profilename2 = reader.nextLine();
			
			if(profiles.get(index.indexOf(profilename1)).searchFriends(profilename2)) {
				System.out.println("Yes " + profilename1 + " is a friend of "+ profilename2);	
			}else {
				System.out.println("No " + profilename1 + " is not a friend of "+ profilename2);
			}
			
			System.out.println("Click Enter to go back to Menu");
			
			String input = reader.nextLine();

			viewMenu();
			
			
		
	}
	
	
	
}
	
		


		
		
		
	

