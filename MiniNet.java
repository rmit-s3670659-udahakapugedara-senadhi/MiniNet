import java.util.ArrayList;
import java.util.Scanner;

public class MiniNet {
	
	ArrayList<Profile> profiles = new ArrayList<Profile>();
	ArrayList<String> index = new ArrayList<String>();
	
	
	
	public  MiniNet() {		
		viewMenu();
		
		
		
	}
		
	public void viewMenu() {	
		
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("            MiniNet Menu");
		System.out.println("=========================================");
		System.out.println(" 1. List everyone");
		System.out.println(" 2. Select a person");
		System.out.println(" 3. Are these two direct friends?");
		System.out.println(" 4. Add a Profile");		
		System.out.println(" ?. Exit");
		
		String input = reader.nextLine();
			
		
		if (Integer.parseInt(input) == 1) {
			System.out.println(profiles.toString());
		}
		if (Integer.parseInt(input) == 2) {
			viewProfile();	
		}
		if (Integer.parseInt(input) == 3) {
			searchTwoFriends();	
		}
		
		if (Integer.parseInt(input) == 4) {
			addProfile();	
		}
		
		
		if (input == "?") {
			System.out.println(" Thank You for Using MiniNet");	
		}
		
	
	}
	
	
	public void viewProfile() {
		Scanner reader = new Scanner(System.in);
		System.out.println(" Enter the Profile Name");
		String name = reader.nextLine();
		
		System.out.println("           " + name);
		System.out.println("=========================================");
		System.out.println(" Username : "+ profiles.get(index.indexOf(name)).getUName());
		System.out.println(" Age : "+ profiles.get(index.indexOf(name)).getAge());
		System.out.println(" Status : " + profiles.get(index.indexOf(name)).getStatus());
		System.out.println(" Friend List: " + profiles.get(index.indexOf(name)).printAllFriends());
		
		System.out.println("1. To Add a Friend");
		System.out.println("2. To Delete Profile");
		System.out.println("3. Delete a Friend");
		System.out.println("4. Update Status");
		System.out.println("5. Upload Display Picture");
		System.out.println("6. Back to Menu");
		
		
		String input = reader.nextLine();
			
		
		if (Integer.parseInt(input) == 1) {
			addingFriends(name);
		}
		
		
		if (Integer.parseInt(input) == 2) {
			removeMyProfile(name);
		}
		if (Integer.parseInt(input) == 3) {
			System.out.println("Enter Friend's Name");
			input = reader.nextLine();
			
			profiles.get(index.indexOf(name)).removeFriends(input);
			profiles.get(index.indexOf(input)).removeFriends(name);
			
			System.out.println(input + " And you are no longer friends");
			System.out.println(" Click enter to go back to Profile");
			input = reader.nextLine();
			viewProfile();

			
			;	
		}
		if (Integer.parseInt(input) == 4) {
			
			System.out.println("Enter the Status");
			input = reader.nextLine();
			profiles.get(index.indexOf(name)).addStatus(input);	
			System.out.println(" Your Status is updated to" + input);
			System.out.println(" Click enter to go back to Profile");
			input = reader.nextLine();
			viewProfile();
		}
		
		if (Integer.parseInt(input) == 5) {
			
			System.out.println("Enter the Display Picture");
			input = reader.nextLine();
			profiles.get(index.indexOf(name)).setDisplayPic(input);
			System.out.println(" Your Display is updated to" + input);
			System.out.println(" Click enter to go back to Profile");
			input = reader.nextLine();
			viewProfile();
		}

		if ((Integer.parseInt(input)) == 6) {
			viewMenu();	
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public void addProfile(){
		//creating user
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
		
		System.out.println("Profile has been Successfully added");
		System.out.println("Click Enter to go back to Menu");
		String input = reader.nextLine();
		viewMenu();		
		
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

		viewProfile();		
		
    }
	
	

	public void addingFriends(String name) {
		//adding friends
				
		Scanner reader = new Scanner(System.in);	
		System.out.println("Please Enter the Profile Name of the Person");
		String profilename = reader.nextLine();

		profiles.get(index.indexOf(name)).addFriends(profilename);
		profiles.get(index.indexOf(profilename)).addFriends(name);
		
		System.out.println(profilename + "has been successfully added as your friend");
		System.out.println("Click Enter to go back to Profile");
		
		String input = reader.nextLine();

		viewProfile();
		
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
		
		
		
		
		
			
		
			
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

/*


Profile Allice = new Profile("Allice User",25,"Allice");
Profile Don = new Profile("Don User",28,"Don");
Profile Bob = new Profile("Bob User",35,"Bob");
Profile Cathy = new Profile("Cathy User",45,"Cathy");


//adding friends
Allice.addFriends(Don.getName());
Don.addFriends(Allice.getName());


Allice.addFriends(Bob.getName());
Bob.addFriends(Allice.getName());


Cathy.addFriends(Don.getName());
Don.addFriends(Cathy.getName());


//printing Dons friend List
Don.printAllFriends();


//Searching friendships

if ( Bob.searchFriends(Allice.getName())) {System.out.println("Yes");
	} else {System.out.println("No");}

if ( Cathy.searchFriends(Don.getName())) {System.out.println("Yes");}
else {System.out.println("No");}
*/

		
		
		
	

