package pkg;

/**
  This role strategy adds a set of roles to 3 users.
*/
public class SimpleRoleStrategy implements Strategy {
	/**
	  Blindly adds roles to 3 users.

	  @param users all the users
	  @param roles the roles to add
	  @return the modified users
	*/
	public User[] execute(User[] users, String[] roles){
		// Add admin role to 3 users
		User[] modified_users = new User[3];
		for (int i=0; i<3; i++) {
			modified_users[i] = users[i];
			for(String role : roles) {
			  modified_users[i].roles.add(role);
			}
			System.out.println(i+" after: "+modified_users[i].roles);
		}
		return modified_users;
	}
}
