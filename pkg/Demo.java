package pkg;

import com.google.gson.Gson;
 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Demo {

  public static final String DATAFILE="users.json";
  public static final String NEWDATAFILE="newusers.json";

  public static void main(String[] args) {
	//test(args);
	//change_something(args);
	String[] roles={Role.ADMIN,Role.USER};
	add_roles(roles);
  }
  public static void test(String[] args) {
	// serialize single user
	User obj = new User();
	Gson gson = new Gson();
	String json = gson.toJson(obj);  
	System.out.println("Here's the stringified object: "+json);

	// deserialize single user
	User obj2 = gson.fromJson(json, User.class);
	System.out.println("Here's the gson object: ");
	System.out.println(obj2);

	// read and deserialize multiple users from file
	String content = "";
	try {
		content = new String ( Files.readAllBytes( Paths.get(DATAFILE) ) );
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	System.out.println(content);
	User[] arr_obj = gson.fromJson(content, User[].class);
	for(User user : arr_obj) {
		System.out.println(user.first_name+" "+user.last_name);
		System.out.println(user.address);
	}
  }
  public static void change_something(String[] args) {

	Gson gson = new Gson();
	// read and deserialize multiple users from file
	String content = "";

	try {
		content = new String ( Files.readAllBytes( Paths.get(DATAFILE) ) );
	}
	catch (IOException e) {
            e.printStackTrace();
	}
	User[] arr_obj = gson.fromJson(content, User[].class);
	// change email of 3 users
        User[] modified_users = new User[3];
        for (int i=0; i<3; i++) {
		modified_users[i] = arr_obj[i];
		System.out.println(i+" before: "+modified_users[i].email);
		modified_users[i].email=modified_users[i].first_name+modified_users[i].last_name+"@example.com";
		System.out.println(i+" after: "+modified_users[i].email);
	}
	String json = gson.toJson(modified_users);
	System.out.println("Here are the stringified objects: "+json);

	// serialize multiple users to json file
	//a) create the file
	try {
		File f = new File(NEWDATAFILE);
		if (!f.createNewFile()) {
			System.out.println("File already exists. It will be overwritten.");
		}
	} catch (IOException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
	//b) write to file
	try {
		FileWriter myWriter = new FileWriter(NEWDATAFILE);
		myWriter.write(json);
		myWriter.close();
		System.out.println("Success.");
	} catch (IOException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
  }
  public static void add_roles(String[] roles) {

	Gson gson = new Gson();
	// read and deserialize multiple users from file
	String content = "";

	try {
		content = new String ( Files.readAllBytes( Paths.get(DATAFILE) ) );
	}
	catch (IOException e) {
            e.printStackTrace();
	}
	User[] arr_obj = gson.fromJson(content, User[].class);
	// Add admin role to 3 users
        User[] modified_users = new User[3];
        for (int i=0; i<3; i++) {
		modified_users[i] = arr_obj[i];
		System.out.println(i+" before: "+modified_users[i].roles);
		for(String role : roles) {
		  modified_users[i].roles.add(role);
		}
		System.out.println(i+" after: "+modified_users[i].roles);
	}
	String json = gson.toJson(modified_users);
	System.out.println("Here are the stringified objects: "+json);

	// serialize multiple users to json file
	//a) create the file
	try {
		File f = new File(NEWDATAFILE);
		if (!f.createNewFile()) {
			System.out.println("File already exists. It will be overwritten.");
		}
	} catch (IOException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
	//b) write to file
	try {
		FileWriter myWriter = new FileWriter(NEWDATAFILE);
		myWriter.write(json);
		myWriter.close();
		System.out.println("Success.");
	} catch (IOException e) {
		System.out.println("Error!");
		e.printStackTrace();
	}
  }
}
