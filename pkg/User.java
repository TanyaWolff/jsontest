package pkg;

import java.util.List;
import java.util.ArrayList;

public class User {
  public User() {
    first_name="John";
    last_name="Smith";
    roles=new ArrayList<>();
  }
  public User(String first, String last) {
    first_name=first;
    last_name=last;
  }
  public User(String first, String last, String email) {
    this.first_name=first;
    this.last_name=last;
    this.email=email;
  }
  public String getFirstname() {
	return first_name;
  }
  public String getLastname() {
	return last_name;
  }
  public String getEmail() {
	return email;
  }
  String first_name;
  String last_name;
  String address;
  String email;
  String phone;
  String userid;
  String id;
  List<String> roles;
}
