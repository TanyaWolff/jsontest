package pkg;

import com.google.gson.Gson;
 
import java.io.FileReader;
import java.util.Iterator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Demo {

  public static final String DATAFILE="users.json";

  public static void main(String[] args) {
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
 
        try
        {
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
}
