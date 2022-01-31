package pkg;

import com.google.gson.Gson;
 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
  UserManager serializes and deserialized users and manipulates them.
*/
public class UserManager {

  /**
    Constructor.
  */
  public UserManager() {
	gson = new Gson();
  }

  /**
    Reads and deserializes multiple users from a specified file. The file must be in json format.

    @param file: filename specified as a relative path
    @return  an array of User objects
  */
  public User[] deserialize(String file) {

	String content = "";
	try {
		content = new String ( Files.readAllBytes( Paths.get(file) ) );
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	System.out.println("Read file "+file+" into String: "+content);
	User[] arr_obj = gson.fromJson(content, User[].class);
	return arr_obj;

  }

  /**
    Serializes multiple users and writes to a specified json file.

    @param users: array of User objects to serialize
    @param outfile: output filename specified as a relative path. It will be overwritten if it exists.
  */
  public void serialize(User[] users, String outfile) {

	String json = gson.toJson(users);
	System.out.println("Here are the stringified objects: "+json);
	//a) create the file
	try {
		File f = new File(outfile);
		if (!f.createNewFile()) {
			System.out.println("File already exists. It will be overwritten.");
		}
	} catch (IOException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
	//b) write to file
	try {
		FileWriter myWriter = new FileWriter(outfile);
		myWriter.write(json);
		myWriter.close();
		System.out.println("Success.");
	} catch (IOException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
  }

  /**
    Sanity check for serializing and deserializing users.
    Check that a single user object can be serialized and deserialized
    Check multiple users in a file are deserialized.
    Some of properties of all the users are displayed for a visual check.

    @param infile: input filename specified as a relative path.
  */
  public void test(String infile) {
	// serialize single user
	User obj = new User();
	String json = gson.toJson(obj);
	System.out.println("Here's the stringified object: "+json);

	// deserialize single user
	User obj2 = gson.fromJson(json, User.class);
	System.out.println("Here's the gson object: ");
	System.out.println(obj2);

	// read and deserialize multiple users from file
	User[] arr_obj = deserialize(infile);

	for(User user : arr_obj) {
		System.out.println(user.first_name+" "+user.last_name);
		System.out.println(user.address);
	}
  }
  /**
    Test that an existing property of users can be modified.
    The property modified is the email attribute. The input file contains emails, some empty, for each user.
    Users are read from file and deserialized, and a few are selected for modification.
    A new file containing the modified users is written.

    @param infile: input filename specified as a relative path.
    @param outfile: output filename specified as a relative path. It will be overwritten if it exists.
  */
  public void change_something(String infile, String outfile) {

	// read and deserialize multiple users from file
	User[] arr_obj = deserialize(infile);

	// change email of 3 users
        User[] modified_users = new User[3];
        for (int i=0; i<3; i++) {
		modified_users[i] = arr_obj[i];
		System.out.println(i+" before: "+modified_users[i].email);
		modified_users[i].email=modified_users[i].first_name+modified_users[i].last_name+"@example.com";
		System.out.println(i+" after: "+modified_users[i].email);
	}

	// serialize multiple users to json file
	serialize(modified_users, outfile);
  }
  /**
    Add the specified roles to the first 3 users in the UserManager.
    The property modified is the roles attribute. The input file does not contain roles.
    Users are read from file and deserialized, and a few are selected for modification.
    A new file containing the modified users is written.

    @param infile input filename specified as a relative path.
    @param outfile output filename specified as a relative path. It will be overwritten if it exists.
    @param roles the list of roles to add (must be strings in the Role interface)
    @see Role
  */
  public void add_roles(String infile, String outfile, String[] roles) {

	// read and deserialize multiple users from file
	User[] arr_obj = deserialize(infile);

	// Do something with roles
	User[] modified_users=strategy.execute(arr_obj, roles);

	// serialize multiple users to json file
	serialize(modified_users, outfile);
  }
  public void setStrategy(Strategy strategy) {
	this.strategy=strategy;
  }

  // use google's json converter
  private Gson gson;

  // strategy for role manipulation
  private Strategy strategy;
}
