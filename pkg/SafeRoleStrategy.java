package pkg;

import java.util.Arrays;
import java.util.ArrayList;

/**
  This role strategy carefully adds a set of roles to up to 3 users. 
  If one of the roles is admin, then it must be taken from another user since the number of admins cannot grow.
*/
public class SafeRoleStrategy implements Strategy {
	/**
	  Carefully add roles to 3 users.
	  Search roles parameter to deal with admin smartly.
	  If admin is in roles parameter, we search the users list to find any admins that can be reassigned.

	  @param users all the users
	  @param roles the roles to add
	  @return the modified users
	*/
	public User[] execute(User[] users, String[] roles){
		if (!(Arrays.asList(roles).contains(Role.ADMIN))){
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
		} else { // roles contains admin
			// find 3 users with admin role
			ArrayList<User> shift_users = new ArrayList<User>();
			for (User user : users){
				if (Arrays.asList(user.roles).contains("Role.ADMIN")) {
					shift_users.add(user);
				}
				
			}
			// skip the reassignment for now. Return the shift_users to see if this is working
			User[] result = new User[shift_users.size()];
			result = shift_users.toArray(result);
			return result;
		}
	}
}
